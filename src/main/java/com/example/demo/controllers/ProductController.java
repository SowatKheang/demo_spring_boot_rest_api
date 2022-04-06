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
        List<Product> products = new ArrayList<Product>();

        try {
            products = productService.getList(pageIndex, pageSize, sortBy.trim(), Product.class);
            return ResponseHelper.getResponse("Success", HttpStatus.OK, products);
        } catch (Exception ex) {
            return ResponseHelper.getResponse(ex.getMessage(), HttpStatus.OK, null);
        }
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Integer id) {
        try {
            Product product = productService.getById(id, Product.class);
            return ResponseHelper.getResponse("Success", HttpStatus.OK, product);
        } catch (Exception ex) {
            return ResponseHelper.getResponse(ex.getMessage(), HttpStatus.OK, null);
        }
    }

}

