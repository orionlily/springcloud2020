package com.orion.cloud.stream.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 * @date 2020/10/11
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain8801.class,args);
    }
}
