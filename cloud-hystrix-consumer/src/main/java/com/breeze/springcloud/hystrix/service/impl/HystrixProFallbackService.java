package com.breeze.springcloud.hystrix.service.impl;

import com.breeze.springcloud.hystrix.service.HystrixProService;
import org.springframework.stereotype.Component;

/**
 * @author : breeze
 * @date : 2020/9/7
 * @description : 远程调用pro接口降级接口
 */
@Component
public class HystrixProFallbackService implements HystrixProService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "HystrixProFallbackService.paymentInfoOk-----服务宕机保护接口";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "HystrixProFallbackService.paymentInfoTimeOut---服务宕机保护接口";
    }
}
