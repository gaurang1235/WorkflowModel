package com.example.workflowmodel.Services;

import com.example.workflowmodel.DAO.UserDao;
import com.example.workflowmodel.DAO.WorkflowDao;
import com.example.workflowmodel.DAO.WorkflowInstanceDao;
import com.example.workflowmodel.Entities.User;
import com.example.workflowmodel.Entities.Workflow;
import com.example.workflowmodel.Entities.WorkflowInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowInstanceService {

    @Autowired
    private WorkflowInstanceDao workflowInstanceDao;

    @Autowired
    private WorkflowDao workflowDao;

    @Autowired
    private UserDao userDao;



    public WorkflowInstance addWorkflowInstance(int workflowId, String description, int userId){

        try {
            WorkflowInstance workflowInstance = new WorkflowInstance();
            User user = userDao.findByUserId(userId);

            Workflow workflow = workflowDao.findByWorkflowId(workflowId);

            workflowInstance.setWorkflow(workflow);
            workflowInstance.setStatus("pending");
            workflowInstance.setDescription(description);
            workflowInstance.setCreatedBy(user);


            workflowInstance = workflowInstanceDao.save(workflowInstance);

            return workflowInstance;
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
