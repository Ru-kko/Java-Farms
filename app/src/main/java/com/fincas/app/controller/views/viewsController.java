package com.fincas.app.controller.views;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class viewsController extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests( a -> a
            .antMatchers("/", "/error", "/css/**", "/js/**", "/api/**/**", "/public/**").permitAll()
            .anyRequest().authenticated()
        ).exceptionHandling(e -> e
            .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        ).oauth2Login();

        http.cors().and().csrf().disable();
    }
    
    @GetMapping("/")
    public String homeView(Model model) {
        model.addAttribute("title", "Reto 3");
        return "home";
    }

    @GetMapping("/farms")
    public String farmsView(Model model) {
        model.addAttribute("title", "Farms");
        return "farms";
    }

    @GetMapping("/clients")
    public String clientsView(Model model) {
        model.addAttribute("title", "Clients");
        return "clients";
    }

    @GetMapping("/messages")
    public String messagesView(Model model) {
        model.addAttribute("title", "Messages");
        return "messages";
    }

    @GetMapping("/categories")
    public String categoriesView(Model model) {
        model.addAttribute("title", "Categories");
        return "categories";
    }

    @GetMapping("/reservations")
    public String reservationsView(Model model) {
        model.addAttribute("title", "Reservations");
        return "reservations";
    }
}