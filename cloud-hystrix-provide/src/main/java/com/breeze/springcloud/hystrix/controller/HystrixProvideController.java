package com.breeze.springcloud.hystrix.controller;

import com.breeze.springcloud.hystrix.service.HystrixProService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author breeze
 * @date 2020/5/18
 *
 * Hystrix是一个用于处理分布式系统的延迟和容错的开源库，在分布式系统里，许多依赖不可避免的会调用失败。
 * 比如超时、异常等，Hystrix能够保证在一个依赖出问题的情况下，不会导致整体服务失败，避免级联故障，以
 * 提高分布式系统的弹性。
 *
 * "断路器"本身是一种开关装置，当某个服务单元发生故障之后，通过断路器的故障监控（类似于熔断保险丝），
 * 向调用方返回一个符合预期的、可处理的备选响应（fallback），而不是长时间的等待或者抛出无法处理的异常
 * 这样就保证了服务调用方的线程不会被长时间、不必要地占用，从而避免了故障在分布式系统中的蔓延，乃至雪崩。
 *
 *      1.服务降级：服务器忙，请稍后再试，不让客户端等待并立即返回一个友好的提示，fallback
 *          1）：程序运行异常
 *          2）：超时
 *          3）：服务熔断触发服务降级
 *          4）：线程池/信号量打满也会导致服务降级
 *          5）：存在的问题：
 *              每个业务方法对应一个兜底的方法，代码膨胀
 *              和业务代码混淆在一起，比较混乱
 *      2.服务熔断：达到最大访问量后，直接拒绝访问，然后调用服务降级的方法并返回友好提示 - 保险丝
 *          1）：服务降级 -->  进而熔断 -->  恢复调用链路
 *          2）：熔断：是应对雪崩效应的一种微服务链路保护机制。当扇出链路的某个微服务出错不可用
 *                  或者响应时间太长时，会进行服务的降级，进而熔断该节点微服务的调用，快速返回
 *                  错误响应信息。当检测到该节点微服务调用的响应正常后，恢复调用链路
 *          3）：spring cloud框架中，熔断机制通过Hystrix实现。Hystrix会监控微服务间调用的
 *              状况，当失败的调用到一定的阈值，缺省是5秒内20次调用失败，就会启动熔断机制，熔断
 *              机制的注解是@HystrixCommand
 *          4）：熔断类型
 *              熔断打开：请求不再进行调用当前服务，内部设置时钟一般为MTTR(平均故障处理时间)，当打开市场达到所设时钟则进入半熔断状态
 *              熔断关闭：熔断关闭不会对服务进行熔断
 *              熔断半开：部分请求根据规则调用当前服务，如果请求成功且符合规则则任务昂前服务恢复正常，关闭熔断
 *          5）：涉及到断路器的三个重要参数：快照时间窗口、请求总数阈值、错误百分比阈值
 *              快照时间窗口：断路器确定是否打开需要统计一些请求和错误数据，而统计的时间范围就是快照时间窗口，默认10s
 *              请求总数阈值：在快照时间窗口内，必须满足请求总数阈值才有资格荣盾。默认为20，意味着10s内，如果
 *                          Hystrix命令的调用次数不足20次，即使所有的请求都超时或者其他原因失败，断路器都不会打开
 *              错误百分比阈值：当请求总数在快照时间窗口内超过了阈值，比如发生了30次调用，如果在30次调动中，有15次
 *                          发生了超时异常，也就是超过50%的错误百分比，在默认设定50%阈值情况下，这时候会将断路器打开
 *      3.服务限流：秒杀高并发等操作，严禁一窝蜂的过来拥挤，大家排队，一秒n个，排队进行
 *              后面高级篇讲解Alibaba的Sentinel再详细说明
 */
@RestController
@Slf4j
public class HystrixProvideController {

    @Autowired
    private HystrixProService hystrixProService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        return this.hystrixProService.paymentInfoOk(id);
    }

    @GetMapping("/hystrix/time/out/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        return this.hystrixProService.paymentInfoTimeOut(id);
    }

    @GetMapping("hystrix/global")
    public String paymentInfoTimeOut() {
        return this.hystrixProService.paymentInfoTimeOut();
    }


    //============服务熔断===================================
    @GetMapping("/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = this.hystrixProService.paymentCircuitBreaker(id);
        log.info("result + {}", result);
        return result;
    }
}
