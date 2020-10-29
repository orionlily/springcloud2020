package com.orion.cloud.alibaba.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.orion.cloud.entities.CommonResult;

/**
 * @author li.lc
 */
public class CustomerBlockHandler {

    public static CommonResult customerHandler(BlockException be){
        return new CommonResult(501,"自定义CustomerBlockHandler："+be.getClass().getCanonicalName()
                +"--"+be.getLocalizedMessage());
    }

    public static CommonResult customerHandler2(String url,BlockException be){
        return new CommonResult(502,"自定义CustomerBlockHandler2："+be.getClass().getCanonicalName()
                +"--"+be.getLocalizedMessage()+"--"+url);
    }
}
