package com.example.workflowmodel.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class WorkflowInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workflowInstanceId;

    private String status;

    private String description;

    @ManyToOne
    private Workflow workflow;

    @OneToMany(mappedBy = "workflowInstance")
    private List<TaskInstance> taskInstanceList;

}
