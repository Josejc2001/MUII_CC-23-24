package com.royalfantasy.backend.application.usecase;

import com.royalfantasy.backend.domain.action.UpdatePlayerAction;
import com.royalfantasy.backend.domain.model.Player;
import com.royalfantasy.backend.port.in.UpdatePlayerUseCase;
import com.royalfantasy.backend.port.out.PlayerRepositoryPort;

public class UpdatePlayerUseCaseImpl implements UpdatePlayerUseCase {
    private final PlayerRepositoryPort playerRepositoryPort;

    public UpdatePlayerUseCaseImpl(PlayerRepositoryPort playerRepositoryPort) {
        this.playerRepositoryPort = playerRepositoryPort;
    }

    @Override
    public Player updatePlayer(Long id, UpdatePlayerAction action) {
        return null;
    }
}
