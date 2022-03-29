package com.example.demo.service;

import java.util.*;
import com.example.demo.repository.ProductRespository;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    @Autowired
    ProductRespository repository;

    public List<Product> getAll(Integer pageIndex, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageIndex, pageSize, Sort.by(sortBy));

        Page<Product> pagedResult = repository.findAll(paging);
        
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Product>();
        }
    }

    public Product getProductById(Integer id) {
        Optional<Product> product = repository.findById(id);
        return product.get();
    }

}
