package com.mcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcb.modal.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
