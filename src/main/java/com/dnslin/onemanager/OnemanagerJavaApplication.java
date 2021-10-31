package com.dnslin.onemanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dnslin.onemanager.mapper")
public class OnemanagerJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnemanagerJavaApplication.class, args);
    }

}
