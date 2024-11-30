package com.raistmere.fantasyauctionhouse.controllers;

import com.raistmere.fantasyauctionhouse.services.AuctionServiceImpl;
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
    private final AuctionServiceImpl auctionServiceImpl;

    @Autowired
    public HomeController(ItemServiceImpl itemServiceImpl, InventoryItemServiceImpl inventoryItemServiceImpl, AuctionServiceImpl auctionServiceImpl) {
        this.itemServiceImpl = itemServiceImpl;
        this.inventoryItemServiceImpl = inventoryItemServiceImpl;
        this.auctionServiceImpl = auctionServiceImpl;
    }

    @GetMapping("/")
    public String GetHome(Model model) {

        return "home";
    }

    @GetMapping("/auctionhouse")
    public String GetAuctionHouse(Model model) {

        model.addAttribute("auctionList", auctionServiceImpl.findAllAuctions());

        return "auctionhouse";
    }

    @GetMapping("/myinventory")
    public String GetMyInventory(Model model) {

        model.addAttribute("inventory", inventoryItemServiceImpl.getInventoryItems());

        return "myinventory";
    }

    @GetMapping("/itemlist")
    public String GetItemList(Model model) {

        model.addAttribute("items", itemServiceImpl.findAll());

        return "itemlist";
    }
}
