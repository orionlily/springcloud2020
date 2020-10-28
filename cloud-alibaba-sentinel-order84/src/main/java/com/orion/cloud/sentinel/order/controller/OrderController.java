package com.orion.cloud.sentinel.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.orion.cloud.entities.CommonResult;
import com.orion.cloud.entities.Payment;
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

    @GetMapping("/order/payment/fallback")
    @SentinelResource(value = "orderFallback",blockHandler = "orderBlockHandler")
    public CommonResult getPaymentByIdFallback(Integer id){
        /*if (id==4){
            throw new IllegalArgumentException("非法参数id="+id);
        }*/
        CommonResult<Payment> result = orderService.getPaymentById(id);
        Payment payment = result.getData();
       /* if (payment==null) {
            throw new NullPointerException("空指针异常，没有找到id="+id+"的payment");
        }*/
        return result;
    }

    public CommonResult orderBlockHandler(Integer id, BlockException be) {
        return new CommonResult(600,"服务降级：id="+id+"--casue:"+be.getClass().getCanonicalName()
                +"--"+be.getCause());
    }
}
