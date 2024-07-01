package com.mcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcb.modal.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
