package com.breeze.springcloud.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author breeze
 * @date 2020/4/21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZkOrderApplication.class, args);
    }
}
