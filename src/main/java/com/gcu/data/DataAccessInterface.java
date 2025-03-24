package com.gcu.data;

import java.util.List;

public interface DataAccessInterface<T> {
    List<T> findAll();
    T findById(String id); // Added method Added method
    boolean create(T t);
    boolean update(T t);
    boolean delete(String id);
}
