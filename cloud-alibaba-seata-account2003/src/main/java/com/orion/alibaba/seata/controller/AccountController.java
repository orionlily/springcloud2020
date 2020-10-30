package com.orion.alibaba.seata.controller;

/**
 * @author li.lc
 */

import com.orion.alibaba.seata.service.AccountService;
import com.orion.cloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping("/test")
    public CommonResult test(){
        return new CommonResult<>(200,"test account");
    }

    @PostMapping("/decrease")
    public CommonResult decrease(Long userId, BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult(200,"扣减库存成功！");
    }
}
