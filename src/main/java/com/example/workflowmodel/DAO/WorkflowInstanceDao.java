package com.example.workflowmodel.DAO;

import com.example.workflowmodel.Entities.WorkflowInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowInstanceDao extends JpaRepository<WorkflowInstance, Integer> {

}
