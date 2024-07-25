package com.mcb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcb.modal.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
