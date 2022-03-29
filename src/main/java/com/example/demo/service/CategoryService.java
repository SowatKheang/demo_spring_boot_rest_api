package com.example.demo.service;

import java.util.*;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    CategoryRepository repository;

    public List<Category> getAll(Integer pageIndex, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageIndex, pageSize, Sort.by(sortBy));

        Page<Category> pagedResult = repository.findAll(paging);
        
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Category>();
        }
    }

}
