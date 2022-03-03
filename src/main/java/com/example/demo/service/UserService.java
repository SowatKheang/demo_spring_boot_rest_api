package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository repository;
    
    public List<User> getAllUser(Integer pageIndex, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageIndex, pageSize, Sort.by(sortBy));

        Page<User> pagedResult = repository.findAll(paging);
        
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<User>();
        }
    }

}
