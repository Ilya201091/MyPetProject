package com.ilya.test.mydemoproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyDemoProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyDemoProjectApplication.class, args);
    }

    public ModelMapper getMapper() {
        return new ModelMapper();
    }

}
