package com.mcb.service;

import com.mcb.domain.VerificationType;
import com.mcb.modal.User;
import com.mcb.modal.VerificationCode;

public interface VerificationCodeService {
    VerificationCode sendVerificationCode(
        User user,
        VerificationType verificationType
    );

    VerificationCode getVerificationCodeById(Long id) throws Exception;

    VerificationCode getVerificationCodeByUser(Long userId);

    void deleteVerificationCodeById(VerificationCode verificationCode);
}
