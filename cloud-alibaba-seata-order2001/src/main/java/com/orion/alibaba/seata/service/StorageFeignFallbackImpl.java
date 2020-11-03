package com.orion.alibaba.seata.service;

import com.orion.cloud.entities.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @author li.lc
 */
@Component
public class StorageFeignFallbackImpl implements StorageFeignService {
    @Override
    public CommonResult decrease(Long productId, Integer count) {
        return new CommonResult(400,"调用库存服务降级");
    }
}
