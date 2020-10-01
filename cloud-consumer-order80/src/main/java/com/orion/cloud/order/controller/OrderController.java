package com.orion.cloud.order.controller;

import com.orion.cloud.entities.CommonResult;
import com.orion.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @date 2020/9/19
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @PostMapping("/order/payment/create")
    public CommonResult<Payment> create(Payment payment){
        CommonResult commonResult = restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
        return commonResult;
    }

    @GetMapping("/order/payment/{id}")
    public CommonResult<Payment> getPaymentByPId(@PathVariable("id") Long id){
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        return commonResult;
    }
}
