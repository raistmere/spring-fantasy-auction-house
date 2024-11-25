package com.raistmere.fantasyauctionhouse.controllers;

import com.raistmere.fantasyauctionhouse.services.InventoryItemServiceImpl;
import com.raistmere.fantasyauctionhouse.services.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ItemServiceImpl itemServiceImpl;
    private final InventoryItemServiceImpl inventoryItemServiceImpl;

    @Autowired
    public HomeController(ItemServiceImpl itemServiceImpl, InventoryItemServiceImpl inventoryItemServiceImpl) {
        this.itemServiceImpl = itemServiceImpl;
        this.inventoryItemServiceImpl = inventoryItemServiceImpl;
    }

    @GetMapping("/")
    public String GetHome(Model model) {

        model.addAttribute("items", itemServiceImpl.findAll());
        model.addAttribute("inventory", inventoryItemServiceImpl.getInventoryItems());

        return "home";
    }
}
