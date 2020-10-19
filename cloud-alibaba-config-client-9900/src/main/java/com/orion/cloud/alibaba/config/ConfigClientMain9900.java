package com.orion.cloud.alibaba.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2020/10/18
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientMain9900 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain9900.class,args);
    }

    @Value("${server.port}")
    private Integer port;

    @Value("${foobar}")
    private String foobar;

    @GetMapping("/foobarAndPort")
    public String getFoobarAndPort(){
        return "port:"+port+"--foobar："+foobar;
    }

    @GetMapping("/port")
    public String getPort(){
        return "port:"+port;
    }
}
