package com.laerson.projectrequirements.domain.service;

public interface ConverterDTO {
    <S, T> T convertToModelDTO(S entity, Class<T> dtoClass);
    <S, T> T convertToEntity(S dto, Class<T> entity);
}