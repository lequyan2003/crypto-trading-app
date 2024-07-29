package com.mcb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.modal.PaymentDetails;
import com.mcb.modal.User;
import com.mcb.service.PaymentDetailsService;
import com.mcb.service.UserService;


@RestController
@RequestMapping("/api")
public class PaymentDetailsController {
    @Autowired
    private UserService userService;

    @Autowired
    private PaymentDetailsService paymentDetailsService;

    @PostMapping("/payment-details")
    public ResponseEntity<PaymentDetails> addPaymentDetails(
        @RequestBody PaymentDetails paymentDetailsRequest,
        @RequestHeader("Authorization") String jwt
    ) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);

        PaymentDetails paymentDetails = paymentDetailsService.addPaymentDetails(
            paymentDetailsRequest.getAccountNumber(),
            paymentDetailsRequest.getAccountHolderName(),
            paymentDetailsRequest.getIfsc(),
            paymentDetailsRequest.getBankName(),
            user
        );

        return new ResponseEntity<>(paymentDetails, HttpStatus.CREATED);
    }

    public ResponseEntity<PaymentDetails> getUserPaymentDetails(
        @RequestHeader("Authorization") String jwt
    ) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);

        PaymentDetails paymentDetails = paymentDetailsService
            .getUserPaymentDetails(user);

        return new ResponseEntity<>(paymentDetails, HttpStatus.CREATED);
    }
}