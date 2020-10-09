package com.orion.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 * @date 2020/10/9
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerMain3355.class, args);
    }
}
