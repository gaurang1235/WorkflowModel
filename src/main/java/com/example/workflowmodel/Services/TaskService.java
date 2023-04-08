package com.example.workflowmodel.Services;

import com.example.workflowmodel.DAO.TaskDao;
import com.example.workflowmodel.Entities.Task;
import com.example.workflowmodel.Entities.User;
import com.example.workflowmodel.Entities.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private UserService userService;

    public Task addTaskUsingRole(String description, int workflowId, String role){
        try{
            Workflow workflow = workflowService.loadWorkflow(workflowId);

            if(workflow==null){
                System.out.printf("Workflow Not found");
                return null;
            }

            Task task = new Task();

            task.setDescription(description);
            task.setRole(role);
            task.setWorkflow(workflow);

            task = taskDao.save(task);

            return task;
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public Task addTaskUsingUser(String description, int workflowId, int userId){
        try{
            Workflow workflow = workflowService.loadWorkflow(workflowId);
            User user = userService.findUser(userId);

            if(workflow==null || user==null){
                System.out.printf("Workflow Not found");
                return null;
            }

            Task task = new Task();

            task.setDescription(description);
            task.setWorkflow(workflow);
            task.setUserAuthorized(user);

            task = taskDao.save(task);

            return task;
        }catch (Exception e){
            throw new RuntimeException();
        }
    }


}
