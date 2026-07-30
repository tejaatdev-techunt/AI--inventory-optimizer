package com.inventory.data;

import com.inventory.model.*;
import java.util.*;

public class SampleData {

    public static List<Store> getAllStores() {
        return Arrays.asList(
                createStore("S001", "Target - Minnesota", "Minneapolis, MN", "winter",
                        Arrays.asList(
                                Product.builder().productId("P001").productName("Winter Jacket")
                                        .stock(450).cost(35.0).retailPrice(79.99).daysInStock(15).build(),
                                Product.builder().productId("P002").productName("Thermal Pants")
                                        .stock(320).cost(20.0).retailPrice(49.99).daysInStock(20).build(),
                                Product.builder().productId("P003").productName("Summer T-Shirt")
                                        .stock(850).cost(5.0).retailPrice(14.99).daysInStock(180).build(),
                                Product.builder().productId("P004").productName("Running Shoes")
                                        .stock(280).cost(30.0).retailPrice(89.99).daysInStock(45).build()
                        )),

                createStore("S002", "Best Buy - Arizona", "Phoenix, AZ", "summer",
                        Arrays.asList(
                                Product.builder().productId("P001").productName("Winter Jacket")
                                        .stock(520).cost(35.0).retailPrice(79.99).daysInStock(450).build(),
                                Product.builder().productId("P003").productName("Summer T-Shirt")
                                        .stock(150).cost(5.0).retailPrice(14.99).daysInStock(8).build(),
                                Product.builder().productId("P006").productName("Summer Shorts")
                                        .stock(120).cost(8.0).retailPrice(24.99).daysInStock(5).build(),
                                Product.builder().productId("P008").productName("Sandals")
                                        .stock(180).cost(12.0).retailPrice(34.99).daysInStock(8).build()
                        )),

                createStore("S003", "Costco - California", "Los Angeles, CA", "spring",
                        Arrays.asList(
                                Product.builder().productId("P001").productName("Winter Jacket")
                                        .stock(280).cost(35.0).retailPrice(79.99).daysInStock(120).build(),
                                Product.builder().productId("P003").productName("Summer T-Shirt")
                                        .stock(420).cost(5.0).retailPrice(14.99).daysInStock(35).build(),
                                Product.builder().productId("P007").productName("Jeans")
                                        .stock(420).cost(22.0).retailPrice(59.99).daysInStock(30).build(),
                                Product.builder().productId("P008").productName("Sandals")
                                        .stock(350).cost(12.0).retailPrice(34.99).daysInStock(40).build()
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

    private static Store createStore(String id, String name, String location, String season, List<Product> inventory) {
        return Store.builder()
                .storeId(id)
                .storeName(name)
                .location(location)
                .season(season)
                .inventory(inventory)
                .build();
    }
}