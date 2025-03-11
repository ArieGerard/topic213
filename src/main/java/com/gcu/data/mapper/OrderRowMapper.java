package com.gcu.data.mapper;

import com.gcu.data.entity.OrderEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<OrderEntity> {

    @Override
    public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderEntity order = new OrderEntity();
        order.setId(rs.getLong("ID"));
        order.setOrderNo(rs.getString("ORDER_NO"));
        order.setProductName(rs.getString("PRODUCT_NAME"));
        order.setPrice(rs.getFloat("PRICE"));
        order.setQuantity(rs.getInt("QUANTITY"));
        return order;
    }
}