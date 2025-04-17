package com.practice.todolist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class User {

    public User() {}
    public User(String email, Long id, String username, LocalDateTime created_at, String password, LocalDateTime updated_at) {
        super();
        this.email = email;
        this.id = id;
        this.username = username;
        this.created_at = created_at;
        this.password = password;
        this.updated_at = updated_at;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String username;



    @Column(nullable = false)
    private String password;

    @Column(name = "created_at")
    private LocalDateTime created_at = LocalDateTime.now();;

    @Column(name = "updated_at")
    private LocalDateTime updated_at = LocalDateTime.now();



}
