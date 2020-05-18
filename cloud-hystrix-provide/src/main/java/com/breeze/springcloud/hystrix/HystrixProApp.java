package com.breeze.springcloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author breeze
 * @date 2020/5/18
 */
@SpringBootApplication
@EnableEurekaClient
public class HystrixProApp {
    public static void main(String[] args) {
        SpringApplication.run(HystrixProApp.class, args);
    }
}
