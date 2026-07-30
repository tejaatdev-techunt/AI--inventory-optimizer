package com.inventory.model;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Store {
    private String storeId;
    private String storeName;
    private String location;
    private String season;
    private List<Product> inventory;

    public double getTotalValue() {
        return inventory.stream()
                .mapToDouble(p -> p.getStock() * p.getCost())
                .sum();
    }
}