package com.royalfantasy.backend.port.in;

import com.royalfantasy.backend.domain.model.Player;

import java.util.List;

public interface RetrievePlayerUseCase {
    Player getPlayer(Long id);
    List<Player> getAllPlayers();
}
