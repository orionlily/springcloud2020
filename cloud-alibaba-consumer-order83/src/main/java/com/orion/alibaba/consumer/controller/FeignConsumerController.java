package com.orion.alibaba.consumer.controller;

import com.orion.alibaba.consumer.service.FeignConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2020/10/17
 */
@RestController
public class FeignConsumerController {

    @Resource
    private FeignConsumerService feignConsumerService;

    @GetMapping(value = "/order/payment/port")
    public String getPort(){
       return feignConsumerService.getPort();
    }
}
