package com.mcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mcb.modal.Watchlist;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
    Watchlist findByUserId(Long userId);
}
