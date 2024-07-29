package com.mcb.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mcb.modal.PaymentDetails;
import com.mcb.modal.User;
import com.mcb.repository.PaymentDetailsRepository;

public class PaymentDetailsServiceImpl implements PaymentDetailsService {
    @Autowired
    private PaymentDetailsRepository paymentDetailsRepository;

    @Override
    public PaymentDetails addPaymentDetails(
        String accountNumber,
        String accountHolderName,
        String ifsc,
        String bankName,
        User user
    ) {
        PaymentDetails paymentDetails = new PaymentDetails();

        paymentDetails.setAccountNumber(accountNumber);
        paymentDetails.setAccountHolderName(accountHolderName);
        paymentDetails.setIfsc(ifsc);
        paymentDetails.setBankName(bankName);
        paymentDetails.setUser(user);

        return paymentDetailsRepository.save(paymentDetails);
    }

    @Override
    public PaymentDetails getUserPaymentDetails(User user) {
        return paymentDetailsRepository.findByUserId(user.getId());
    }

}
