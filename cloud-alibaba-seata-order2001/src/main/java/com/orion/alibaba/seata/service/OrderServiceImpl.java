package com.orion.alibaba.seata.service;

import com.orion.alibaba.seata.dao.OrderDao;
import com.orion.alibaba.seata.entity.Order;
import io.seata.spring.annotation.GlobalTransactional;
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

    @Resource
    private AccountFeginService accountFeginService;

    @Resource
    private StorageFeignService storageFeignService;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("----->创建订单开始");
        orderDao.create(order);
        log.info("----->创建订单结束");

        log.info("----->扣减库存开始");
        storageFeignService.decrease(order.getProductId(),order.getCount());
        log.info("----->扣减库存结束");

        log.info("----->扣减账户开始");
        accountFeginService.decrease(order.getUserId(),order.getMoney());
        log.info("----->扣减账户结束");

        //修改订单状态，从零到1代表已经完成
        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了");
    }
}
