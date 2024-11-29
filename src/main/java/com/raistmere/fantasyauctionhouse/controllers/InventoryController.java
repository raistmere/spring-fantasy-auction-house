package com.raistmere.fantasyauctionhouse.controllers;

import com.raistmere.fantasyauctionhouse.domains.InventoryItem;
import com.raistmere.fantasyauctionhouse.domains.Item;
import com.raistmere.fantasyauctionhouse.services.InventoryItemServiceImpl;
import com.raistmere.fantasyauctionhouse.services.ItemServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/myinventory")
public class InventoryController {

    private final ItemServiceImpl itemServiceImpl;
    private final InventoryItemServiceImpl inventoryItemServiceImpl;

    public InventoryController(ItemServiceImpl itemServiceImpl, InventoryItemServiceImpl inventoryItemServiceImpl) {
        this.itemServiceImpl = itemServiceImpl;
        this.inventoryItemServiceImpl = inventoryItemServiceImpl;
    }

    @GetMapping("/additemform")
    public String GetAddItemForm(Model model) {

        model.addAttribute("itemList", itemServiceImpl.findAll());

        return "additemform";
    }

    @PostMapping("/showconfirmadditem")
    public String PostAddItemForm(@ModelAttribute("itemId") Long itemId, @ModelAttribute("itemQty") Integer itemQty) {


        // we want to add x amount of the item based on the itemQty. There is no item stack at this time. Each item is individual.
        for(int i = 0; i < itemQty; i++) {

            InventoryItem inventoryItem = new InventoryItem();
            inventoryItem.setItem(itemServiceImpl.findById(itemId));
            inventoryItemServiceImpl.save(inventoryItem);
        }
        return "confirmadditem";
    }
}
