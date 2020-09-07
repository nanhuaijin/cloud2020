package com.breeze.springcloud.hystrix.service;

import com.breeze.springcloud.hystrix.service.impl.HystrixProFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author breeze
 * @date 2020-05-20
 */
@Component
@FeignClient(value = "CLOUD-HYSTRIX-PRO-SERVICE", fallback = HystrixProFallbackService.class)
public interface HystrixProService {

    @GetMapping("/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/time/out/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id);
}
