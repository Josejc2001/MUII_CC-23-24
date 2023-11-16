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
        Player player = Player.Builder.newBuilder()
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
        return playerRepositoryPort.save(player);
    }
}
