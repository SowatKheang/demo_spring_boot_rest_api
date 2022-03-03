package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.helper.ResponseHelper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value="/users")
    public ResponseEntity<Object> getAllUser(
        @RequestParam(defaultValue = "0") Integer pageIndex, 
        @RequestParam(defaultValue = "10") Integer pageSize,
        @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<User> users = new ArrayList<User>();

        try {
            users = userService.getAllUser(pageIndex, pageSize, sortBy.trim());
            // return new ResponseEntity<>(users, HttpStatus.OK);
            return ResponseHelper.getResponse("Success", HttpStatus.OK, users);
        } catch (Exception ex) {
            // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseHelper.getResponse("Internal Server Error", HttpStatus.OK, null);
        }
    }


}
