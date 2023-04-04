package com.example.workflowmodel.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TaskInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskInstanceId;

    private String comments;

    private String attachments;

    private String status;

    @ManyToMany
    private List<Users> performedBy;

    @ManyToOne
    private WorkflowInstance workflowInstance;

    @ManyToOne
    private Tasks task;


}
