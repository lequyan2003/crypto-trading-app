package com.mcb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.config.JwtProvider;
import com.mcb.domain.VerificationType;
import com.mcb.modal.TwoFactorAuth;
import com.mcb.modal.User;
import com.mcb.repository.UserRepository;

@RestController
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserProfileByJwt(String jwt) {
        String email = JwtProvider.getEmailFromToken(jwt);
        User user = userRepository.findByEmail(email);

        if (user == null) {
            try {
                throw new Exception("User not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            try {
                throw new Exception("User not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public User findUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            try {
                throw new Exception("User not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user.get();
    }

    @Override
    public User enableTwoFactorAuthentication(
        VerificationType verificationType,
        String sendTo,
        User user
    ) {
        TwoFactorAuth twoFactorAuth = new TwoFactorAuth();
        twoFactorAuth.setEnabled(true);
        twoFactorAuth.setSendTo(verificationType);

        user.setTwoFactorAuth(twoFactorAuth);

        return userRepository.save(user);
    }

    @Override
    public User updatePassword(User user, String newPassword) {
        user.setPassword(newPassword);
        
        return userRepository.save(user);
    }
}
