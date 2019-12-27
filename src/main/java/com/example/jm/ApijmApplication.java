package com.example.jm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.jm.mapper")
public class ApijmApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApijmApplication.class, args);
    }

}
