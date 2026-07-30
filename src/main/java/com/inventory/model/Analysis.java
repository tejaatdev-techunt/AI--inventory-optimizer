package com.inventory.model;

import java.util.List;

public class Analysis {
    private String storeId;
    private String storeName;
    private Double inventoryValue;
    private List<Recommendation> recommendations;
    private String summary;

    public Analysis() {}

    public Analysis(String storeId, String storeName, Double inventoryValue,
                    List<Recommendation> recommendations, String summary) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.inventoryValue = inventoryValue;
        this.recommendations = recommendations;
        this.summary = summary;
    }

    public String getStoreId() { return storeId; }
    public String getStoreName() { return storeName; }
    public Double getInventoryValue() { return inventoryValue; }
    public List<Recommendation> getRecommendations() { return recommendations; }
    public String getSummary() { return summary; }

    public static class Recommendation {
        private String productName;
        private String issue;
        private Integer currentStock;
        private Double weeksOfSupply;
        private Integer recommended;
        private String action;
        private String impact;

        public Recommendation() {}

        public Recommendation(String productName, String issue, Integer currentStock,
                              Double weeksOfSupply, Integer recommended,
                              String action, String impact) {
            this.productName = productName;
            this.issue = issue;
            this.currentStock = currentStock;
            this.weeksOfSupply = weeksOfSupply;
            this.recommended = recommended;
            this.action = action;
            this.impact = impact;
        }

        public String getProductName() { return productName; }
        public String getIssue() { return issue; }
        public Integer getCurrentStock() { return currentStock; }
        public Double getWeeksOfSupply() { return weeksOfSupply; }
        public Integer getRecommended() { return recommended; }
        public String getAction() { return action; }
        public String getImpact() { return impact; }
    }
}
