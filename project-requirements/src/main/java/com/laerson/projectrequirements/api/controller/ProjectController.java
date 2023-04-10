package com.laerson.projectrequirements.api.controller;

import com.laerson.projectrequirements.api.modelDTO.input.ProjectInput;
import com.laerson.projectrequirements.domain.model.Project;
import com.laerson.projectrequirements.domain.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@Valid @RequestBody ProjectInput projectInput){
        Project newProject = projectService.save(projectInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProject);
    }
}
