package com.inventory.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private String productId;
    private String productName;
    private Integer stock;
    private Double cost;
    private Double retailPrice;
    private Integer daysInStock;
}
