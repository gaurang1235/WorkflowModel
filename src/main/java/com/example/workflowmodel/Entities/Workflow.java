package com.example.workflowmodel.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Workflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wid;
    private String name;
    @OneToMany(mappedBy = "wid")
    private List<Tasks> tasksList;

    @OneToMany(mappedBy = "associated_wid")
    private List<WorkflowInst> workflowInstList;


    public Workflow() {
    }

    public Workflow(int wid, String name, List<Tasks> tasksList, List<WorkflowInst> workflowInstList) {
        this.wid = wid;
        this.name = name;
        this.tasksList = tasksList;
        this.workflowInstList = workflowInstList;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tasks> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<Tasks> tasksList) {
        this.tasksList = tasksList;
    }

    public List<WorkflowInst> getWorkflowInstList() {
        return workflowInstList;
    }

    public void setWorkflowInstList(List<WorkflowInst> workflowInstList) {
        this.workflowInstList = workflowInstList;
    }

    @Override
    public String toString() {
        return "Workflow{" +
                "wid=" + wid +
                ", name='" + name + '\'' +
                ", tasksList=" + tasksList +
                ", workflowInstList=" + workflowInstList +
                '}';
    }
}
