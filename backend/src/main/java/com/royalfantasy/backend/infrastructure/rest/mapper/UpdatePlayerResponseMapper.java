package com.royalfantasy.backend.infrastructure.rest.mapper;

import com.royalfantasy.backend.domain.model.Player;
import com.royalfantasy.backend.infrastructure.rest.dto.UpdatePlayerResponse;

public class UpdatePlayerResponseMapper {
    public UpdatePlayerResponseMapper() {
    }

    public static UpdatePlayerResponse map(final Player player){
        return UpdatePlayerResponse.Builder.newBuilder()
                .id(player.getId())
                .build();
    }
}
