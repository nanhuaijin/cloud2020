package com.breeze.springcloud.payment.service.impl;

import com.breeze.springcloud.entities.Payment;
import com.breeze.springcloud.payment.mapper.PaymentMapper;
import com.breeze.springcloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author breeze
 * @date 2020/3/15
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int savePayment(Payment payment) {
        return this.paymentMapper.savePayment(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        //暂停一会儿(秒)
        try {
            TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) {e.printStackTrace(); }
        return this.paymentMapper.getPaymentById(id);
    }
}
