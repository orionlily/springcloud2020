package com.orion.alibaba.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Administrator
 * @date 2020/10/17
 */
@Service
@FeignClient("cloud-alibaba-payment")
public interface FeignConsumerService {

    @GetMapping("/payment/port")
    String getPort();
}
