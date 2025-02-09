package com.example.bazario.repository;

import com.example.bazario.models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

import java.util.Optional;

public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByUserName(String email);
    //ArrayList<MyUser> findAllMyUsers();
}
