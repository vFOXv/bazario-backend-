package com.example.bazario.services;

import com.example.bazario.models.MyUser;
import com.example.bazario.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

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
}
