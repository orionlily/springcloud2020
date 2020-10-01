package com.orion.cloud.hystrix.payment.controller;


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
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private Integer port;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if (result > 0){  //成功
            return new CommonResult<>(200,"插入数据库成功",port);
        }else {
            return new CommonResult<>(444,"插入数据库失败",port);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentByPId(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果hafa："+payment);
        if (payment!=null){  //说明有数据，能查询成功
            return new CommonResult<>(200,"查询成功"+port,payment);
        }else {
            return new CommonResult<>(444,"没有对应记录，查询ID："+id);
        }
    }

    @GetMapping("/payment/discovery")
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

    @GetMapping("/payment/timeout")
    public CommonResult<String> timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult<String>(200,"成功","timeout");
    }
}
