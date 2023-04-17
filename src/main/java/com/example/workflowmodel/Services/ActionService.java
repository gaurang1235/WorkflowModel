package com.example.workflowmodel.Services;

import com.example.workflowmodel.DAO.ActionDao;
import com.example.workflowmodel.DAO.TaskDao;
import com.example.workflowmodel.Entities.Action;
import com.example.workflowmodel.Entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService {

    @Autowired
    private ActionDao actionDao;

    @Autowired
    private TaskDao taskDao;

    public Action addAction(String name, int taskId, int nextTaskId){

        try {
            Action action = new Action();
            Task task = taskDao.findByTaskId(taskId);

            Task nextTask = taskDao.findByTaskId(nextTaskId);


            action.setName(name);
            action.setTask(task);
            action.setNextTask(nextTask);

            action = actionDao.save(action);

            return action;
        }catch (Exception e){
            System.out.println("Adding action error");
            throw new RuntimeException();
        }
    }


    public List<Action> viewActions(int taskId) {
        try {
            Task task = taskDao.findByTaskId(taskId);

            List<Action> actionList = actionDao.findAllByTask(task);

            return actionList;
        }catch (Exception e){
            System.out.println("Viewing action error");
            throw new RuntimeException();
        }
    }
}
