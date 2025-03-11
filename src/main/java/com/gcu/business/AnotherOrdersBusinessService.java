package com.gcu.business;

import com.gcu.model.OrderModel;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("anotherOrdersBusinessService")
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

    @Override
    public void test() {
        System.out.println("Hello from the AnotherOrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderModel> orders = new ArrayList<>();
        orders.add(new OrderModel(3L, "Order 3", "Product 3", 300.0f, 3));
        orders.add(new OrderModel(4L, "Order 4", "Product 4", 400.0f, 4));
        return orders;
    }

    @PostConstruct
    public void init() {
        System.out.println("AnotherOrdersBusinessService initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("AnotherOrdersBusinessService destroyed");
    }
}
