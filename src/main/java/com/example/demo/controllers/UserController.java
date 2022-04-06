package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController extends AbstractController<UserService, User> {

    UserController() {
        super(User.class);
    }

}
