package com.breeze.springcloud.order.comtroller;

import com.breeze.springcloud.common.CommonResult;
import com.breeze.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeoutException;

/**
 * @author breeze
 * @date 2020/3/15
 */
@RestController
@Slf4j
@RequestMapping("/web")
public class OrderController {

    private static final String PAYMENT_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/save/payment")
    public CommonResult<Payment> savePayment(@RequestBody Payment payment) {
        return this.restTemplate.postForObject(PAYMENT_URL + "/admin/save/payment", payment, CommonResult.class);
    }

    @GetMapping("/consumer/get/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return this.restTemplate.getForObject(PAYMENT_URL + "/admin/get/payment/" + id, CommonResult.class);
    }
}
