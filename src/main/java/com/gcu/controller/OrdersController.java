package com.gcu.controller;

import com.gcu.business.OrdersBusinessInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrdersController {

    @Autowired
    @Qualifier("customOrdersBusinessService")
    private OrdersBusinessInterface service; // Auto-wired instance of OrdersBusinessService

    @GetMapping("/orders/display")
    public String displayOrders(Model model) {
        // Call the OrdersBusinessService to get the list of orders
        model.addAttribute("title", "Orders");
        model.addAttribute("orders", service.getOrders());
        return "orders"; // This corresponds to the orders.html Thymeleaf template
    }
}