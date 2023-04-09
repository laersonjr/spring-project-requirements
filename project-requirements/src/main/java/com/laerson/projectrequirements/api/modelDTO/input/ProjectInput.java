package com.laerson.projectrequirements.api.modelDTO.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectInput {

    private Long id;

    @NotBlank
    private String name;

}
