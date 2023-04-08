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
    private List<User> performedBy;

    @ManyToOne
    private WorkflowInstance workflowInstance;

    @ManyToOne
    private Task task;


    public TaskInstance() {
    }

    public TaskInstance(int taskInstanceId, String comments, String attachments, String status, List<User> performedBy, WorkflowInstance workflowInstance, Task task) {
        this.taskInstanceId = taskInstanceId;
        this.comments = comments;
        this.attachments = attachments;
        this.status = status;
        this.performedBy = performedBy;
        this.workflowInstance = workflowInstance;
        this.task = task;
    }

    public int getTaskInstanceId() {
        return taskInstanceId;
    }

    public void setTaskInstanceId(int taskInstanceId) {
        this.taskInstanceId = taskInstanceId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(List<User> performedBy) {
        this.performedBy = performedBy;
    }

    public WorkflowInstance getWorkflowInstance() {
        return workflowInstance;
    }

    public void setWorkflowInstance(WorkflowInstance workflowInstance) {
        this.workflowInstance = workflowInstance;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "TaskInstance{" +
                "taskInstanceId=" + taskInstanceId +
                ", comments='" + comments + '\'' +
                ", attachments='" + attachments + '\'' +
                ", status='" + status + '\'' +
                ", performedBy=" + performedBy +
                ", workflowInstance=" + workflowInstance +
                ", task=" + task +
                '}';
    }
}
