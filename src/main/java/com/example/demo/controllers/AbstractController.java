package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.model.BaseModel;
import com.example.demo.service.AbstractService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

// import net.minidev.json.JSONArray;
/**
 * @AbstractController
 * @AbstractService
 * @BaseModel
 * @ResponseHelper
 */
public abstract class AbstractController<T extends AbstractService<?, E>, E extends BaseModel<E>> {

    @Autowired
    T service;

    private static final Logger log = LoggerFactory.getLogger(AbstractController.class);

    /**
     * 
     * @param pageIndex
     * @param pageSize
     * @param sortBy
     * @return
     */
    @GetMapping(value="")
    public ResponseEntity<Object> getAll(
        @RequestParam(defaultValue = "0") Integer pageIndex, 
        @RequestParam(defaultValue = "10") Integer pageSize,
        @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<E> list = new ArrayList<E>();

        try {
            list = this.service.getList(pageIndex, pageSize, sortBy.trim());
            return ResponseHelper.getResponseSuccess(list, null);
        } catch (Exception ex) {
            log.info(ex.getMessage());
            return ResponseHelper.getResponse(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.OK, null);
        }
    }

    /**
     * 
     * @param id
     * @return
     */
    @GetMapping(value="/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Integer id) {
        try {
            E model = this.service.getById(id);
            // return ResponseHelper.getResponse("Success", HttpStatus.OK, model);
            return ResponseHelper.getResponseSuccess(model, null);
        } catch (Exception ex) {
            log.info(ex.getMessage());
            return ResponseHelper.getResponse("Internal Server Error", HttpStatus.OK, null);
        }
    }

    // TODO: add more

}
