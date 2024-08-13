package com.mcb.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.modal.Order;
import com.mcb.modal.PaymentOrder;
import com.mcb.modal.User;
import com.mcb.modal.Wallet;
import com.mcb.modal.WalletTransaction;
import com.mcb.service.OrderService;
import com.mcb.service.PaymentService;
import com.mcb.service.UserService;
import com.mcb.service.WalletService;

@RestController
public class WalletController {
    @Autowired
    private WalletService walletService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/api/wallet")
    public ResponseEntity<Wallet> getUserWallet(
            @RequestHeader("Authorization") String jwt) {
        User user = userService.findUserProfileByJwt(jwt);

        Wallet wallet = walletService.getUserWallet(user);

        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/wallet/{walletId}/transfer")
    public ResponseEntity<Wallet> walletToWalletTransfer(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long walletId,
            @RequestBody WalletTransaction req) throws Exception {
        User senderUser = userService.findUserProfileByJwt(jwt);
        Wallet receiverWallet = walletService.findWalletById(walletId);
        Wallet wallet = walletService.walletToWalletTransfer(
                senderUser,
                receiverWallet,
                req.getAmount());

        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/wallet/order/{orderId}/pay")
    public ResponseEntity<Wallet> payOrderPayment(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long orderId) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);

        Order order = orderService.getOrderById(orderId);

        Wallet wallet = walletService.payOrderPayment(order, user);

        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }

    // orderId for RAZORPAY
    @PutMapping("/api/wallet/deposit")
    public ResponseEntity<Wallet> addBalanceToWallet(
            @RequestHeader("Authorization") String jwt,
            // @RequestParam(name = "payment_id") String paymentId,
            @RequestParam(name = "order_id") Long orderId) throws Exception {
        // System.out.println("Received deposit request with order_id: " + orderId + "
        // and payment_id: " + paymentId);

        User user = userService.findUserProfileByJwt(jwt);

        Wallet wallet = walletService.getUserWallet(user);

        PaymentOrder order = paymentService.getPaymentOrderById(orderId);

        // Boolean status = paymentService.proceedPaymentOrder(order, paymentId);

        if (wallet.getBalance() == null) {
            wallet.setBalance(BigDecimal.valueOf(0));
        }

        // if (status) {
        if (orderId != null) {
            wallet = walletService.addBalance(wallet, order.getAmount());
        }

        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);
    }
}
