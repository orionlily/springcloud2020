package com.orion.cloud.alibaba.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.orion.cloud.alibaba.sentinel.handler.CustomerBlockHandler;
import com.orion.cloud.entities.CommonResult;
import com.orion.cloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author li.lc
 */
@RestController
public class RateLimitController {

    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource",blockHandler = "getByResourceBlockHandler")
    public CommonResult getByResource(){
        return new CommonResult(200,"成功",new Payment(1L,"abcdefg"));
    }

    public CommonResult getByResourceBlockHandler(BlockException be){
        return new CommonResult(500,"失败："+be.getClass().getCanonicalName()+"\t 服务不可用");
    }

    @GetMapping(value = "/byUrl")
    //外置blockHandler也需要参数一致，并多附上一个BlockException
    //@SentinelResource(value = "byUrl",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "customerHandler")
    @SentinelResource(value = "byUrl",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "customerHandler2")
    public CommonResult getByUrl(String url){
        return new CommonResult(200,"成功url",new Payment(2L,"hijklmn-"+url));
    }
}
