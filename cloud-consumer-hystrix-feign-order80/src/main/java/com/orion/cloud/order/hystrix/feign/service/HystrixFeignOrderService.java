package com.orion.cloud.order.hystrix.feign.service;

import com.orion.cloud.entities.CommonResult;
import com.orion.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * fallback和fallbackFactory只能指定一个，如果2个都指定了，生效的是fallback
 *
 * fallbackFactory可以查看到调用的异常信息，而fallback不可以，只是直接返回
 *
 * @author Administrator
 * @date 2020/9/21
 */
@Service
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE"
        ,fallback = com.orion.cloud.order.hystrix.feign.service.fallback.HystrixFeignOrderServiceFallbackImpl.class)
public interface HystrixFeignOrderService {

    @PostMapping("/hystrix/payment/create")
    CommonResult createPayment(Payment payment);

    @GetMapping("/hystrix/payment/get/{id}")
    CommonResult getPaymentByPId(@PathVariable("id") Long id);

    @GetMapping("/hystrix/payment/timeout")
    CommonResult feignTimeout();
}
