package com.orion.alibaba.seata.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * https://github.com/seata/seata-samples/blob/master/springcloud-nacos-seata/base-framework-mysql-support/src/main/java/com/work/framework/config/MyBatisConfig.java
 *
 * https://blog.csdn.net/d_vean/article/details/103852340
 * https://www.cnblogs.com/dalianpai/p/13443750.html
 *
 * @author li.lc 整个类可以不配
 */
@Configuration
@MapperScan("com.orion.alibaba.seata.dao")
public class MybatisConfig {
    /**
     * MP 自带分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}
