package com.example.bazario.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TestController {

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
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String myBreak() {
        return "index-break";
    }
}
