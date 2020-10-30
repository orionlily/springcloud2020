package com.orion.alibaba.seata.dao;

import com.orion.alibaba.seata.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {

    /**
     * 新建订单
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态，从零改为1
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
