package com.inventory.model;

public class Product {
    private String productId;
    private String productName;
    private Integer stock;
    private Double cost;
    private Double retailPrice;
    private Integer daysInStock;

    public Product() {}

    public Product(String productId, String productName, Integer stock,
                   Double cost, Double retailPrice, Integer daysInStock) {
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
        this.cost = cost;
        this.retailPrice = retailPrice;
        this.daysInStock = daysInStock;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public Integer getStock() { return stock; }
    public Double getCost() { return cost; }
    public Double getRetailPrice() { return retailPrice; }
    public Integer getDaysInStock() { return daysInStock; }
}