package com.orion.cloud.hystrix.payment.service;

import com.orion.cloud.entities.Payment;

/**
 * @author Administrator
 * @date 2020/9/18
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
