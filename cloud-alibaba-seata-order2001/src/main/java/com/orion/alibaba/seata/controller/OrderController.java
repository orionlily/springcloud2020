package com.orion.alibaba.seata.controller;

import com.orion.alibaba.seata.entity.Order;
import com.orion.alibaba.seata.service.OrderService;
import com.orion.cloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author li.lc
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/test")
    public CommonResult test(){
        return new CommonResult<>(200,"test order");
    }

    /**
     * http://127.0.0.1:2001/order/create?userId=1&productId=1&count=10&money=100
     * @param order
     * @return
     */
    @GetMapping("/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
