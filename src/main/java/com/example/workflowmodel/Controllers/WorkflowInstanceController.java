package com.example.workflowmodel.Controllers;

import com.example.workflowmodel.Entities.TaskInstance;
import com.example.workflowmodel.Entities.WorkflowInstance;
import com.example.workflowmodel.Services.TaskInstanceService;
import com.example.workflowmodel.Services.WorkflowInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/workflowInstance")
public class WorkflowInstanceController {

    @Autowired
    private WorkflowInstanceService workflowInstanceService;

    @Autowired
    private TaskInstanceService taskInstanceService;

    @PostMapping("/addWorkflowInstance/{userId}/{workflowId}")
    public ResponseEntity<WorkflowInstance> addWorkflowInstance(@PathVariable int userId, @PathVariable int workflowId, @RequestParam("description") String description, @RequestParam("attachments") String attachments){
        try{
            WorkflowInstance workflowInstance = workflowInstanceService.addWorkflowInstance(workflowId, description, userId, attachments);

            TaskInstance taskInstance = taskInstanceService.addFirstTaskInstance(workflowInstance.getWorkflowInstanceId());

            return ResponseEntity.of(Optional.of(workflowInstance));
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

}
