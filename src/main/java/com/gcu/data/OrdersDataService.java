package com.gcu.data;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;
import com.gcu.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity> {

    @Autowired
    private OrdersRepository ordersRepository;

    // Non-default constructor for constructor injection
    public OrdersDataService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<OrderEntity> findAll() {
        List<OrderEntity> orders = new ArrayList<>();
        try {
            Iterable<OrderEntity> orderEntities = ordersRepository.findAll();
            orderEntities.forEach(orders::add);
            System.out.println("Orders found: " + orders.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public OrderEntity findById(String id) {
        Optional<OrderEntity> entity = ordersRepository.findById(id);
        return entity.orElse(null);
    }

    @Override
    public boolean create(OrderEntity order) {
        try {
            ordersRepository.save(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(OrderEntity order) {
        try {
            ordersRepository.save(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            ordersRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
