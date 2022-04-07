package com.example.demo.controllers;

import com.example.demo.helper.ResponseHelper;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController extends AbstractController<ProductService, Product> {

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Product product) {
        try {
            Product saveProduct = this.service.save(product);
            return ResponseHelper.getResponse("Success", HttpStatus.OK, saveProduct);
        } catch (Exception ex) {
            return ResponseHelper.getResponse(ex.getMessage(), HttpStatus.OK, null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@PathVariable("id") Integer id, @RequestBody Product product) {
        try {
            Product updatedProduct = this.service.update(id, product);
            return ResponseHelper.getResponse("Success", HttpStatus.OK, updatedProduct);
        } catch (Exception ex) {
            return ResponseHelper.getResponse(ex.getMessage(), HttpStatus.OK, null);
        }
    }

}

