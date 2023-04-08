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

    public WorkflowInstance() {
    }

    public WorkflowInstance(int workflowInstanceId, String status, String description, Workflow workflow, List<TaskInstance> taskInstanceList) {
        this.workflowInstanceId = workflowInstanceId;
        this.status = status;
        this.description = description;
        this.workflow = workflow;
        this.taskInstanceList = taskInstanceList;
    }

    public int getWorkflowInstanceId() {
        return workflowInstanceId;
    }

    public void setWorkflowInstanceId(int workflowInstanceId) {
        this.workflowInstanceId = workflowInstanceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    public List<TaskInstance> getTaskInstanceList() {
        return taskInstanceList;
    }

    public void setTaskInstanceList(List<TaskInstance> taskInstanceList) {
        this.taskInstanceList = taskInstanceList;
    }

    @Override
    public String toString() {
        return "WorkflowInstance{" +
                "workflowInstanceId=" + workflowInstanceId +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", workflow=" + workflow +
                ", taskInstanceList=" + taskInstanceList +
                '}';
    }
}
