package com.example.bazario.controllers;


import com.example.bazario.services.SecurityService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TestController {

    private final SecurityService service;

    public TestController(SecurityService service) {
        this.service = service;
    }


    @GetMapping("/welcome")
    public String welcome() {
        return "index-welcome";
    }

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String myTest() {
        return "index-TEST";
    }

    @GetMapping("/break")

    public String myBreak() {
        return "index-break";
    }

    @GetMapping("/all")
    public String myAll() {
        service.findAllUsers();
        return "list users";
    }
}
