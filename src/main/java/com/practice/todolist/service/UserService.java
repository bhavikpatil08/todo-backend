package com.practice.todolist.service;

import com.practice.todolist.entity.User;
import com.practice.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
     @Autowired
     private UserRepository userRepository;

     public List<User> getAllUser(){
         return userRepository.findAll();
     }

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("User with ID " + id + " does not exist.");
        }
    }



    public User updateUser(Long id, User updatedUser) {
         User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found with id: " + id));

         existingUser.setUsername(updatedUser.getUsername());
         existingUser.setEmail(updatedUser.getEmail());
         existingUser.setPassword(updatedUser.getPassword());
         existingUser.setUpdated_at(LocalDateTime.now());
         existingUser.setCreated_at(LocalDateTime.now());


         return userRepository.save(existingUser);

     }
}
