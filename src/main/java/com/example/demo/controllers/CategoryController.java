package com.example.demo.controllers;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class CategoryController extends AbstractController<CategoryService, Category> {

    CategoryController() {
        super(Category.class);
    }

}
