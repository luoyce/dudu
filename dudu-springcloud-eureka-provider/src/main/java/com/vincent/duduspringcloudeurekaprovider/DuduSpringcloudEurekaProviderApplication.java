package com.vincent.duduspringcloudeurekaprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DuduSpringcloudEurekaProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuduSpringcloudEurekaProviderApplication.class, args);
    }

}

