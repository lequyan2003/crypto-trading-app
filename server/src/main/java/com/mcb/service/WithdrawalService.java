package com.mcb.service;

import java.util.List;

import com.mcb.modal.User;
import com.mcb.modal.Withdrawal;

public interface WithdrawalService {
    Withdrawal requestWithdrawal(Long amount, User user);

    Withdrawal proceedWithWithdrawal(Long withdrawalId, boolean accept) throws Exception;

    List<Withdrawal> getUserWithdrawalHistory(User user);

    List<Withdrawal> getAllWithdrawalRequest();
}
