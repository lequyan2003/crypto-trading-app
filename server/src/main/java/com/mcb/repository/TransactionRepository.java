package com.mcb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcb.modal.Wallet;
import com.mcb.modal.WalletTransaction;

public interface TransactionRepository extends JpaRepository<WalletTransaction, Long> {
    List<WalletTransaction> findByWallet(Wallet wallet);
}
