package com.orion.cloud.order.hystrix.feign.controller;

import com.orion.cloud.entities.CommonResult;
import com.orion.cloud.entities.Payment;
import com.orion.cloud.order.hystrix.feign.service.HystrixFeignOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2020/9/21
 */
@RestController
@Slf4j
public class HystrixFeignOrderController {

    @Resource
    private HystrixFeignOrderService feignOrderService;

    @PostMapping("/hystrix/feignorder/payment/create")
    public CommonResult<Integer> createPayment(Payment payment){
        return feignOrderService.createPayment(payment);
    }

    @GetMapping("/hystrix/feignorder/payment/{id}")
    public CommonResult<Payment> getPaymentByPId(@PathVariable("id") Long id){
        //int i=1/0;
        return feignOrderService.getPaymentByPId(id);
    }

    @GetMapping("/hystrix/feignorder/timeout")
    public CommonResult<String> feignTimeout(){
        return feignOrderService.feignTimeout();
    }

    @GetMapping("/hystrix/feignorder/haha")
    public CommonResult haha(Long id){
        return new CommonResult<>(200,"hahha","xixi"+id);
    }
}
