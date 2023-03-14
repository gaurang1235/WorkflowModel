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
    private WorkflowInst wfid;


    public TaskInst() {
    }

    public TaskInst(int tinst_id, String comments, List<Users> performedBy, WorkflowInst wfid) {
        this.tinst_id = tinst_id;
        this.comments = comments;
        this.performedBy = performedBy;
        this.wfid = wfid;
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

    public WorkflowInst getWfid() {
        return wfid;
    }

    public void setWfid(WorkflowInst wfid) {
        this.wfid = wfid;
    }

    @Override
    public String toString() {
        return "TaskInst{" +
                "tinst_id=" + tinst_id +
                ", comments='" + comments + '\'' +
                ", performedBy=" + performedBy +
                ", wfid=" + wfid +
                '}';
    }
}
