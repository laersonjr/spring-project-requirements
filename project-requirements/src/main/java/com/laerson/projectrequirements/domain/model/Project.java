package com.laerson.projectrequirements.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private LocalDateTime startDate;
    private LocalDateTime expectedDate;
    private LocalDateTime finalizedDate;
    private ProcessStatus status;

}
