package com.example.demo.service;

import java.util.*;
import org.springframework.data.domain.*;

import com.example.demo.helper.ConverterHelper;
import com.example.demo.model.BaseModel;
import com.example.demo.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @AbstractService
 * @IRepository
 * @BaseModel
 * @ConverterHelper
 */
public abstract class AbstractService<T extends IRepository<?>, E extends BaseModel> {

    @Autowired
    T repository;

    Class<E> clazz;

    AbstractService(Class<E> clazz) {
        this.clazz = clazz;
    }
    
    public List<E> getList(Integer pageIndex, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageIndex, pageSize, Sort.by(sortBy));
        Page<?> pagedResult = this.repository.findAll(paging);
        
        if (pagedResult.hasContent()) {
            return ConverterHelper.castList(pagedResult.getContent(), this.clazz);
        } else {
            return null;
        }
    }

    public E getById(Integer id) {
        Optional<?> model = this.repository.findById(id);
        return ConverterHelper.castObject(model.get(), this.clazz);
    }

    // TODO: add more

}
