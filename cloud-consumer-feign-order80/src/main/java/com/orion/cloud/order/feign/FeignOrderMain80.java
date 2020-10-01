package com.orion.cloud.order.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Administrator
 * @date 2020/9/21
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(FeignOrderMain80.class, args);
    }
}
