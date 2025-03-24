package com.gcu.business;

import java.util.List;
import com.gcu.model.OrderModel;

public interface OrdersBusinessInterface {
    void test();
    List<OrderModel> getOrders();
    OrderModel getOrderById(String id);
    void init();
    void destroy();
}

