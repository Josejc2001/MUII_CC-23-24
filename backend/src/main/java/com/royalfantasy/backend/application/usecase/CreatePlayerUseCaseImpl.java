package com.royalfantasy.backend.application.usecase;

import com.royalfantasy.backend.domain.action.CreatePlayerAction;
import com.royalfantasy.backend.domain.model.Player;
import com.royalfantasy.backend.port.in.CreatePlayerUseCase;
import com.royalfantasy.backend.port.out.PlayerRepositoryPort;

public class CreatePlayerUseCaseImpl implements CreatePlayerUseCase {
    private final PlayerRepositoryPort playerRepositoryPort;

    public CreatePlayerUseCaseImpl(PlayerRepositoryPort playerRepositoryPort) {
        this.playerRepositoryPort = playerRepositoryPort;
    }

    @Override
    public Player createPlayer(CreatePlayerAction action) {
        return null;
    }
}
