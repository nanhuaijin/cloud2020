package com.breeze.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author breeze
 * @date 2020/4/21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsulConsumerApp.class, args);
    }
}
