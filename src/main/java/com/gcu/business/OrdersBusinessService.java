package com.gcu.business;

import com.gcu.data.OrdersDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("customOrdersBusinessService")
public class OrdersBusinessService implements OrdersBusinessInterface {

    @Autowired
    private OrdersDataService ordersDataService;

    @Override
    public void test() {
        System.out.println("Hello from the OrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderEntity> orderEntities = ordersDataService.findAll();
        return orderEntities.stream()
            .map(entity -> new OrderModel(
                entity.getId(),
                entity.getOrderNo(),
                entity.getProductName(),
                entity.getPrice(),
                entity.getQuantity()
            ))
            .collect(Collectors.toList());
    }

    @Override
    public OrderModel getOrderById(String id) {
        OrderEntity orderEntity = ordersDataService.findById(id);
        return new OrderModel(
            orderEntity.getId(),
            orderEntity.getOrderNo(),
            orderEntity.getProductName(),
            orderEntity.getPrice(),
            orderEntity.getQuantity()
        );
    }

    @Override
    public void init() {
        System.out.println("OrdersBusinessService initialized");
    }

    @Override
    public void destroy() {
        System.out.println("OrdersBusinessService destroyed");
    }
}
