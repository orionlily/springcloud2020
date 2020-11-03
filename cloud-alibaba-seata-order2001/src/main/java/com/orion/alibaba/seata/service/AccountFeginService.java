package com.orion.alibaba.seata.service;

import com.orion.cloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @date 2020/11/1
 */
@FeignClient(value = "cloud-seata-account",fallback = AccountFeignFallbackImpl.class)
public interface AccountFeginService {

    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
