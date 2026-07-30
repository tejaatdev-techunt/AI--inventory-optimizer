package com.inventory.controller;

import com.inventory.service.InventoryService;
import com.inventory.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/")
    public String index(Model model) {
        List<Store> stores = inventoryService.getAllStores();
        model.addAttribute("stores", stores);
        return "index";
    }

    @GetMapping("/store/{storeId}")
    public String analyzeStore(@PathVariable String storeId, Model model) {
        Store store = inventoryService.getStore(storeId);
        var analysis = inventoryService.analyzeStore(storeId);

        model.addAttribute("store", store);
        model.addAttribute("analysis", analysis);
        return "analysis";
    }

    @GetMapping("/api/stores")
    @ResponseBody
    public List<Store> getStoresApi() {
        return inventoryService.getAllStores();
    }

    @GetMapping("/api/analyze/{storeId}")
    @ResponseBody
    public Object analyzeApi(@PathVariable String storeId) {
        return inventoryService.analyzeStore(storeId);
    }
}