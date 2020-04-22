package com.breeze.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author breeze
 * @date 2020/4/22
 */
@RestController
@Slf4j
public class ConsulConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL = "http://cloud-consul-provider";

    @GetMapping("/consul/consumer")
    public String paymentInfo() {

        return restTemplate.getForObject(URL + "/consul/pro", String.class);
    }

}
