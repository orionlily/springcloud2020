package com.orion.cloud.alibaba.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2020/10/21
 */
@Slf4j
@RestController
public class ServiceController {

    @GetMapping("/serviceA")
    public String serviceA() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return "this is serviceA";
    }

    @GetMapping("/serviceB")
    public String serviceB(){
        log.info(Thread.currentThread().getName()+ "--i am B");
        return "this is serviceB";
    }

    @GetMapping("/serviceC")
    public String serviceC(){
       int i= 10/0;
        log.info(Thread.currentThread().getName()+ "--i am C");
        return "this is serviceC";
    }

    @GetMapping("/hotkey")
    @SentinelResource(value = "hotkey",blockHandler = "bhhotkey")
    public String hotkey(String a,String b){
        log.info(Thread.currentThread().getName()+ "--hotkey--"+a+"---"+b);
        return Thread.currentThread().getName()+ "--hotkey--"+a+"---"+b;
    }

    public String bhhotkey(String a, String b, BlockException blockException){
        log.info(Thread.currentThread().getName()+ "--hotkey--"+a+"---"+b);
        return "┭┮﹏┭┮"+Thread.currentThread().getName()+ "--hotkey--"+a+"---"+b+"--"+blockException.getMessage();
    }
}
