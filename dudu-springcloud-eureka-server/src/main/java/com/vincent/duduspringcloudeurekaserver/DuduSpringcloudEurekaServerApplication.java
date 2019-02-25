package com.vincent.duduspringcloudeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DuduSpringcloudEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuduSpringcloudEurekaServerApplication.class, args);
    }

}

