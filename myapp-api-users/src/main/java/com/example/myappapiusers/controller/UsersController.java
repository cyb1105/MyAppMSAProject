package com.example.myappapiusers.controller;

import com.example.myappapiusers.data.UserEntity;
import com.example.myappapiusers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    Environment env;

    @Autowired
    private UserRepository repository;

    @GetMapping("/status/check")
    public String status(){
         return String.format("Working on port %s", env.getProperty("local.server.port"));
    }

    //사용자 추가 API

    @PostMapping("/user")
    public List<UserEntity> createUser(@RequestBody UserEntity userEntity){
        repository.save(userEntity);
        return repository.findAll();
    }


}
