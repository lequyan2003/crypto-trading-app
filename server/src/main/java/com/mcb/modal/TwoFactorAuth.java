package com.mcb.modal;

import com.mcb.domain.VerificationType;

import lombok.Data;

@Data
public class TwoFactorAuth {
    private Boolean isEnabled = false;
    private VerificationType sendTo;
}
