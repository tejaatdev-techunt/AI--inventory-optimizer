package com.inventory.model;

import java.util.List;

public class Store {
    private String storeId;
    private String storeName;
    private String location;
    private String season;
    private List<Product> inventory;

    public Store() {}

    public Store(String storeId, String storeName, String location,
                 String season, List<Product> inventory) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.location = location;
        this.season = season;
        this.inventory = inventory;
    }

    public String getStoreId() { return storeId; }
    public String getStoreName() { return storeName; }
    public String getLocation() { return location; }
    public String getSeason() { return season; }
    public List<Product> getInventory() { return inventory; }

    public double getTotalValue() {
        return inventory.stream()
                .mapToDouble(p -> p.getStock() * p.getCost())
                .sum();
    }
}