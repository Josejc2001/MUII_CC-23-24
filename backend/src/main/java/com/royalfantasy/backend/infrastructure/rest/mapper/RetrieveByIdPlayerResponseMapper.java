package com.royalfantasy.backend.infrastructure.rest.mapper;

import com.royalfantasy.backend.domain.model.Player;
import com.royalfantasy.backend.infrastructure.rest.dto.RetrieveByIdPlayerResponse;

public class RetrieveByIdPlayerResponseMapper {
    public static RetrieveByIdPlayerResponse map(Player player){
        return RetrieveByIdPlayerResponse.Builder.newBuilder()
                .id(player.getId())
                .name(player.getName())
                .position(player.getPosition())
                .age(player.getAge())
                .height(player.getHeight())
                .weight(player.getWeight())
                .value(player.getValue())
                .clause(player.getClause())
                .points(player.getPoints())
                .team(player.getTeam())
                .build();
    }
}
