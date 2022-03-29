package com.example.demo.repository;

import com.example.demo.model.Product;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRespository extends PagingAndSortingRepository<Product, Integer>  {
    
}