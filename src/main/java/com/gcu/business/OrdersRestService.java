package com.gcu.business;

import com.gcu.model.OrderList;
import com.gcu.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/service")
public class OrdersRestService {

    @Autowired
    @Qualifier("customOrdersBusinessService")
    private OrdersBusinessInterface ordersBusinessService;

    @GetMapping("/")
    public OrderList getOrders() {
        List<OrderModel> orders = ordersBusinessService.getOrders();
        OrderList orderList = new OrderList();
        orderList.setOrders(orders);
        return orderList;
    }

    @GetMapping(path = "/getjson", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderModel> getOrdersAsJson() {
        return ordersBusinessService.getOrders();
    }

    @GetMapping(path = "/getxml", produces = MediaType.APPLICATION_XML_VALUE)
    public OrderList getOrdersAsXml() {
        List<OrderModel> orders = ordersBusinessService.getOrders();
        OrderList list = new OrderList();
        list.setOrders(orders);
        return list;
    }

    @GetMapping("/getorder/{id}")
    public ResponseEntity<OrderModel> getOrder(@PathVariable("id") String id) {
        try {
            OrderModel order = ordersBusinessService.getOrderById(id);
            if (order == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
