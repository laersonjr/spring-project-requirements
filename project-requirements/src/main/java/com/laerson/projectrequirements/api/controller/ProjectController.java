package com.laerson.projectrequirements.api.controller;

import com.laerson.projectrequirements.api.modelDTO.input.ProjectInput;
import com.laerson.projectrequirements.domain.model.Project;
import com.laerson.projectrequirements.domain.repository.ProjectRepository;
import com.laerson.projectrequirements.domain.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectRepository projectRepository;

    public ProjectController(ProjectService projectService, ProjectRepository projectRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@Valid @RequestBody ProjectInput projectInput){
        Project newProject = projectService.save(projectInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProject);
    }

    @GetMapping
    public Page<Project> listProject(@RequestParam(required = false, defaultValue = "") String name, Pageable pageable){
        return projectRepository.findByNameContaining(name, pageable);
    }

}
