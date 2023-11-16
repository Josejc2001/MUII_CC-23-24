package com.royalfantasy.backend.application.usecase;

import com.royalfantasy.backend.port.in.DeletePlayerUseCase;
import com.royalfantasy.backend.port.out.PlayerRepositoryPort;

public class DeletePlayerUseCaseImpl implements DeletePlayerUseCase {
    private final PlayerRepositoryPort playerRepositoryPort;

    public DeletePlayerUseCaseImpl(PlayerRepositoryPort playerRepositoryPort) {
        this.playerRepositoryPort = playerRepositoryPort;
    }

    @Override
    public boolean deletePlayer(Long id) {
        return false;
    }
}
