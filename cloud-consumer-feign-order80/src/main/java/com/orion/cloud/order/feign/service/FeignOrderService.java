package com.orion.cloud.order.feign.service;

import com.orion.cloud.entities.CommonResult;
import com.orion.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Administrator
 * @date 2020/9/21
 */
@Service
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface FeignOrderService {

    @PostMapping("/payment/create")
    CommonResult<Integer> createPayment(Payment payment);

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentByPId(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    CommonResult<String> feignTimeout();
}
