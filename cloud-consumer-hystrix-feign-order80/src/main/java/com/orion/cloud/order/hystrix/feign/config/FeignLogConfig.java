package com.orion.cloud.order.hystrix.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign日志增强
 * @author Administrator
 * @date 2020/9/21
 */
@Configuration
public class FeignLogConfig {

    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }
}
