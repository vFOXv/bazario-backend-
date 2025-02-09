package com.example.bazario.controllers;

import com.example.bazario.models.MyUser;
import com.example.bazario.services.SecurityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security")

public class UserController {

    private final SecurityService service;

    public UserController(SecurityService service) {
        this.service = service;
    }

    @PostMapping("new")
    public String newUser(@RequestBody MyUser user){
        service.saveUser(user);
        return "User is saved!";
    }
}
