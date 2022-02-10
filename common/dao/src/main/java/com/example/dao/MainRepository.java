package com.example.dao;

import com.example.model.MainModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepository extends JpaRepository<MainModel, Long> {

}
