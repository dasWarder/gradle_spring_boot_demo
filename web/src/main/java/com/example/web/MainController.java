package com.example.web;

import com.example.map.CreateRequest;
import com.example.map.Dto;
import com.example.map.MainMapper;
import com.example.model.MainModel;
import com.example.service.IModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/core")
public class MainController {

  private final IModelService modelService;

  private final MainMapper mainMapper;

  @PostMapping
  public ResponseEntity<Dto> save(@RequestBody CreateRequest dto) {

    MainModel mainModel = mainMapper.requestToMainModel(dto);
    MainModel stored = modelService.save(mainModel);
    Dto response = mainMapper.mainModelToDto(stored);

    return ResponseEntity.ok(response);
  }

  @GetMapping
  public ResponseEntity<List<Dto>> getAll() {

    List<Dto> response =
        modelService.getAll().stream().map(mainMapper::mainModelToDto).collect(Collectors.toList());

    return ResponseEntity.ok(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Dto> getById(@PathVariable("id") Long id) {

    MainModel byId = modelService.getById(id);
    Dto dto = mainMapper.mainModelToDto(byId);

    return ResponseEntity.ok(dto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {

    modelService.deleteById(id);

    return ResponseEntity.noContent().build();
  }
}
