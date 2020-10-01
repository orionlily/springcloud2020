package com.orion.cloud.order.hystrix.feign.service.fallback;

import com.orion.cloud.entities.CommonResult;
import com.orion.cloud.entities.Payment;
import com.orion.cloud.order.hystrix.feign.service.HystrixFeignOrderService;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2020/9/23
 */
@Component
public class HystrixFeignOrderServiceFallbackImpl implements HystrixFeignOrderService {
    @Override
    public CommonResult createPayment(Payment payment) {
        return new CommonResult(666,"createPayment order fallback");
    }

    @Override
    public CommonResult getPaymentByPId(Long id) {
        return new CommonResult(666,"getPaymentByPId order fallback");
    }

    @Override
    public CommonResult feignTimeout() {
        System.out.println("feignTimeout order fallback");
        return new CommonResult(666,"feignTimeout order fallback");
    }
}
