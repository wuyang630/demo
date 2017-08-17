package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by wuyang on 2017/4/7.
 */

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
//@MapperScan("com.example.dao")
//@ComponentScan(basePackages = "com.example")
public class MainController {

    public static void main(String[] args) {
        SpringApplication.run(MainController.class, args);
    }
}
