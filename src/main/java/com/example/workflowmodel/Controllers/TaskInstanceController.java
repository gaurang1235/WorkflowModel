package com.example.workflowmodel.Controllers;

import com.example.workflowmodel.DAO.TaskInstanceDao;
import com.example.workflowmodel.Entities.TaskInstance;
import com.example.workflowmodel.Services.TaskInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/taskInstance")
public class TaskInstanceController {

    @Autowired
    private TaskInstanceService taskInstanceService;

    @GetMapping("/fetchTaskInstances/{userId}")
    public ResponseEntity<List<TaskInstance>> getTaskInstanceList(@PathVariable int userId){
        try{
            List<TaskInstance> taskInstanceList = taskInstanceService.fetchTaskInstanceForUser(userId);

            return ResponseEntity.of(Optional.of(taskInstanceList));
        }catch (Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }

}
