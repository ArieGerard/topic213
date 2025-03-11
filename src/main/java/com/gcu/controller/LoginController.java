package com.gcu.controller;

import com.gcu.business.AnotherOrdersBusinessService;
import com.gcu.business.OrdersBusinessInterface;
import com.gcu.business.SecurityBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private SecurityBusinessService security;

    @Autowired
    @Qualifier("customOrdersBusinessService")
    private OrdersBusinessInterface ordersBusinessService;

    @Autowired
    @Qualifier("anotherOrdersBusinessService")
    private AnotherOrdersBusinessService anotherOrdersBusinessService;

    @GetMapping("/login1")
    public String displayLogin() {
        ordersBusinessService.test();
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if (security.authenticate(username, password)) {
            ordersBusinessService.test();
            anotherOrdersBusinessService.test(); // Call the test method here
            model.addAttribute("orders", ordersBusinessService.getOrders());
            model.addAttribute("title", "My Orders");
            return "orders";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}