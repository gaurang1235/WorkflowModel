package com.example.workflowmodel.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Workflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workflowId;
    private String name;
    @OneToMany(mappedBy = "workflow")
    private List<Tasks> tasksList;

    @OneToMany(mappedBy = "workflow")
    private List<WorkflowInstance> workflowInstanceList;


}
