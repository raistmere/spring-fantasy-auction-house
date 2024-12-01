package com.raistmere.fantasyauctionhouse.controllers;

import com.raistmere.fantasyauctionhouse.domains.Auction;
import com.raistmere.fantasyauctionhouse.services.AuctionServiceImpl;
import com.raistmere.fantasyauctionhouse.services.InventoryItemServiceImpl;
import com.raistmere.fantasyauctionhouse.services.ItemServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auctionhouse")
public class AuctionHouseController {

    private final InventoryItemServiceImpl inventoryItemServiceImpl;
    private final ItemServiceImpl itemServiceImpl;
    private final AuctionServiceImpl auctionServiceImpl;

    public AuctionHouseController(InventoryItemServiceImpl inventoryItemServiceImpl, ItemServiceImpl itemServiceImpl, AuctionServiceImpl auctionServiceImpl) {
        this.inventoryItemServiceImpl = inventoryItemServiceImpl;
        this.itemServiceImpl = itemServiceImpl;
        this.auctionServiceImpl = auctionServiceImpl;
    }

    @GetMapping("/addauctionform")
    public String getAddAuctionForm(Model model) {

        model.addAttribute("inventoryList", inventoryItemServiceImpl.getInventoryItems());

        return "addauctionform";
    }

    @PostMapping("/postauction")
    public String postAddAuctionForm(@ModelAttribute("auctionItemId") Long auctionItemId, @ModelAttribute("auctionItemPrice") int auctionItemPrice) {

        Auction newAuction = new Auction(itemServiceImpl.findById(auctionItemId), auctionItemPrice);

        auctionServiceImpl.saveAuction(newAuction);

        return "redirect:/auctionhouse/confirmaddauction";
    }

    @GetMapping("/confirmaddauction")
    public String getConfirmAddAuction() {

        return "confirmaddauction";
    }
}