package com.halilkose.myfancypdfinvoices.springboot.service;

import com.halilkose.myfancypdfinvoices.springboot.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserService {
    public User findById(String id){
        String randomName = UUID.randomUUID().toString();
        return new User(id,randomName);
    }
}
