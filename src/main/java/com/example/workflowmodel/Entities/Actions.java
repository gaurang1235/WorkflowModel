package com.example.workflowmodel.Entities;

import jakarta.persistence.*;

@Entity
public class Actions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actionId;

    @ManyToOne
    private Tasks task;

    private String name;

    @OneToOne
    private Tasks nextTask;


}
