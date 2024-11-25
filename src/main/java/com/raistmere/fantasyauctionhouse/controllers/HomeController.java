package com.raistmere.fantasyauctionhouse.controllers;

import com.raistmere.fantasyauctionhouse.services.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ItemServiceImpl itemServiceImpl;

    @Autowired
    public HomeController(ItemServiceImpl itemServiceImpl) {
        this.itemServiceImpl = itemServiceImpl;
    }

    @GetMapping("/")
    public String GetHome(Model model) {

        model.addAttribute("items", itemServiceImpl.findAll());

        return "home";
    }
}
