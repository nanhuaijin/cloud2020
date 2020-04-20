package com.breeze.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author breeze
 * @date 2020/4/20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentZKApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentZKApplication.class, args);
    }

}
