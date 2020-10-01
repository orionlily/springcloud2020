package com.orion.cloud.hystrix.payment.dao;


import com.orion.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 * @date 2020/9/18
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(Long id);

}
