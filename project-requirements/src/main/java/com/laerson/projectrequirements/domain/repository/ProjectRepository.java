package com.laerson.projectrequirements.domain.repository;

import com.laerson.projectrequirements.domain.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    public Page<Project> findByNameContaining(String name, Pageable pageable);

}