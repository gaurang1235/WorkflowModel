package com.example.workflowmodel.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;

    private String role;

    @OneToMany(mappedBy = "userAuthorized")
    private List<Tasks> tasksAuthorized;

    @ManyToMany(mappedBy = "performedBy")
    private List<TaskInstance> taskInstancesPerformedList;

}
