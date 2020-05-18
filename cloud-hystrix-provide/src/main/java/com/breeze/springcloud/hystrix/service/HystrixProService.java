package com.breeze.springcloud.hystrix.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author breeze
 * @date 2020/5/18
 */
@Service
public class HystrixProService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfoOk(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " - paymentInfoOk, id: " + id + "\tO(∩_∩)O哈哈~";
    }

    /**
     *
     * @param id
     * @return
     */
    public String paymentInfoTimeOut(Integer id) {
        int time = 3;
        try { TimeUnit.SECONDS.sleep(time); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池：" + Thread.currentThread().getName() + " - paymentInfoTimeOut, id: " + id + "\tO(∩_∩)O哈哈~  耗时" + time + "秒";
    }

}
