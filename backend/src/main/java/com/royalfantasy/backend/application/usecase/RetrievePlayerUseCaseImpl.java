package com.royalfantasy.backend.application.usecase;

import com.royalfantasy.backend.domain.model.Player;
import com.royalfantasy.backend.port.in.RetrievePlayerUseCase;
import com.royalfantasy.backend.port.out.PlayerRepositoryPort;

import java.util.List;

public class RetrievePlayerUseCaseImpl implements RetrievePlayerUseCase {
    private final PlayerRepositoryPort playerRepositoryPort;

    public RetrievePlayerUseCaseImpl(PlayerRepositoryPort playerRepositoryPort) {
        this.playerRepositoryPort = playerRepositoryPort;
    }

    @Override
    public Player getPlayer(Long id) {
        return playerRepositoryPort.findById(id).orElse(null);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepositoryPort.findAll();
    }
}
