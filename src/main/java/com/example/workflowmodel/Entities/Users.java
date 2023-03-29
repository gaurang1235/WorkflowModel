package com.example.workflowmodel.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    private String name;

    private String role;

    @ManyToMany(mappedBy = "authorised")
    private List<Tasks> tasksList;


    @ManyToMany(mappedBy = "performedBy")
    private List<TaskInst> taskInstList;


    public Users() {
    }

    public Users(int uid, String name, String role, List<Tasks> tasksList, List<TaskInst> taskInstList) {
        this.uid = uid;
        this.name = name;
        this.role = role;
        this.tasksList = tasksList;
        this.taskInstList = taskInstList;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public List<Tasks> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<Tasks> tasksList) {
        this.tasksList = tasksList;
    }

    public List<TaskInst> getTaskInstList() {
        return taskInstList;
    }

    public void setTaskInstList(List<TaskInst> taskInstList) {
        this.taskInstList = taskInstList;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", tasksList=" + tasksList +
                ", taskInstList=" + taskInstList +
                '}';
    }
}
