package com.mcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcb.modal.Coin;

public interface CoinRepository extends JpaRepository<Coin, String> {

}
