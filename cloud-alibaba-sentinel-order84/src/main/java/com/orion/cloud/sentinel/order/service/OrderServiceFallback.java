package com.orion.cloud.sentinel.order.service;

import com.orion.cloud.entities.CommonResult;
import com.orion.cloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author li.lc
 */
@Component
public class OrderServiceFallback implements OrderService {
    @Override
    public CommonResult<Payment> getPaymentById(Integer id) {
        return new CommonResult<>(500,"远程调用getPaymentById失败，进入fallback");
    }
}
