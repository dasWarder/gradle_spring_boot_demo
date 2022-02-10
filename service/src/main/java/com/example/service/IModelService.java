package com.example.service;

import com.example.model.MainModel;

import java.util.List;

public interface IModelService {

    MainModel save(MainModel mainModel);

    MainModel getById(Long id);

    void deleteById(Long id);

    List<MainModel> getAll();
}
