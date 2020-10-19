package com.orion.alibaba.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2020/10/17
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping(value = "/payment/port")
    public String getPort(){
      return "get port:"+port;
    }
}
