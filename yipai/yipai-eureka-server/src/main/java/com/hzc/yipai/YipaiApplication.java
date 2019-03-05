package com.hzc.yipai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class YipaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YipaiApplication.class, args);
    }

}

