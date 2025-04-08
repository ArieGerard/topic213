package com.gcu.controller;

import com.gcu.business.OrdersBusinessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    @Qualifier("customOrdersBusinessService")
    private OrdersBusinessInterface ordersBusinessService;

    @GetMapping("/login")
    public String displayLogin(Model model) {
        model.addAttribute("title", "Login");
        return "login"; // This corresponds to the login.html Thymeleaf template
    }
}