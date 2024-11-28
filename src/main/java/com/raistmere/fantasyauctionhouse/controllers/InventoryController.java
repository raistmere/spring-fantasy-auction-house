package com.raistmere.fantasyauctionhouse.controllers;

import com.raistmere.fantasyauctionhouse.domains.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myinventory")
public class InventoryController {

    @GetMapping("/additemform")
    public String GetAddItemForm() {

        return "additemform";
    }

    @PostMapping("/additemform")
    public String PostAddItemForm(@ModelAttribute("item") Item item) {

        return "confirmadditem";
    }
}
