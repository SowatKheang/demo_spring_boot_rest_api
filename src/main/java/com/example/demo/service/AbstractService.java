package com.example.demo.service;

import java.util.*;
import org.springframework.data.domain.*;
import com.example.demo.model.BaseModel;
import com.example.demo.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @AbstractService
 * @IRepository
 * @BaseModel
 * @ConverterHelper
 */
public abstract class AbstractService<T extends IRepository<E>, E extends BaseModel<E>> {

    @Autowired
    T repository;

    // Class<E> clazz;

    // AbstractService(Class<E> clazz) {
    //     this.clazz = clazz;
    // }
    
    /**
     * 
     * @param pageIndex
     * @param pageSize
     * @param sortBy
     * @return
     */
    public List<E> getList(Integer pageIndex, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageIndex, pageSize, Sort.by(sortBy));
        Page<E> pagedResult = this.repository.findAll(paging);
        
        if (pagedResult.hasContent()) {
            // return ConverterHelper.castList(pagedResult.getContent(), this.clazz);
            return pagedResult.getContent();
        } else {
            return null;
        }
    }

    /**
     * 
     * @param id
     * @return
     */
    public E getById(Integer id) {
        Optional<E> model = this.repository.findById(id);
        // return ConverterHelper.castObject(model.get(), this.clazz);
        return model.get();
    }

    /**
     * 
     * @param id
     */
    public void remove(Integer id) {
        this.repository.deleteById(id);
    }

    /**
     * 
     * @param id
     * @param model
     * @return
     */
    public E update(Integer id, E model) {
        Optional<E> updateData = this.repository.findById(id).map(item -> {
            E dataToUpdate = item.updateWith(model);
            return this.repository.save(dataToUpdate);
        });
        return updateData.get();
    }

    /**
     * 
     * @param model
     * @return
     */
    public E save(E model) {
        return this.repository.save(model);
    }

    // TODO: add more

}
