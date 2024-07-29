package com.mcb.service;

import com.mcb.modal.Coin;
import com.mcb.modal.User;
import com.mcb.modal.Watchlist;

public interface WatchlistService {
    Watchlist findUserWatchlist(Long userId) throws Exception;
    Watchlist createWatchlist(User user);
    Watchlist findById(Long id) throws Exception;

    Coin addItemToWatchlist(Coin coin, User user) throws Exception;
}
