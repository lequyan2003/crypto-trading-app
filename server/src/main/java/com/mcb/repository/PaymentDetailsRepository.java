package com.mcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcb.modal.PaymentDetails;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Long> {
    PaymentDetails findByUserId(Long userId);
}
