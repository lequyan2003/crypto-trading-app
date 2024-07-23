package com.mcb.service;

import com.mcb.domain.VerificationType;
import com.mcb.modal.ForgotPasswordToken;
import com.mcb.modal.User;

public interface ForgotPasswordService {
    ForgotPasswordToken createToken(
        User user,
        String id,
        String otp,
        VerificationType verificationType,
        String sendTo
    );

    ForgotPasswordToken findById(String id);

    ForgotPasswordToken findByUser(Long userId);

    void deleteToken(ForgotPasswordToken token);
}
