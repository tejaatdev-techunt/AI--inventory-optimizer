package com.inventory.data;

import com.inventory.model.*;
import java.util.*;

public class SampleData {

    public static List<Store> getAllStores() {
        return Arrays.asList(
                new Store("S001", "Target - Minnesota", "Minneapolis, MN", "winter",
                        Arrays.asList(
                                new Product("P001", "Winter Jacket", 450, 35.0, 79.99, 15),
                                new Product("P002", "Thermal Pants", 320, 20.0, 49.99, 20),
                                new Product("P003", "Summer T-Shirt", 850, 5.0, 14.99, 180),
                                new Product("P004", "Running Shoes", 280, 30.0, 89.99, 45)
                        )),

                new Store("S002", "Best Buy - Arizona", "Phoenix, AZ", "summer",
                        Arrays.asList(
                                new Product("P001", "Winter Jacket", 520, 35.0, 79.99, 450),
                                new Product("P003", "Summer T-Shirt", 150, 5.0, 14.99, 8),
                                new Product("P006", "Summer Shorts", 120, 8.0, 24.99, 5),
                                new Product("P008", "Sandals", 180, 12.0, 34.99, 8)
                        )),

                new Store("S003", "Costco - California", "Los Angeles, CA", "spring",
                        Arrays.asList(
                                new Product("P001", "Winter Jacket", 280, 35.0, 79.99, 120),
                                new Product("P003", "Summer T-Shirt", 420, 5.0, 14.99, 35),
                                new Product("P007", "Jeans", 420, 22.0, 59.99, 30),
                                new Product("P008", "Sandals", 350, 12.0, 34.99, 40)
                        ))
        );
    }

    public static Store getStoreById(String storeId) {
        return getAllStores().stream()
                .filter(s -> s.getStoreId().equals(storeId))
                .findFirst()
                .orElse(null);
    }

    public static Map<String, Integer> getSalesVelocity(String storeId) {
        Map<String, Map<String, Integer>> velocities = new HashMap<>();
        velocities.put("S001", Map.of("P001", 50, "P002", 30, "P003", 3, "P004", 15));
        velocities.put("S002", Map.of("P001", 2, "P003", 45, "P006", 60, "P008", 50));
        velocities.put("S003", Map.of("P001", 15, "P003", 25, "P007", 18, "P008", 25));
        return velocities.getOrDefault(storeId, new HashMap<>());
    }
}