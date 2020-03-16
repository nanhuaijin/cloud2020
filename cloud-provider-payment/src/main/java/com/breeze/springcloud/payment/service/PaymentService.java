package com.breeze.springcloud.payment.service;

import com.breeze.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author breeze
 * @date 2020/3/15
 */
public interface PaymentService {

    int savePayment(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
