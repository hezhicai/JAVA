package com.example.demojdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "com.example.demojdbc.mapper")
@SpringBootApplication
public class DemoJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJdbcApplication.class, args);
    }

}
