package com.gcu.data;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService implements UserDataAccessInterface<UserEntity>, DataAccessInterface<UserEntity> {

    private final UserRepository usersRepository;

    // Constructor injection for UserRepository
    @Autowired
    public UserDataService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public List<UserEntity> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public UserEntity findById(String id) {
        Optional<UserEntity> user = usersRepository.findById(id);
        return user.orElse(null); // Return the user if found, otherwise return null
    }

    @Override
    public boolean create(UserEntity user) {
        try {
            usersRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(UserEntity user) {
        if (usersRepository.existsById(user.getId())) {
            usersRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
