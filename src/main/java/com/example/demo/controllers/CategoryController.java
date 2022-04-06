package com.example.demo.controllers;

import java.util.*;

import com.example.demo.helper.ResponseHelper;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value="")
    public ResponseEntity<Object> getAllUser(
        @RequestParam(defaultValue = "0") Integer pageIndex, 
        @RequestParam(defaultValue = "10") Integer pageSize,
        @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<Category> categories = new ArrayList<Category>();
        try {
            categories = categoryService.getList(pageIndex, pageSize, sortBy.trim(), Category.class);
            return ResponseHelper.getResponse("Success", HttpStatus.OK, categories);
        } catch (Exception ex) {
            return ResponseHelper.getResponse(ex.getMessage(), HttpStatus.OK, null);
        }
    }

    
}
