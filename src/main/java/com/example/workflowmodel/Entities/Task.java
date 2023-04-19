package com.example.workflowmodel.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    private String description;

    @ManyToOne
    private Workflow workflow;

    private Boolean anyAll;

    private Boolean isFirst;

    @ManyToOne
    private User userAuthorized;

    private String role;

    @OneToMany(mappedBy = "nextTask")
    @JsonIgnore
    private List<Action> prevActions;

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<Action> actionsList;

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<TaskInstance> taskInstanceList;


    public Task() {
    }

    public Task(int taskId, String description, Workflow workflow, Boolean anyAll, Boolean isFirst, User userAuthorized, String role, List<Action> prevActions, List<Action> actionsList, List<TaskInstance> taskInstanceList) {
        this.taskId = taskId;
        this.description = description;
        this.workflow = workflow;
        this.anyAll = anyAll;
        this.isFirst = isFirst;
        this.userAuthorized = userAuthorized;
        this.role = role;
        this.prevActions = prevActions;
        this.actionsList = actionsList;
        this.taskInstanceList = taskInstanceList;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
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

    public Boolean getAnyAll() {
        return anyAll;
    }

    public void setAnyAll(Boolean anyAll) {
        this.anyAll = anyAll;
    }

    public Boolean getFirst() {
        return isFirst;
    }

    public void setFirst(Boolean first) {
        isFirst = first;
    }

    public User getUserAuthorized() {
        return userAuthorized;
    }

    public void setUserAuthorized(User userAuthorized) {
        this.userAuthorized = userAuthorized;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Action> getPrevActions() {
        return prevActions;
    }

    public void setPrevActions(List<Action> prevActions) {
        this.prevActions = prevActions;
    }

    public List<Action> getActionsList() {
        return actionsList;
    }

    public void setActionsList(List<Action> actionsList) {
        this.actionsList = actionsList;
    }

    public List<TaskInstance> getTaskInstanceList() {
        return taskInstanceList;
    }

    public void setTaskInstanceList(List<TaskInstance> taskInstanceList) {
        this.taskInstanceList = taskInstanceList;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", description='" + description + '\'' +
                ", workflow=" + workflow +
                ", anyAll=" + anyAll +
                ", isFirst=" + isFirst +
                ", userAuthorized=" + userAuthorized +
                ", role='" + role + '\'' +
                ", prevActions=" + prevActions +
                ", actionsList=" + actionsList +
                ", taskInstanceList=" + taskInstanceList +
                '}';
    }
}
