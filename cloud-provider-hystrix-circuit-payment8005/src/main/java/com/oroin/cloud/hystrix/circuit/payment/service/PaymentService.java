package com.oroin.cloud.hystrix.circuit.payment.service;

import com.orion.cloud.entities.Payment;

/**
 * @author Administrator
 * @date 2020/9/18
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
