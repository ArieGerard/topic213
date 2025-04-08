package com.gcu.data;

public interface UserDataAccessInterface <T>{
 public T findByUsername(String username); // Added method to find user by username
}
