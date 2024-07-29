package com.mcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcb.modal.PaymentOrder;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrder, Long> {
    
}
