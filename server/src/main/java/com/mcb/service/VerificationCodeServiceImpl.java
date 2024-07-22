package com.mcb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcb.domain.VerificationType;
import com.mcb.modal.User;
import com.mcb.modal.VerificationCode;
import com.mcb.repository.VerificationCodeRepository;
import com.mcb.utils.OtpUtils;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
    @Autowired
    private VerificationCodeRepository verificationCodeRepository;

    @Override
    public VerificationCode sendVerificationCode(
        User user,
        VerificationType verificationType
    ) {
        VerificationCode verificationCode1 = new VerificationCode();
        verificationCode1.setOtp(OtpUtils.generateOTP());
        verificationCode1.setVerificationType(verificationType);
        verificationCode1.setUser(user);

        return verificationCodeRepository.save(verificationCode1);
    }

    @Override
    public VerificationCode getVerificationCodeById(Long id) throws Exception {
        Optional<VerificationCode> verificationCode =
            verificationCodeRepository.findById(id);
        
        if(verificationCode.isPresent()) {
            return verificationCode.get();
        }
        throw new Exception("verification code not found");
    }

    @Override
    public VerificationCode getVerificationCodeByUser(Long userId) {
        return verificationCodeRepository.findByUserId(userId);
    }

    @Override
    public void deleteVerificationCodeById(VerificationCode verificationCode) {
        verificationCodeRepository.delete(verificationCode);
    }

}
