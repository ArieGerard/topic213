package com.gcu.business;

import com.gcu.data.OrderDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("customOrdersBusinessService")
public class OrdersBusinessService implements OrdersBusinessInterface {

    @Autowired
    private OrderDataService service;

    @Override
    public void test() {
        System.out.println("Hello from the OrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderEntity> ordersEntity = service.findAll();
        List<OrderModel> ordersDomain = new ArrayList<>();

        for (OrderEntity entity : ordersEntity) {
            OrderModel model = new OrderModel(
                entity.getId(),
                entity.getOrderNo(),
                entity.getProductName(),
                entity.getPrice(),
                entity.getQuantity()
            );
            ordersDomain.add(model);
        }

        // Display orders
        for (OrderModel order : ordersDomain) {
            System.out.println("Order ID: " + order.getId());
            System.out.println("Order No: " + order.getOrderNo());
            System.out.println("Product Name: " + order.getProductName());
            System.out.println("Price: " + order.getPrice());
            System.out.println("Quantity: " + order.getQuantity());
            System.out.println("---------------------------");
        }

        System.out.println("Orders returned: " + ordersDomain.size());
        return ordersDomain;
    }

    @PostConstruct
    public void init() {
        System.out.println("OrdersBusinessService initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("OrdersBusinessService destroyed");
    }
}
