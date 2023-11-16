package com.royalfantasy.backend.port.in;

import com.royalfantasy.backend.domain.action.UpdatePlayerAction;
import com.royalfantasy.backend.domain.model.Player;

public interface UpdatePlayerUseCase {
    Player updatePlayer(Long id, UpdatePlayerAction action);
}
