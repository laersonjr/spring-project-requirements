package com.laerson.projectrequirements.domain.repository;

import com.laerson.projectrequirements.domain.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}