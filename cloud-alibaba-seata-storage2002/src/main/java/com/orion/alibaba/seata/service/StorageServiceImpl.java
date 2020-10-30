package com.orion.alibaba.seata.service;

import com.orion.alibaba.seata.dao.StorageDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author li.lc
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService{

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("---开始扣库存---");
        storageDao.decrease(productId, count);
        log.info("---结束扣库存---");
    }
}
