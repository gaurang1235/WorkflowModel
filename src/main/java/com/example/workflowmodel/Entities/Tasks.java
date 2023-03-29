package com.example.workflowmodel.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;

    private String description;

    @OneToOne
    private Tasks next_tid;

    @OneToOne(mappedBy = "next_tid")
    private Tasks prev_id;

    @ManyToMany
    private List<Users> authorised;

    @ManyToOne
    private Workflow wid;

    @OneToMany(mappedBy = "taskId")
    private List<TaskInst> taskInstList;


    public Tasks() {
    }

    public Tasks(int tid, String description, Tasks next_tid, Tasks prev_id, List<Users> authorised, Workflow wid, List<TaskInst> taskInstList) {
        this.tid = tid;
        this.description = description;
        this.next_tid = next_tid;
        this.prev_id = prev_id;
        this.authorised = authorised;
        this.wid = wid;
        this.taskInstList = taskInstList;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tasks getNext_tid() {
        return next_tid;
    }

    public void setNext_tid(Tasks next_tid) {
        this.next_tid = next_tid;
    }

    public Tasks getPrev_id() {
        return prev_id;
    }

    public void setPrev_id(Tasks prev_id) {
        this.prev_id = prev_id;
    }

    public List<Users> getAuthorised() {
        return authorised;
    }

    public void setAuthorised(List<Users> authorised) {
        this.authorised = authorised;
    }

    public Workflow getWid() {
        return wid;
    }

    public void setWid(Workflow wid) {
        this.wid = wid;
    }

    public List<TaskInst> getTaskInstList() {
        return taskInstList;
    }

    public void setTaskInstList(List<TaskInst> taskInstList) {
        this.taskInstList = taskInstList;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "tid=" + tid +
                ", description='" + description + '\'' +
                ", next_tid=" + next_tid +
                ", prev_id=" + prev_id +
                ", authorised=" + authorised +
                ", wid=" + wid +
                ", taskInstList=" + taskInstList +
                '}';
    }
}
