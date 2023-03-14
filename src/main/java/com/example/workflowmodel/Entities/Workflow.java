package com.example.workflowmodel.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Workflow {
    @Id
    private int wid;
    private String name;
    @OneToMany
    private List<Tasks> ltids;

    public Workflow() {
    }

    public Workflow(int wid, String name, List<Tasks> ltids) {
        this.wid = wid;
        this.name = name;
        this.ltids = ltids;
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

    public List<Tasks> getLtids() {
        return ltids;
    }

    public void setLtids(List<Tasks> ltids) {
        this.ltids = ltids;
    }


    @Override
    public String toString() {
        return "Workflow{" +
                "wid=" + wid +
                ", name='" + name + '\'' +
                ", ltids=" + ltids +
                '}';
    }
}
