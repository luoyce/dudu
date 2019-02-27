package com.vincent.duduspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages="com.vincent")
@MapperScan("com.vincent.duduDao")
public class DuduSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuduSpringbootApplication.class, args);
    }

}

