package com.example.demo.service;

import java.util.*;

import com.example.demo.helper.ConverterHelper;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractService<CategoryRepository> {

    public List<Category> getAll(Integer pageIndex, Integer pageSize, String sortBy) {
        List<Category> categories = ConverterHelper.castList(this.getList(pageIndex, pageSize, sortBy), Category.class);
        return categories;
    }

}
