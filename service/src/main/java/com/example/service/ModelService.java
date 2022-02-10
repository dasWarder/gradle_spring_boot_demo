package com.example.service;

import com.example.dao.MainRepository;
import com.example.model.MainModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ModelService implements IModelService {

    private final MainRepository mainRepository;

    @Override
    public MainModel save(MainModel mainModel) {
        log.info("Store");
        return mainRepository.save(mainModel);
    }

    @Override
    public MainModel getById(Long id) {
        log.info("Get");
        return mainRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete");
        mainRepository.deleteById(id);
    }

    @Override
    public List<MainModel> getAll() {
        log.info("Get all");
        return (List<MainModel>) mainRepository.findAll();
    }
}
