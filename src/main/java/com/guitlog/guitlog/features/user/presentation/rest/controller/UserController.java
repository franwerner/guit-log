package com.guitlog.guitlog.features.user.presentation.rest.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guitlog.guitlog.features.user.persistence.UserEntity;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    
    @GetMapping("/get")
    public UserEntity getUserById(){
        return new UserEntity();
    }
}
