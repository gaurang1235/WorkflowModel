package com.example.workflowmodel.Services;

import com.example.workflowmodel.DAO.TaskDao;
import com.example.workflowmodel.DAO.UserDao;
import com.example.workflowmodel.DAO.WorkflowDao;
import com.example.workflowmodel.Entities.Task;
import com.example.workflowmodel.Entities.User;
import com.example.workflowmodel.Entities.Workflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class WorkflowService {

    @Autowired
    private WorkflowDao workflowDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TaskDao taskDao;


    public Workflow createWorkflow(String name){
        Workflow workflow = new Workflow();

        workflow.setName(name);

        Task acceptTask = new Task();
        Task rejectTask = new Task();

        try{
            workflow = workflowDao.save(workflow);


            acceptTask.setWorkflow(workflow);
            rejectTask.setWorkflow(workflow);

            acceptTask.setDescription("Accepted");
            acceptTask.setRole("");
            rejectTask.setDescription("Rejected");
            rejectTask.setRole("");


            taskDao.save(acceptTask);
            taskDao.save(rejectTask);
        }catch (Exception e){
            System.out.println("creating workflow error");
            throw new RuntimeException();
        }

        return workflow;
    }

    public Workflow loadWorkflow(int id){
        Workflow workflow;
        try {
            workflow = workflowDao.findByWorkflowId(id);
        }catch (Exception e){
            System.out.println("Workflow search error");
            throw new RuntimeException();
        }

        return workflow;
    }


    public List<Workflow> findAllWorkflowForUser(int userId){

        try{
            User user = userDao.findByUserId(userId);

            if(user==null){
                System.out.println("User not found");
                throw new RuntimeException();
            }

            List<Task> firstTasks = taskDao.findAllByPrevActionIsNull();


            HashSet<Workflow> workflowList = new HashSet<>();


            System.out.println(firstTasks.size());

            firstTasks.forEach(firstTask->{if((firstTask.getRole()!=null && firstTask.getRole().equals(user.getRole())) || (firstTask.getUserAuthorized()!=null && firstTask.getUserAuthorized().equals(user))) workflowList.add(firstTask.getWorkflow());});


            List<Workflow> returnWorkflowList = new ArrayList<>();

            workflowList.forEach(workflow -> {returnWorkflowList.add(workflow);});

            return returnWorkflowList;
        }catch (Exception e){
            System.out.println("finding workflow for user error");
            throw new RuntimeException();
        }
    }


    public List<Workflow> getAllWorkflows() {
        try {
            List<Workflow> workflowList = workflowDao.findAll();

            return workflowList;
        }catch (Exception e){
            System.out.println("All workflow get failed");

            throw new RuntimeException();
        }
    }
}
