package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.model.User;

public interface UserRepository extends IRepository<User>  {

    Optional<User> findByEmail(String email);

}
