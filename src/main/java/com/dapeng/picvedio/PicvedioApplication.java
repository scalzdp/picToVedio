package com.dapeng.picvedio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PicvedioApplication {

    public static void main(String[] args) {
        SpringApplication.run(PicvedioApplication.class, args);
    }

}
