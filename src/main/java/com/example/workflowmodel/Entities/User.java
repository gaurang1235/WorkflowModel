package com.example.workflowmodel.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;

    private String role;

    @OneToMany(mappedBy = "userAuthorized")
    @JsonIgnore
    private List<Task> tasksAuthorized;

    @ManyToMany(mappedBy = "performedBy")
    @JsonIgnore
    private List<TaskInstance> taskInstancesPerformedList;


    public User() {
    }

    public User(int userId, String name, String role, List<Task> tasksAuthorized, List<TaskInstance> taskInstancesPerformedList) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.tasksAuthorized = tasksAuthorized;
        this.taskInstancesPerformedList = taskInstancesPerformedList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Task> getTasksAuthorized() {
        return tasksAuthorized;
    }

    public void setTasksAuthorized(List<Task> taskAuthorized) {
        this.tasksAuthorized = taskAuthorized;
    }

    public List<TaskInstance> getTaskInstancesPerformedList() {
        return taskInstancesPerformedList;
    }

    public void setTaskInstancesPerformedList(List<TaskInstance> taskInstancesPerformedList) {
        this.taskInstancesPerformedList = taskInstancesPerformedList;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", tasksAuthorized=" + tasksAuthorized +
                ", taskInstancesPerformedList=" + taskInstancesPerformedList +
                '}';
    }
}
