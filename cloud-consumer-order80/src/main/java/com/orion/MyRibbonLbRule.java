package com.orion;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义ribbon负载均衡规则
 *
 * @author Administrator
 * @date 2020/9/20
 */
@Configuration
public class MyRibbonLbRule {

    @Bean
    public IRule myLbRule(){
        return new RandomRule();
    }
}
