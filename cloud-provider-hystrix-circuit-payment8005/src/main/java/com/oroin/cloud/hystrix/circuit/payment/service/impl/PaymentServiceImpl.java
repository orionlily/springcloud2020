package com.oroin.cloud.hystrix.circuit.payment.service.impl;

import com.orion.cloud.entities.Payment;
import com.oroin.cloud.hystrix.circuit.payment.dao.PaymentDao;
import com.oroin.cloud.hystrix.circuit.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2020/9/18
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
