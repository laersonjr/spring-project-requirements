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
import java.util.Optional;

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

    @GetMapping("/{idProject}")
    public ResponseEntity<Project> searchProjectById(@PathVariable Long idProject){
        return projectRepository.findById(idProject)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{idProject}")
    public ResponseEntity<Project> updateProjectById(@PathVariable Long idProject,
                                                        @RequestBody @Valid Project project) {
        Project updateProject = projectService.updateProjectService(idProject, project);

        return ResponseEntity.ok(updateProject);
    }


    @DeleteMapping("/{idProject}")
    public ResponseEntity<Void> deleteProjectById(@PathVariable Long idProject){
            Optional<Project> project = projectRepository.findById(idProject);

            if(project.isPresent()){
                projectRepository.deleteById(idProject);
                return ResponseEntity.noContent().build();
            }

        return ResponseEntity.notFound().build();
    }


}
