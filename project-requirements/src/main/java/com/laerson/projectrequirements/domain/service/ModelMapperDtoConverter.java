package com.laerson.projectrequirements.domain.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelMapperDtoConverter implements ConverterDTO {

    private final ModelMapper modelMapper;

    public ModelMapperDtoConverter(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }


    @Override
    public <S, T> T convertToModelDTO(S entity, Class<T> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    @Override
    public <S, T> List<T> convertToModelListDTO(List<S> entities, Class<T> dtoClass) {
        return entities.stream().map(entity -> convertToModelDTO(entity, dtoClass)).collect(Collectors.toList());
    }

    @Override
    public <S, T> T convertToEntity(S dto, Class<T> entity) {
        return modelMapper.map(dto, entity);
    }
}
