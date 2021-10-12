package com.fincas.app.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class viewsController {
    
    @GetMapping("/")
    public String homeView(Model model){
        model.addAttribute("title", "Reto3");
        model.addAttribute("test", "fragments/homePage.html::home");
        return "home";
    }
    @GetMapping("/farms")
    public String farmsView(Model model){
        model.addAttribute("title", "Farms");
        model.addAttribute("table", "fragments/farm.html :: table");
        return "main";
    }
}