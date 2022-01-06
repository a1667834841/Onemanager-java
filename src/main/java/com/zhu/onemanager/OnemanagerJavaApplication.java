package com.zhu.onemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OnemanagerJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnemanagerJavaApplication.class, args);
    }

}
