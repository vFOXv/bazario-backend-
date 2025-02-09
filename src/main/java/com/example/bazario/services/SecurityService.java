package com.example.bazario.services;

import com.example.bazario.models.MyUser;
import com.example.bazario.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SecurityService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public SecurityService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(MyUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

    public void findAllUsers() {
        ArrayList<MyUser> users =(ArrayList<MyUser>) repository.findAll();
        for (MyUser user : users) {
            System.out.println(user);
        }
    }
}
