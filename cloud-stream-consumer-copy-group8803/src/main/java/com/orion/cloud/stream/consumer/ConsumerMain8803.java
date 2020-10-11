package com.orion.cloud.stream.consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 * @date 2020/10/11
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain8803.class,args);
    }
}
