package com.example.demo.controllers;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController extends AbstractController<ProductService, Product> {

    ProductController() {
        super(Product.class);
    }
}

