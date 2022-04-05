package com.example.demo.service;

import java.util.*;
import org.springframework.data.domain.*;
import com.example.demo.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService<T extends IRepository<?>> {

    @Autowired
    T repository;
    
    public List<?> getList(Integer pageIndex, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageIndex, pageSize, Sort.by(sortBy));
        Page<?> pagedResult = this.repository.findAll(paging);
        
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return null;
        }
    }

    public Optional<?> getById(Integer id) {
        Optional<?> model = this.repository.findById(id);
        return model;
    }

}
