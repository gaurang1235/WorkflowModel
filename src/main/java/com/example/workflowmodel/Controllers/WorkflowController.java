package com.example.workflowmodel.Controllers;

import com.example.workflowmodel.Entities.Workflow;
import com.example.workflowmodel.Services.WorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/workflow")
public class WorkflowController {

    @Autowired
    private WorkflowService workflowService;

    @PostMapping("/addWorkflow")
    public ResponseEntity<Workflow> addWorkflow(@RequestParam("name") String name){

        Workflow workflow;

        try {
            workflow = workflowService.createWorkflow(name);
        }catch (Exception e){
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.of(Optional.of(workflow));
    }


}
