package com.fincas.app.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class viewsController {
    
    @GetMapping("/")
    public String homeView(Model model){
        model.addAttribute("title", "Reto3");
        return "index";
    }
}
