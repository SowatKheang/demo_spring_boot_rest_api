package com.example.demo.service;

import java.util.*;
import org.springframework.data.domain.*;

import com.example.demo.helper.ConverterHelper;
import com.example.demo.model.BaseModel;
import com.example.demo.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService<T extends IRepository<?>> {

    @Autowired
    T repository;
    
    public <E extends BaseModel> List<E> getList(Integer pageIndex, Integer pageSize, String sortBy, Class<E> clazz) {
        Pageable paging = PageRequest.of(pageIndex, pageSize, Sort.by(sortBy));
        Page<?> pagedResult = this.repository.findAll(paging);
        
        if (pagedResult.hasContent()) {
            return ConverterHelper.castList(pagedResult.getContent(), clazz);
        } else {
            return null;
        }
    }
    public <E extends BaseModel> E getById(Integer id, Class<E> clazz) {
        Optional<?> model = this.repository.findById(id);
        if (model != null) {
            return ConverterHelper.castObject(model.get(), clazz);
        }
        return null;
    }

}
