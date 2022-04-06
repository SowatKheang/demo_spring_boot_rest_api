package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.model.BaseModel;
import com.example.demo.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @AbstractController
 * @AbstractService
 * @BaseModel
 * @ResponseHelper
 */
public abstract class AbstractController<T extends AbstractService<?>, E extends BaseModel> {

    @Autowired
    T service;

    private Class<E> clazz;

    AbstractController(Class<E> clazz) {
        this.clazz = clazz;
    }

    @GetMapping(value="")
    public ResponseEntity<Object> getAll(
        @RequestParam(defaultValue = "0") Integer pageIndex, 
        @RequestParam(defaultValue = "10") Integer pageSize,
        @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<?> list = new ArrayList<E>();

        try {
            list = this.service.getList(pageIndex, pageSize, sortBy.trim(), this.clazz);
            return ResponseHelper.getResponse("Success", HttpStatus.OK, list);
        } catch (Exception ex) {
            return ResponseHelper.getResponse(ex.getMessage(), HttpStatus.OK, null);
        }
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Integer id) {
        try {
            E model = this.service.getById(id, this.clazz);
            return ResponseHelper.getResponse("Success", HttpStatus.OK, model);
        } catch (Exception ex) {
            return ResponseHelper.getResponse(ex.getMessage(), HttpStatus.OK, null);
        }
    }

    // TODO: add more

}
