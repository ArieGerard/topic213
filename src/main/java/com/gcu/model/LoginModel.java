package com.gcu.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginModel {
 @NotNull(message = "Username is required")
 @Size(min = 1, max = 20, message = "Username must be between 1 and 20 characters")
    private String username;
@NotNull(message = "Password is required")
@Size(min = 1, max = 20, message = "Password must be between 1 and 20 characters")
 private String password;


    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}