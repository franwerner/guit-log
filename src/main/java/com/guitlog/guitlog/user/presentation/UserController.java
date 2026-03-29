package com.guitlog.guitlog.user.presentation;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guitlog.guitlog.user.domain.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    
    @GetMapping("/get")
    public User getUserById(){
        LocalDateTime now = LocalDateTime.now();
        return new User(
            123123123L,
            "123",
            now,
            30  
        );
    }
}
