package com.example.workflowmodel.Controllers;

import com.example.workflowmodel.Entities.Task;
import com.example.workflowmodel.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/addTaskUsingRole")
    public ResponseEntity<Task> addTaskUsingRole(@RequestParam("description") String description, @RequestParam("workflowId") int workflowId, @RequestParam("role") String role){
        Task task;

        try{
            task = taskService.addTaskUsingRole(description, workflowId, role);
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.of(Optional.of(task));
    }

    @PostMapping("/addTaskUsingUser")
    public ResponseEntity<Task> addTaskUsingUser(@RequestParam("description") String description, @RequestParam("workflowId") int workflowId, @RequestParam("userId") int userId){
        Task task;

        try{
            task = taskService.addTaskUsingUser(description, workflowId, userId);
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.of(Optional.of(task));
    }

}
