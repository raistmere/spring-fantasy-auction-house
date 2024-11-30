package com.raistmere.fantasyauctionhouse.controllers;

import com.raistmere.fantasyauctionhouse.services.InventoryItemServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auctionhouse")
public class AuctionHouseController {

    private final InventoryItemServiceImpl inventoryItemServiceImpl;

    public AuctionHouseController(InventoryItemServiceImpl inventoryItemServiceImpl) {
        this.inventoryItemServiceImpl = inventoryItemServiceImpl;
    }

    @GetMapping("/addauctionform")
    public String getAddAuctionForm(Model model) {

        model.addAttribute("inventoryList", inventoryItemServiceImpl.getInventoryItems());

        return "addauctionform";
    }

    @PostMapping("/showconfirmaddauction")
    public String postAddAuctionForm() {




        return "confirmaddauction";
    }
}