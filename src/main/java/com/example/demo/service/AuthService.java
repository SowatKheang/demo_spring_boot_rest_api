package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends AbstractService<UserRepository, User> {
    
    public boolean auth(User user) {
        return true;
    }

}
