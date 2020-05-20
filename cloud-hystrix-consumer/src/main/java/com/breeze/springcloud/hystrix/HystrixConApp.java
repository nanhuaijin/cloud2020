package com.breeze.springcloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author breeze
 * @date 2020-05-20
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class HystrixConApp {
    public static void main(String[] args) {
        SpringApplication.run(HystrixConApp.class, args);
    }
}
