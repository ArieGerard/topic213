package com.gcu.data;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDataService implements DataAccessInterface<OrderEntity> {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplateObject;

    // Non-default constructor for constructor injection
    public OrderDataService(OrdersRepository ordersRepository, DataSource dataSource) {
        this.ordersRepository = ordersRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public OrderEntity findById(int id) {
        Optional<OrderEntity> order = ordersRepository.findById((long) id);
        return order.orElse(null);
    }

    @Override
    public List<OrderEntity> findAll() {
        List<OrderEntity> orders = new ArrayList<>();
        try {
            Iterable<OrderEntity> orderIterable = ordersRepository.findAll();
            orderIterable.forEach(orders::add);
            System.out.println("Orders found: " + orders.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean create(OrderEntity order) {
        try {
            String sql = "INSERT INTO ORDERS (ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES (?, ?, ?, ?)";
            jdbcTemplateObject.update(sql, order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(OrderEntity order) {
        return true;
    }

    @Override
    public boolean delete(int id) {
        return true;
    }
}