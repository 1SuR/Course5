package com.example.course5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class Course5Application {

    public static void main(String[] args) {
        SpringApplication.run(Course5Application.class, args);
    }

}
