package com.breeze.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author breeze
 * @date 2020/4/21
 */
@RestController
@Slf4j
public class ConsulProviderController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/consul/pro")
    public String consulPro() {
        return "springCloud with consul: " + serverPort
                + "\t" + UUID.randomUUID().toString();
    }
}
