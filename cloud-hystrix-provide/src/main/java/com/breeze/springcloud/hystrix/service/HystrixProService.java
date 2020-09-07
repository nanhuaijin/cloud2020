package com.breeze.springcloud.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author breeze
 * @date 2020/5/18
 */
@Service
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
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
     * 服务的降级：出错返回兜底数据
     *
     * HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
     * 意思是：当前方法设置正常等待的时间是3秒，超过3秒都是异常返回
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeOut(Integer id) {
        int time = 5;
        int i = time / 0;
        try { TimeUnit.SECONDS.sleep(time); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池：" + Thread.currentThread().getName() + " - paymentInfoTimeOut, id: " + id + "\tO(∩_∩)O哈哈~  耗时"
                + time + "秒";
    }

    /**
     * 参数名和返回值需要和原方法保持一致
     * 超时异常 + 运行异常都会走这个方法
     * @param id
     * @return
     */
    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfoTimeOutHandler - 连接超时o(╥﹏╥)o：" + id;
    }

    /**
     * 全局统一的fallback方法
     * @return
     */
    public String paymentGlobalFallbackMethod() {
        return "Global异常处理信息，请稍后再试！";
    }

    /**
     * 测试全局异常兜底的方法
     * @return
     */
    @HystrixCommand
    public String paymentInfoTimeOut() {
        int i = 1 / 0;
        return "测试全局异常兜底";
    }
}
