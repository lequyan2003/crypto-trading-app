package com.mcb.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcb.domain.WalletTransactionType;
import com.mcb.modal.Wallet;
import com.mcb.modal.WalletTransaction;
import com.mcb.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public WalletTransaction createTransaction(Wallet wallet, WalletTransactionType type, Long amount, String transferId, String purpose) {
        WalletTransaction transaction = new WalletTransaction();
        transaction.setWallet(wallet);
        transaction.setType(type);
        transaction.setAmount(amount);
        transaction.setTransferId(transferId);
        transaction.setPurpose(purpose);
        transaction.setDate(LocalDate.now());

        return transactionRepository.save(transaction);
    }

    @Override
    public List<WalletTransaction> getTransactionByWallet(Wallet wallet) {
        return transactionRepository.findByWallet(wallet);
    }
}
