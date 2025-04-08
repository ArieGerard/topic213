package com.gcu.data.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection = "users") // Specifies the MongoDB collection name
public class UserEntity {

    @Id
    private String id; // Unique identifier for the user

    @Indexed(unique = true) // Ensures the username is unique
    private String username;

    private String password;

    // Default constructor
    public UserEntity() {
       
  }
    

    // Non-default constructor
    public UserEntity(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
