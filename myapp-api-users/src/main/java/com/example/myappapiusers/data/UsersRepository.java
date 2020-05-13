package com.example.myappapiusers.data;

import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UserEntity,Long> {
    //UserEntity findByEmail(String email);
    //select * from users where email=?
}
