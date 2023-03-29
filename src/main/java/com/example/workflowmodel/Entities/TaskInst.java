package com.example.workflowmodel.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TaskInst {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tinst_id;

    private String comments;

    @ManyToMany
    private List<Users> performedBy;

    @ManyToOne
    private WorkflowInst workflowInstId;

    @ManyToOne
    private Tasks taskId;

    public TaskInst() {
    }

    public TaskInst(int tinst_id, String comments, List<Users> performedBy, WorkflowInst workflowInstId, Tasks taskId) {
        this.tinst_id = tinst_id;
        this.comments = comments;
        this.performedBy = performedBy;
        this.workflowInstId = workflowInstId;
        this.taskId = taskId;
    }

    public int getTinst_id() {
        return tinst_id;
    }

    public void setTinst_id(int tinst_id) {
        this.tinst_id = tinst_id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<Users> getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(List<Users> performedBy) {
        this.performedBy = performedBy;
    }

    public WorkflowInst getWorkflowInstId() {
        return workflowInstId;
    }

    public void setWorkflowInstId(WorkflowInst workflowInstId) {
        this.workflowInstId = workflowInstId;
    }

    public Tasks getTaskId() {
        return taskId;
    }

    public void setTaskId(Tasks taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "TaskInst{" +
                "tinst_id=" + tinst_id +
                ", comments='" + comments + '\'' +
                ", performedBy=" + performedBy +
                ", workflowInstId=" + workflowInstId +
                ", taskId=" + taskId +
                '}';
    }
}
