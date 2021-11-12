package com.example.skillsharevideorestservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Skill Share: Video rest service API", version = "1.0"))
public class SkillShareVideoRestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkillShareVideoRestServiceApplication.class, args);
    }
}