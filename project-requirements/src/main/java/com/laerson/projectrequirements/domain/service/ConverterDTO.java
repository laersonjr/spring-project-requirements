package com.laerson.projectrequirements.domain.service;

import java.util.List;

public interface ConverterDTO {
    // S -> Source, T -> Target
    <S, T> T convertToModelDTO(S entity, Class<T> dtoClass);
    <S, T> List<T> convertToModelListDTO(List<S> entities, Class<T> dtoClass);
    <S, T> T convertToEntity(S dto, Class<T> entity);
}
