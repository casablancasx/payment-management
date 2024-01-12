package com.danilo.project.paymentmanagementservice.services;

import com.danilo.project.paymentmanagementservice.entities.User;
import com.danilo.project.paymentmanagementservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        List<User> list = repository.findAll();
        return list;
    }

}
