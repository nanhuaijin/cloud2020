package com.breeze.springcloud.payment.mapper;

import com.breeze.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author breeze
 * @date 2020/3/15
 */
@Mapper
public interface PaymentMapper {

    int savePayment(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
