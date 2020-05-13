package com.example.myappapiusers.controller;

import com.example.myappapiusers.model.CreateUserRequestModel;
import com.example.myappapiusers.model.CreateUserResponseModel;
import com.example.myappapiusers.model.LoginRequestModel;
import com.example.myappapiusers.repository.UserRepository;
import com.example.myappapiusers.service.UserService;
import com.example.myappapiusers.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService userService;

    @Autowired
    Environment env;

    @Autowired
    private UserRepository repository;

    @GetMapping("/status/check")
    public String status(){
         return String.format("Working on port %s", env.getProperty("local.server.port"));
    }

    //사용자 추가 API

//    @PostMapping("/user")
//    public List<UserEntity> createUser(@RequestBody UserEntity userEntity){
//        repository.save(userEntity);
//        return repository.findAll();
//    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails){
        //CreateUserRequestModel -> UserDto (using ModelMapper)

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
        UserDto createdDto = userService.createUser(userDto);

//        return new ResponseEntity(HttpStatus.CREATED);
        CreateUserResponseModel returnValue = modelMapper.map(createdDto,CreateUserResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }


}
