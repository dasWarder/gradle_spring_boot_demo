package com.example.map;

import com.example.model.MainModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MainMapper {

    Dto mainModelToDto(MainModel mainModel);

    @Mapping(target = "id", ignore = true)
    MainModel requestToMainModel(CreateRequest request);
}
