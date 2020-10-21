package com.orion.cloud.alibaba.sentinel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2020/10/21
 */
@Slf4j
@RestController
public class ServiceController {

    @GetMapping("/serviceA")
    public String serviceA(){
        return "this is serviceA";
    }

    @GetMapping("/serviceB")
    public String serviceB(){
        log.info(Thread.currentThread().getName()+ "--i am B");
        return "this is serviceB";
    }
}
