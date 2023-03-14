package com.example.workflowmodel.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class WorkflowInst {
    @Id
    private int wfid;

    private Boolean status;

    private String description;

    @ManyToOne
    Workflow wid;


}
