package com.example.demo.controllers;

import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value="")
    public ResponseEntity<Object> getAllUser(
        @RequestParam(defaultValue = "0") Integer pageIndex, 
        @RequestParam(defaultValue = "10") Integer pageSize,
        @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<User> users = new ArrayList<User>();
        try {
            users = userService.getAllUser(pageIndex, pageSize, sortBy.trim());
            return ResponseHelper.getResponse("Success", HttpStatus.OK, users);
        } catch (Exception ex) {
            return ResponseHelper.getResponse("Internal Server Error", HttpStatus.OK, null);
        }
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Integer id) {
        try {
            User user = userService.getUserById(id);
            return ResponseHelper.getResponse("Success", HttpStatus.OK, user);
        } catch (Exception ex) {
            return ResponseHelper.getResponse("Internal Server Error", HttpStatus.OK, null);
        }
    }


}
