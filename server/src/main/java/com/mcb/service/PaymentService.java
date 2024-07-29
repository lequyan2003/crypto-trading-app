package com.mcb.service;

import com.mcb.domain.PaymentMethod;
import com.mcb.modal.PaymentOrder;
import com.mcb.modal.User;
import com.mcb.response.PaymentResponse;
import com.razorpay.RazorpayException;

public interface PaymentService {
    PaymentOrder createOrder(User user, Long amount, PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    Boolean proceedPaymentOrder(PaymentOrder paymentOrder, String paymentId) throws RazorpayException;

    PaymentResponse createRazorpayPaymentLink(User user, Long amount) throws RazorpayException;

    PaymentResponse createStripePaymentLink(User user, Long amount, Long orderId);
}
