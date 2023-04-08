package com.example.workflowmodel.Services;

import com.example.workflowmodel.DAO.WorkflowDao;
import com.example.workflowmodel.Entities.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowService {

    @Autowired
    private WorkflowDao workflowDao;


    public Workflow createWorkflow(String name){
        Workflow workflow = new Workflow();

        workflow.setName(name);

        try{
            workflow = workflowDao.save(workflow);
        }catch (Exception e){
            throw new RuntimeException();
        }

        return workflow;
    }

    public Workflow loadWorkflow(int id){
        Workflow workflow;
        try {
            workflow = workflowDao.findByWorkflowId(id);
        }catch (Exception e){
            throw new RuntimeException();
        }

        return workflow;
    }



}
