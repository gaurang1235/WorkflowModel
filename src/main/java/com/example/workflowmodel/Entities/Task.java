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


    @ManyToOne
    private User userAuthorized;

    private String role;

    @OneToOne(mappedBy = "nextTask")
    @JsonIgnore
    private Action prevAction;

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<Action> actionsList;

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<TaskInstance> taskInstanceList;


    public Task() {
    }

    public Task(int taskId, String description, Workflow workflow, User userAuthorized, String role, Action prevAction, List<Action> actionsList, List<TaskInstance> taskInstanceList) {
        this.taskId = taskId;
        this.description = description;
        this.workflow = workflow;
        this.userAuthorized = userAuthorized;
        this.role = role;
        this.prevAction = prevAction;
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

    public Action getPrevAction() {
        return prevAction;
    }

    public void setPrevAction(Action prevAction) {
        this.prevAction = prevAction;
    }

    public List<Action> getActionsList() {
        return actionsList;
    }

    public void setActionsList(List<Action> actionList) {
        this.actionsList = actionList;
    }

    public List<TaskInstance> getTaskInstanceList() {
        return taskInstanceList;
    }

    public void setTaskInstanceList(List<TaskInstance> taskInstanceList) {
        this.taskInstanceList = taskInstanceList;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "taskId=" + taskId +
                ", description='" + description + '\'' +
                ", workflow=" + workflow +
                ", userAuthorized=" + userAuthorized +
                ", role='" + role + '\'' +
                ", prevAction=" + prevAction +
                ", actionsList=" + actionsList +
                ", taskInstanceList=" + taskInstanceList +
                '}';
    }
}
