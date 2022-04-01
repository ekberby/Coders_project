package com.example.web_demo0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class WebDemo0Application {

    public static void main(String[] args) {
        SpringApplication.run(WebDemo0Application.class, args);
    }

}
