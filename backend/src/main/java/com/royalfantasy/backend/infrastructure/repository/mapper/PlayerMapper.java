package com.royalfantasy.backend.infrastructure.repository.mapper;

import com.royalfantasy.backend.domain.model.Player;
import com.royalfantasy.backend.infrastructure.repository.entity.PlayerEntity;

public class PlayerMapper {
    public static Player map(final PlayerEntity entity){
        return Player.Builder.newBuilder()
                .id(entity.getId())
                .name(entity.getName())
                .position(entity.getPosition())
                .age(entity.getAge())
                .height(entity.getHeight())
                .weight(entity.getWeight())
                .value(entity.getValue())
                .clause(entity.getClause())
                .points(entity.getPoints())
                .team(entity.getTeam())
                .build();
    }
}
