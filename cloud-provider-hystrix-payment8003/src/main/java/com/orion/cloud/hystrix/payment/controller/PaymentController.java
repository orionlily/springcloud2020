package com.orion.cloud.hystrix.payment.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.orion.cloud.entities.CommonResult;
import com.orion.cloud.entities.Payment;
import com.orion.cloud.hystrix.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2020/9/18
 */
@Slf4j
@RestController
@DefaultProperties(defaultFallback = "globalFallback")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private Integer port;

    @PostMapping(value = "/hystrix/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if (result > 0){  //成功
            return new CommonResult<>(200,"插入数据库成功",port);
        }else {
            return new CommonResult<>(444,"插入数据库失败",port);
        }
    }

    @GetMapping(value = "/hystrix/payment/get/{id}")
    @HystrixCommand(fallbackMethod = "getPaymentByIdFallBack",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public CommonResult getPaymentByPId(@PathVariable("id") Long id){
        //int a = 1/0;
        /*
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        log.info("调用支付接口成功:"+Thread.currentThread().getName()+":O(∩_∩)O哈哈~"+"--"+id);
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果hafa："+payment);
        if (payment!=null){  //说明有数据，能查询成功
            return new CommonResult<>(200,"查询成功"+port,payment);
        }else {
            return new CommonResult<>(444,"没有对应记录，查询ID："+id);
        }
    }

    /**
     * fallback方法
     * @param id
     * @return
     */
    public CommonResult getPaymentByIdFallBack(Long id){
        log.info("调用支付接口失败或者超时:"+Thread.currentThread().getName()+":┮﹏┭"+"--"+id);
        return new CommonResult<>(555,"getPaymentByPId FallBack，查询ID："+id);
    }


    @GetMapping("/hystrix/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("mirco service : " + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance instance : instances) {
            System.out.println(instance);
        }

        return discoveryClient;
    }

    @GetMapping("/hystrix/payment/timeout")
    //@HystrixCommand //配合全局fallback @DefaultProperties(defaultFallback = "globalFallback")
    public CommonResult timeout(){
        //int a = 1/0;
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // set interrupt flag
            log.info("InterruptedException :"+port);
        }
        return new CommonResult<String>(200,"成功","timeout");
    }

    public CommonResult globalFallback(){
        log.info("全局fallback:"+Thread.currentThread().getName()+":┮﹏┭"+"--");
        return new CommonResult<>(666,"global FallBack");
    }
}
