package com.example.myappapiusers.service;

import com.example.myappapiusers.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDetails);
    UserDto getUserDetailByEmail(String email);
}
