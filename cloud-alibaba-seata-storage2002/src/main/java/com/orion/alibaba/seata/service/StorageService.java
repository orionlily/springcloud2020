package com.orion.alibaba.seata.service;


public interface StorageService {
    //扣减库存信息
    void decrease(Long productId, Integer count);
}
