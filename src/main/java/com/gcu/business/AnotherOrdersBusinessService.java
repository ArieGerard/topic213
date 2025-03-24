package com.gcu.business;

import com.gcu.model.OrderModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("anotherOrdersBusinessService")
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

    @Override
    public void test() {
        System.out.println("Hello from the AnotherOrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        // Implementation here...
        return null;
    }

    @Override
    public OrderModel getOrderById(String id) {
        // Simply return null
        return null;
    }

    @Override
    public void init() {
        System.out.println("AnotherOrdersBusinessService initialized");
    }

    @Override
    public void destroy() {
        System.out.println("AnotherOrdersBusinessService destroyed");
    }
}
