package com.example.workflowmodel.DAO;

import com.example.workflowmodel.Entities.TaskInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskInstanceDao extends JpaRepository<TaskInstance, Integer> {

    public List<TaskInstance> findAllByStatusIs(String status);

}
