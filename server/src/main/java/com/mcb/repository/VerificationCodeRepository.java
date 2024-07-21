package com.mcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcb.modal.VerificationCode;

public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Long> {
    public VerificationCode findByUserId(Long userId);
}
