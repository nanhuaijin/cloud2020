package com.breeze.springcloud.payment.controller;

import com.breeze.springcloud.common.CommonResult;
import com.breeze.springcloud.entities.Payment;
import com.breeze.springcloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author breeze
 * @date 2020/3/15
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/save/payment")
    public CommonResult savePayment(@RequestBody Payment payment) {
        int result = this.paymentService.savePayment(payment);
        log.info("插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "保存订单信息成功", result);
        } else {
            return new CommonResult(201, "保存订单信息失败", null);
        }
    }


    @GetMapping("get/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = this.paymentService.getPaymentById(id);
        log.info("查询订单成功 \t" + payment + "O(∩_∩)O哈哈~");
        if (payment != null) {
            return new CommonResult(200, "查询订单成功", payment);
        } else {
            return new CommonResult(201, "查询订单失败", null);
        }
    }
}
