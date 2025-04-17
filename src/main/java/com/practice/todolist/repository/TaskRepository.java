package com.practice.todolist.repository;

import com.practice.todolist.entity.Task;
import com.practice.todolist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long>{

}

