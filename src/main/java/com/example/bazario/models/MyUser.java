package com.example.bazario.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Set;


@Data
@Entity
@Table(name = "users")

public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_name", unique = true)
    private String userName;
    private String password;
    @Column(unique = true)
    private String email;
    private Boolean is_enabled;
    @ManyToMany(fetch = FetchType.EAGER) // EAGER, чтобы роли загружались сразу
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
