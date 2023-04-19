package com.example.workflowmodel.Controllers;

import com.example.workflowmodel.Entities.User;
import com.example.workflowmodel.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUser(){
        try{
            List<User> userList = userService.getAllUsers();

            return ResponseEntity.of(Optional.of(userList));
        }catch (Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }
}
