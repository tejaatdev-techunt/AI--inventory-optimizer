package com.inventory.service;

import com.inventory.model.*;
import com.inventory.data.SampleData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.*;

@Slf4j
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
                int recommended = Math.max((int)(weeklyVelocity * 4), 10);
                double saved = (product.getStock() - recommended) * product.getCost();

                recommendations.add(new Analysis.Recommendation(
                        product.getProductName(),
                        "OVERSTOCK",
                        product.getStock(),
                        weeksOfSupply,
                        recommended,
                        "Transfer or markdown",
                        String.format("Free up $%.0f", saved)
                ));
            }
            else if (weeksOfSupply < 2) {
                double lostSales = weeklyVelocity * 3 * (product.getRetailPrice() - product.getCost());

                recommendations.add(new Analysis.Recommendation(
                        product.getProductName(),
                        "UNDERSTOCK",
                        product.getStock(),
                        weeksOfSupply,
                        (int)(weeklyVelocity * 6),
                        "Order or transfer",
                        String.format("Prevent $%.0f lost sales", lostSales)
                ));
            }
        }

        long overstock = recommendations.stream().filter(r -> "OVERSTOCK".equals(r.issue)).count();
        long understock = recommendations.stream().filter(r -> "UNDERSTOCK".equals(r.issue)).count();

        Map<String, String> impact = new HashMap<>();
        impact.put("total", String.format("Optimize %d products", overstock + understock));

        return Analysis.builder()
                .storeId(store.getStoreId())
                .storeName(store.getStoreName())
                .inventoryValue(store.getTotalValue())
                .recommendations(recommendations)
                .impact(impact)
                .summary(String.format("Found %d overstock and %d understock items", overstock, understock))
                .build();
    }
}