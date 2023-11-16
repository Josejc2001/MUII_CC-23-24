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
        Player player = Player.Builder.newBuilder()
                .id(action.getId())
                .name(action.getName())
                .position(action.getPosition())
                .age(action.getAge())
                .height(action.getHeight())
                .weight(action.getWeight())
                .value(action.getValue())
                .clause(action.getClause())
                .points(action.getPoints())
                .team(action.getTeam())
                .build();
        return playerRepositoryPort.update(player);
    }
}
