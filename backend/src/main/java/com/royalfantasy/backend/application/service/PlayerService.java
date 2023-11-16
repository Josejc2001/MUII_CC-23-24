package com.royalfantasy.backend.application.service;

import com.royalfantasy.backend.domain.action.CreatePlayerAction;
import com.royalfantasy.backend.domain.action.UpdatePlayerAction;
import com.royalfantasy.backend.domain.model.Player;
import com.royalfantasy.backend.port.in.CreatePlayerUseCase;
import com.royalfantasy.backend.port.in.DeletePlayerUseCase;
import com.royalfantasy.backend.port.in.RetrievePlayerUseCase;
import com.royalfantasy.backend.port.in.UpdatePlayerUseCase;

import java.util.List;

public class PlayerService implements CreatePlayerUseCase, RetrievePlayerUseCase, UpdatePlayerUseCase, DeletePlayerUseCase {
    private final CreatePlayerUseCase createPlayerUseCase;
    private final RetrievePlayerUseCase retrievePlayerUseCase;
    private final UpdatePlayerUseCase updatePlayerUseCase;
    private final DeletePlayerUseCase deletePlayerUseCase;

    public PlayerService(CreatePlayerUseCase createPlayerUseCase, RetrievePlayerUseCase retrievePlayerUseCase, UpdatePlayerUseCase updatePlayerUseCase, DeletePlayerUseCase deletePlayerUseCase) {
        this.createPlayerUseCase = createPlayerUseCase;
        this.retrievePlayerUseCase = retrievePlayerUseCase;
        this.updatePlayerUseCase = updatePlayerUseCase;
        this.deletePlayerUseCase = deletePlayerUseCase;
    }

    @Override
    public Player createPlayer(CreatePlayerAction action) {
        return createPlayerUseCase.createPlayer(action);
    }

    @Override
    public boolean deletePlayer(Long id) {
        return deletePlayerUseCase.deletePlayer(id);
    }

    @Override
    public Player getPlayer(Long id) {
        return retrievePlayerUseCase.getPlayer(id);
    }

    @Override
    public List<Player> getAllPlayers() {
        return retrievePlayerUseCase.getAllPlayers();
    }

    @Override
    public Player updatePlayer(Long id, UpdatePlayerAction action) {
        return updatePlayerUseCase.updatePlayer(id, action);
    }
}
