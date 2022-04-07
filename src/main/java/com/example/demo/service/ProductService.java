package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRespository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractService<ProductRespository, Product> {

    // ProductService() {
    //     super(Product.class);
    // }

}
