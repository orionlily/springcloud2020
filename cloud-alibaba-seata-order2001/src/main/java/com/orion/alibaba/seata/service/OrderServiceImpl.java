package com.orion.alibaba.seata.service;

import com.orion.alibaba.seata.dao.OrderDao;
import com.orion.alibaba.seata.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author li.lc
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService{

    @Resource
    private OrderDao orderDao;

    @Override
    public void create(Order order) {

    }
}
