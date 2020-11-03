package com.orion.alibaba.seata.service;

import com.orion.cloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Administrator
 * @date 2020/11/1
 */
@FeignClient(value = "cloud-seata-storage",fallback = StorageFeignFallbackImpl.class)
public interface StorageFeignService {

    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
