package com.example.workflowmodel.Services;

import com.example.workflowmodel.DAO.*;
import com.example.workflowmodel.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class TaskInstanceService {

    @Autowired
    private TaskInstanceDao taskInstanceDao;

    @Autowired
    private WorkflowInstanceDao workflowInstanceDao;

    @Autowired
    private UserDao userDao;

    private TaskDao taskDao;

    @Autowired
    private TaskInstancePerformedByDao taskInstancePerformedByDao;

    public TaskInstance addFirstTaskInstance(int workflowInstanceId){
        try{
            WorkflowInstance workflowInstance = workflowInstanceDao.findByWorkflowInstanceId(workflowInstanceId);


            if(workflowInstance==null){
                System.out.println("WorkflowInstance not found");
                throw new RuntimeException();
            }

            TaskInstance taskInstance = new TaskInstance();

            taskInstance.setWorkflowInstance(workflowInstance);
            taskInstance.setStatus("Pending");

            List<Task> taskList = workflowInstance.getWorkflow().getTasksList();

            //System.out.println(taskList.size());

            Task task = new Task();

            for(int i =0;i<taskList.size();i++){
                if(taskList.get(i).getFirst()==true) {
                    task = taskList.get(i);
                    break;
                }
            }



            //System.out.println("2");

//            if(task.get() ==null){
//                System.out.println("Error in fetching task for taskInstance");
//                throw new RuntimeException();
//            }

            taskInstance.setTask(task);

            List<User> performedByUserList = new ArrayList<>();

            if(userDao.findByRole(workflowInstance.getCreatedBy().getRole())!=null)
                performedByUserList.addAll(userDao.findByRole(workflowInstance.getCreatedBy().getRole()));
            else
                performedByUserList.add(workflowInstance.getCreatedBy());



            TaskInstance finalTaskInstance = taskInstance;
            taskInstance.setTaskInstancePerformedByList(performedByUserList.stream().map(user -> {
                TaskInstancePerformedBy taskInstancePerformedBy = new TaskInstancePerformedBy();
                taskInstancePerformedBy.setUser(user);
                taskInstancePerformedBy.setTaskInstance(finalTaskInstance);
                taskInstancePerformedBy.setStatus("Pending");
                return taskInstancePerformedBy;
            }).toList());

            taskInstance = taskInstanceDao.save(taskInstance);

            return taskInstance;
        }
        catch (Exception e){
            System.out.println("Error while adding TaskInstance");
            throw new RuntimeException();
        }
    }


    public List<TaskInstance> fetchTaskInstanceForUser(int userId){
        try{

            User user = userDao.findByUserId(userId);

            List<TaskInstancePerformedBy> taskInstancePerformedByList = taskInstancePerformedByDao.findByStatusAndUser("Pending", user);

            List<TaskInstance> taskInstanceList = new ArrayList<>();

            taskInstancePerformedByList.forEach(taskInstancePerformedBy -> {taskInstanceList.add(taskInstancePerformedBy.getTaskInstance());});


            return taskInstanceList;
        }catch (Exception e){
            System.out.println("fetching taskinstance for user error");
            throw new RuntimeException();
        }
    }

}
