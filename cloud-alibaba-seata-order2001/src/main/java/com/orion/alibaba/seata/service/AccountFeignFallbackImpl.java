package com.orion.alibaba.seata.service;

import com.orion.cloud.entities.CommonResult;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.math.BigDecimal;

/**
 * @author li.lc
 */

@Component
public class AccountFeignFallbackImpl implements AccountFeginService {

    @Setter
    private Throwable throwable;

    @Override
    public CommonResult decrease(Long userId, BigDecimal money) {
        if (!StringUtils.isBlank(RootContext.getXID())) {
            try {
                GlobalTransactionContext.reload(RootContext.getXID()).rollback();
            } catch (TransactionException e) {
                return  new CommonResult(400,"调用账户服务降级");
            }
        }
        return  new CommonResult(400,"调用账户服务降级");
    }
}
