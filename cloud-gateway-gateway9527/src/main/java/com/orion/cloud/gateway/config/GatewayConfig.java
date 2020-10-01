package com.orion.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import java.util.Objects;

/**
 * 配置路由规则
 *
 * @author Administrator
 * @date 2020/9/27
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("toBd",route -> route.path("/hystrix/feignorder/haha")
                .and().predicate(item -> Objects.equals(item.getRequest().getMethod(), HttpMethod.GET)).uri("http://127.0.0.1")).build();
        return routes.build();
    }
}
