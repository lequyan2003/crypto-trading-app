package com.mcb.service;

import com.mcb.domain.VerificationType;
import com.mcb.modal.User;

public interface UserService {
    public User findUserProfileByJwt(String jwt);
    public User findUserByEmail(String email);
    public User findUserById(Long userId) throws Exception;

    public User enableTwoFactorAuthentication(
        VerificationType verificationType,
        String sendTo,
        User user
    );

    User updatePassword(User user, String newPassword);
}
