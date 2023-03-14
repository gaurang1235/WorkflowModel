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

    @ManyToMany
    private List<Users> authorised;

    @ManyToOne
    private Workflow wid;





    public Tasks() {
    }

    public Tasks(int tid, String description, Tasks next_tid, List<Users> authorised, Workflow wid) {
        this.tid = tid;
        this.description = description;
        this.next_tid = next_tid;
        this.authorised = authorised;
        this.wid = wid;
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

    @Override
    public String toString() {
        return "Tasks{" +
                "tid=" + tid +
                ", description='" + description + '\'' +
                ", next_tid=" + next_tid +
                ", authorised=" + authorised +
                ", wid=" + wid +
                '}';
    }
}
