package com.orion.alibaba.seata.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * https://github.com/seata/seata-samples/blob/master/springcloud-nacos-seata/base-framework-mysql-support/src/main/java/com/work/framework/config/MyBatisConfig.java
 * <p>
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
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }
}
