package com.practice.todolist.service;

import com.practice.todolist.entity.Task;
import com.practice.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Task with ID " + id + " does not exist.");
        }
    }


    public Task updateTask(Long id, Task updateTask){
        Task existingTask = taskRepository.findById (id).orElseThrow(() -> new RuntimeException("task not found with id: " + id));

        if (updateTask.getPriority() == null) {
            throw new IllegalArgumentException("Priority cannot be null");
        }

        existingTask.setTitle(updateTask.getTitle());
        existingTask.setDescription(updateTask.getDescription());
        existingTask.setPriority(updateTask.getPriority());
        existingTask.setStatus(updateTask.getStatus());
        existingTask.setDueDate(updateTask.getDueDate());
        existingTask.setUser(updateTask.getUser());
        existingTask.setUpdatedAt(LocalDateTime.now());

        return taskRepository.save(existingTask);
    }

}
