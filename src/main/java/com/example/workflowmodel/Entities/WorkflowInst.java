package com.example.workflowmodel.Entities;

import jakarta.persistence.*;

@Entity
public class WorkflowInst {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wfid;

    private Boolean status;

    private String description;

    @ManyToOne
    private Workflow wid;
}
