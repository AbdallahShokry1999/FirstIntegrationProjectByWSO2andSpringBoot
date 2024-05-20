package com.demoo.demoo.services;

import com.demoo.demoo.entities.User;
import com.demoo.demoo.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public List<User> findAll() {
        return userRepo.findAll();
    }
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    public void updateUser(User user) {
        userRepo.save(user);
    }
}
