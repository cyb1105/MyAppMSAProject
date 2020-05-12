package com.example.myappapiusers.repository;

import com.example.myappapiusers.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

