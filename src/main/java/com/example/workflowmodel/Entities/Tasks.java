package com.example.workflowmodel.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    private String description;

    @ManyToOne
    private Workflow workflow;


    @ManyToOne
    private Users userAuthorized;

    private String role;

    @OneToOne(mappedBy = "nextTask")
    private Actions prevAction;

    @OneToMany(mappedBy = "task")
    private List<Actions> actionsList;

    @OneToMany(mappedBy = "task")
    private List<TaskInstance> taskInstanceList;

}
