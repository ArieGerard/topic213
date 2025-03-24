package com.gcu.data.repository;

import com.gcu.data.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdersRepository extends MongoRepository<OrderEntity, String> {
    OrderEntity getOrderById(String id);
}