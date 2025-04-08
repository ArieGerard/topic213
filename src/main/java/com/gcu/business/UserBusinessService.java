package com.gcu.business;

import com.gcu.data.UserDataService;
import com.gcu.data.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessService implements UserDetailsService {

    private final UserDataService service;

    // Constructor injection for UserDataService
    @Autowired
    public UserBusinessService(UserDataService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Use the UserDataService to find the user by username
        UserEntity userEntity = service.findByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Return a UserDetails object required by Spring Security
        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles("USER") // Assign a default role
                .build();
    }
}
