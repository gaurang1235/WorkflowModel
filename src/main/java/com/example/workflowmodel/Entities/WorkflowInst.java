package com.example.workflowmodel.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class WorkflowInst {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wfid;

    private Boolean status;

    private String description;

    @ManyToOne
    private Workflow associated_wid;

    @OneToMany(mappedBy = "workflowInstId")
    private List<TaskInst> taskInstList;


    public WorkflowInst() {
    }

    public WorkflowInst(int wfid, Boolean status, String description, Workflow associated_wid, List<TaskInst> taskInstList) {
        this.wfid = wfid;
        this.status = status;
        this.description = description;
        this.associated_wid = associated_wid;
        this.taskInstList = taskInstList;
    }


    public int getWfid() {
        return wfid;
    }

    public void setWfid(int wfid) {
        this.wfid = wfid;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Workflow getAssociated_wid() {
        return associated_wid;
    }

    public void setAssociated_wid(Workflow associated_wid) {
        this.associated_wid = associated_wid;
    }

    public List<TaskInst> getTaskInstList() {
        return taskInstList;
    }

    public void setTaskInstList(List<TaskInst> taskInstList) {
        this.taskInstList = taskInstList;
    }


    @Override
    public String toString() {
        return "WorkflowInst{" +
                "wfid=" + wfid +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", associated_wid=" + associated_wid +
                ", taskInstList=" + taskInstList +
                '}';
    }
}
