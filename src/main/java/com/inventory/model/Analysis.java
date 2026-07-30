package com.inventory.model;

import lombok.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Analysis {
    private String storeId;
    private String storeName;
    private Double inventoryValue;
    private List<Recommendation> recommendations;
    private Map<String, String> impact;
    private String summary;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Recommendation {
        public String productName;
        public String issue;
        public Integer currentStock;
        public Double weeksOfSupply;
        public Integer recommended;
        public String action;
        public String impact;
    }
}