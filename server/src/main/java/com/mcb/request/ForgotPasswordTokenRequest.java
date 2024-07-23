package com.mcb.request;

import com.mcb.domain.VerificationType;

import lombok.Data;

@Data
public class ForgotPasswordTokenRequest {
    private String sendTo;
    private VerificationType verificationType;
}
