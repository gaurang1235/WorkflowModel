package com.example.workflowmodel.Controllers;

import com.example.workflowmodel.Entities.WorkflowInstance;
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

    @PostMapping("/addWorkflowInstance/{workflowId}")
    public ResponseEntity<WorkflowInstance> addWorkflow(@PathVariable int workflowId, @RequestParam("description") String description){
        try{
            WorkflowInstance workflowInstance = workflowInstanceService.addWorkflowInstance(workflowId, description);

            return ResponseEntity.of(Optional.of(workflowInstance));
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

}
