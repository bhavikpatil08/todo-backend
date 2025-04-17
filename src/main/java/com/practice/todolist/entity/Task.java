package com.practice.todolist.entity;


import jakarta.annotation.Priority;
import jakarta.persistence.*;
import jakarta.transaction.Status;
import jdk.jshell.Snippet;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum Priority {
        High, Medium, Low
    }

    public enum Status {
        Pending, InProgress, Completed
    }

    public Task() {}

    public Task(String title, String description, Priority priority, Status status, LocalDate dueDate, User user){
        this.title = title;

        this.description = description;
        this.priority = priority;
        this.status = status;
        this.dueDate = dueDate;
        this.user = user;
    }




}
