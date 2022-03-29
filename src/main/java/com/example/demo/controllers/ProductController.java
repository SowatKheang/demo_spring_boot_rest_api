package com.example.demo.controllers;

import java.util.*;

import com.example.demo.helper.ResponseHelper;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping(value="")
    public ResponseEntity<Object> getAllUser(
        @RequestParam(defaultValue = "0") Integer pageIndex, 
        @RequestParam(defaultValue = "10") Integer pageSize,
        @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<Product> users = new ArrayList<Product>();

        try {
            users = productService.getAll(pageIndex, pageSize, sortBy.trim());
            return ResponseHelper.getResponse("Success", HttpStatus.OK, users);
        } catch (Exception ex) {
            return ResponseHelper.getResponse(ex.getMessage(), HttpStatus.OK, null);
        }
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Integer id) {
        try {
            Product product = productService.getProductById(id);
            return ResponseHelper.getResponse("Success", HttpStatus.OK, product);
        } catch (Exception ex) {
            return ResponseHelper.getResponse(ex.getMessage(), HttpStatus.OK, null);
        }
    }

}

