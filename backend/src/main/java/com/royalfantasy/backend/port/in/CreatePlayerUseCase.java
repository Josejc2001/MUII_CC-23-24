package com.royalfantasy.backend.port.in;

import com.royalfantasy.backend.domain.action.CreatePlayerAction;
import com.royalfantasy.backend.domain.model.Player;

public interface CreatePlayerUseCase {
    Player createPlayer(CreatePlayerAction action);
}
