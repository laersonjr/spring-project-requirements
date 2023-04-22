package com.laerson.projectrequirements.domain.service;

import com.laerson.projectrequirements.api.modelDTO.input.ProjectInput;
import com.laerson.projectrequirements.domain.model.ProcessStatus;
import com.laerson.projectrequirements.domain.model.Project;
import com.laerson.projectrequirements.domain.repository.ProjectRepository;
import lombok.AllArgsConstructor;
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
}
