package com.orion.alibaba.seata.service;

import com.orion.alibaba.seata.dao.AccountDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author li.lc
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("----开始扣钱----");
        accountDao.decrease(userId, money);
        log.info("----结束扣钱----");
    }
}
