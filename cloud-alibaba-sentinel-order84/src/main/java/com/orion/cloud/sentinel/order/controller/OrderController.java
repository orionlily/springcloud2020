package com.orion.cloud.sentinel.order.controller;

import com.orion.cloud.entities.CommonResult;
import com.orion.cloud.sentinel.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author li.lc
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/payment")
    public CommonResult getPaymentById(Integer id){
        return orderService.getPaymentById(id);
    }
}
