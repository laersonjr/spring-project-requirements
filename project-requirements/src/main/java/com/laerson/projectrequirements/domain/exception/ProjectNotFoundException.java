package com.laerson.projectrequirements.domain.exception;

public class ProjectNotFoundException extends RuntimeException {

    private static final String ERRO_MENSAGE = "Project not found.";

    public ProjectNotFoundException(){
        super(ERRO_MENSAGE);
    }

}
