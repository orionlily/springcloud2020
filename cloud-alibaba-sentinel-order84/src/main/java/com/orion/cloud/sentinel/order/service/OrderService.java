package com.orion.cloud.sentinel.order.service;

import com.orion.cloud.entities.CommonResult;
import com.orion.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "alibaba-sentinel-payment",fallback = OrderServiceFallback.class)
public interface OrderService {

    @GetMapping("/paymentSQL/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id);
}
