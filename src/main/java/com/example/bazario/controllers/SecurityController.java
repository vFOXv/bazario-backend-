package com.example.bazario.controllers;

import com.example.bazario.models.MyUser;
import com.example.bazario.services.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("security")

public class SecurityController {

    private final SecurityService service;

    public SecurityController(SecurityService service) {
        this.service = service;
    }

    @PostMapping("new")
    public String newUser(@RequestBody MyUser user){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(user);
        service.saveUser(user);
        System.out.println(user);
        return "User is saved";
    }
}
