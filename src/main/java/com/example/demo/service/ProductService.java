package com.example.demo.service;

import java.util.*;
import com.example.demo.repository.ProductRespository;
import com.example.demo.helper.ConverterHelper;
import com.example.demo.model.Product;

import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractService<ProductRespository> {
    
    public List<Product> getAll(Integer pageIndex, Integer pageSize, String sortBy) {
        List<Product> products = ConverterHelper.castList(this.getList(pageIndex, pageSize, sortBy), Product.class);
        return products;
    }

    public Product getProductById(Integer id) {
        Optional<?> product = this.getById(id);
        return (Product) product.get();
    }

}
