package com.gcu.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import com.gcu.model.OrderModel;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersDataService implements DataAccessInterface<OrderModel> {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public OrdersDataService(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<OrderModel> findAll() {
        String sql = "SELECT * FROM orders";
        List<OrderModel> orders = new ArrayList<>();
        try {
            SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
            while (srs.next()) {
                OrderModel order = new OrderModel(
                    srs.getInt("id"),
                    srs.getString("order_no"),
                    srs.getString("product_name"),
                    srs.getDouble("price"),
                    srs.getInt("quantity")
                );
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public OrderModel findById(int id) {
        // For now, return null
        return null;
    }

    @Override
    public boolean create(OrderModel order) {
        String sql = "INSERT INTO orders (order_no, product_name, price, quantity) VALUES (?, ?, ?, ?)";
        try {
            int rows = jdbcTemplateObject.update(sql, order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity());
            return rows == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(OrderModel order) {
        // For now, return true
        return true;
    }

    @Override
    public boolean delete(int id) {
        // For now, return true
        return true;
    }
}
