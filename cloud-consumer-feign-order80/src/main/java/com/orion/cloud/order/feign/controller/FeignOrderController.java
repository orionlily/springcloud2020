package com.orion.cloud.order.feign.controller;

import com.orion.cloud.entities.CommonResult;
import com.orion.cloud.entities.Payment;
import com.orion.cloud.order.feign.service.FeignOrderService;
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
public class FeignOrderController {

    @Resource
    private FeignOrderService feignOrderService;

    @PostMapping("/feignorder/payment/create")
    public CommonResult<Integer> createPayment(Payment payment){
        return feignOrderService.createPayment(payment);
    }

    @GetMapping("/feignorder/payment/{id}")
    public CommonResult<Payment> getPaymentByPId(@PathVariable("id") Long id){
        return feignOrderService.getPaymentByPId(id);
    }

    @GetMapping("/feignorder/timeout")
    public CommonResult<String> feignTimeout(){
        System.out.println("fe");
        return feignOrderService.feignTimeout();
    }
}
