package com.laerson.projectrequirements.domain.service;

import com.laerson.projectrequirements.api.modelDTO.input.ProjectInput;
import com.laerson.projectrequirements.domain.exception.ProjectNotFoundException;
import com.laerson.projectrequirements.domain.model.ProcessStatus;
import com.laerson.projectrequirements.domain.model.Project;
import com.laerson.projectrequirements.domain.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapperDtoConverter modelMapperDtoConverter;

    public Project save(ProjectInput projectInput) {
        Project project = modelMapperDtoConverter.convertToEntity(projectInput, Project.class);
        project.startStatus();
        return projectRepository.save(project);
    }

    //TODO: Tratar exceção lançada quando passa um id no json diferente do que consta na URL
    public Project updateProjectService(Long idProject, Project project) {
        Project updateProject = findProjectOrThrow(idProject);

        modelMapperDtoConverter.configureModelMapperForUpdate(project, updateProject);

        return projectRepository.save(updateProject);
    }

    private Project findProjectOrThrow(Long idProject){
        return projectRepository.findById(idProject)
                .orElseThrow(() -> new ProjectNotFoundException());
    }

}
