package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.example.model")
@EnableJpaRepositories(basePackages = "com.example.dao")
@SpringBootApplication(
    scanBasePackages = {
      "com.example.model",
      "com.example.dao",
      "com.example.service",
      "com.example.map",
      "com.example.web"
    })
public class SpringProject {

  public static void main(String[] args) {
    SpringApplication.run(SpringProject.class, args);
  }
}
