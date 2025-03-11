package com.gcu.data.repository;

import com.gcu.data.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<OrderEntity, Long> {

    @Override
    @Query(value = "SELECT * FROM ORDERS", nativeQuery = true)
    List<OrderEntity> findAll();
}