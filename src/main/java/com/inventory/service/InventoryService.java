package com.inventory.service;

import com.inventory.model.*;
import com.inventory.data.SampleData;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class InventoryService {

    public List<Store> getAllStores() {
        return SampleData.getAllStores();
    }

    public Store getStore(String storeId) {
        return SampleData.getStoreById(storeId);
    }

    public Analysis analyzeStore(String storeId) {
        Store store = getStore(storeId);
        if (store == null) return null;

        Map<String, Integer> velocity = SampleData.getSalesVelocity(storeId);
        List<Analysis.Recommendation> recommendations = new ArrayList<>();

        for (Product product : store.getInventory()) {
            int weeklyVelocity = velocity.getOrDefault(product.getProductId(), 5);
            double weeksOfSupply = product.getStock() / (double) Math.max(weeklyVelocity, 1);

            if (weeksOfSupply > 12) {
                int recommended = Math.max(weeklyVelocity * 4, 10);
                double saved = (product.getStock() - recommended) * product.getCost();

                recommendations.add(new Analysis.Recommendation(
                        product.getProductName(),
                        "OVERSTOCK",
                        product.getStock(),
                        weeksOfSupply,
                        recommended,
                        "Transfer to another store or mark down",
                        String.format("Free up $%,.0f in working capital", saved)
                ));
            } else if (weeksOfSupply < 2) {
                double lostSales = weeklyVelocity * 3
                        * (product.getRetailPrice() - product.getCost());

                recommendations.add(new Analysis.Recommendation(
                        product.getProductName(),
                        "UNDERSTOCK",
                        product.getStock(),
                        weeksOfSupply,
                        weeklyVelocity * 6,
                        "Reorder or transfer in from a nearby store",
                        String.format("Prevent $%,.0f in lost sales", lostSales)
                ));
            }
        }

        long overstock = recommendations.stream()
                .filter(r -> "OVERSTOCK".equals(r.getIssue())).count();
        long understock = recommendations.stream()
                .filter(r -> "UNDERSTOCK".equals(r.getIssue())).count();

        String summary = String.format(
                "Found %d overstock and %d understock items", overstock, understock);

        return new Analysis(
                store.getStoreId(),
                store.getStoreName(),
                store.getTotalValue(),
                recommendations,
                summary
        );
    }
}