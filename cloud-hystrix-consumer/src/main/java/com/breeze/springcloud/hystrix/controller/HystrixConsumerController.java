package com.breeze.springcloud.hystrix.controller;

import com.breeze.springcloud.hystrix.service.HystrixProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author breeze
 * @date 2020-05-20
 */
@RestController
public class HystrixConsumerController {

    @Autowired
    private HystrixProService hystrixProService;

    @GetMapping("/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        return this.hystrixProService.paymentInfoOk(id);
    }

    @GetMapping("/time/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        return this.hystrixProService.paymentInfoTimeOut(id);
    }
}
