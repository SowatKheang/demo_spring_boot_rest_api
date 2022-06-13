package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Product;
public interface ProductRespository extends IRepository<Product>  {
    List<Product> findAll();
}
