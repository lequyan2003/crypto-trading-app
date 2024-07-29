package com.mcb.service;

import com.mcb.modal.PaymentDetails;
import com.mcb.modal.User;

public interface PaymentDetailsService {
    public PaymentDetails addPaymentDetails(
        String accountNumber,
        String accountHolderName,
        String ifsc,
        String bankName,
        User user
    );

    public PaymentDetails getUserPaymentDetails(User user);
}
