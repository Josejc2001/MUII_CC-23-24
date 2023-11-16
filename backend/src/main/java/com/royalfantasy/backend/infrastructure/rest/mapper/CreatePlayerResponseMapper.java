package com.royalfantasy.backend.infrastructure.rest.mapper;

import com.royalfantasy.backend.domain.model.Player;
import com.royalfantasy.backend.infrastructure.rest.dto.CreatePlayerResponse;

public class CreatePlayerResponseMapper {
    public CreatePlayerResponseMapper(){}

    public static CreatePlayerResponse map(final Player player){
        return CreatePlayerResponse.Builder.newBuilder()
                .id(player.getId().toString())
                .build();
    }
}
