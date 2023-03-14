package com.example.workflowmodel.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Users {

    @Id
    private int uid;

    private String name;

    private String role;

    @ManyToMany
    private List<Tasks> tid;

    public Users() {
    }

    public Users(int uid, String name, String role, List<Tasks> tid) {
        this.uid = uid;
        this.name = name;
        this.role = role;
        this.tid = tid;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Tasks> getTid() {
        return tid;
    }

    public void setTid(List<Tasks> tid) {
        this.tid = tid;
    }


    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", tid=" + tid +
                '}';
    }
}
