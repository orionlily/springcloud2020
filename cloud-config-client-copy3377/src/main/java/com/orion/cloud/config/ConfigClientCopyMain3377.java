package com.orion.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author li.lc
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ConfigClientCopyMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientCopyMain3377.class,args);
    }

    @GetMapping("/foobar")
    public String getFoobar(@Value("${self.foobar}") String foobar){
        return foobar;
    }
}
