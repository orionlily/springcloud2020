package com.orion.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;

/**
 * @author Administrator
 * @date 2020/10/9
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ConfigClientMain3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3366.class,args);
    }

    @GetMapping("/foobar")
    public String getFoobar(@Value("${self.foobar}") String foobar){
        return foobar;
    }
}
