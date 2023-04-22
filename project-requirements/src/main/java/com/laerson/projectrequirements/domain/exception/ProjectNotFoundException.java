package com.laerson.projectrequirements.domain.exception;

public class ProjectNotFoundException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Project not found.";

    public ProjectNotFoundException(){
        super(ERROR_MESSAGE);
    }

}
