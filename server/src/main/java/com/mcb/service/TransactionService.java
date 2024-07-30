package com.mcb.service;

import java.util.List;

import com.mcb.domain.WalletTransactionType;
import com.mcb.modal.Wallet;
import com.mcb.modal.WalletTransaction;

public interface TransactionService {
    WalletTransaction createTransaction(Wallet wallet, WalletTransactionType type, Long amount, String transferId, String purpose);

    List<WalletTransaction> getTransactionByWallet(Wallet wallet);
}
