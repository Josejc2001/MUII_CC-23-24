package com.royalfantasy.backend.infrastructure.repository.mapper;

import com.royalfantasy.backend.domain.model.Player;
import com.royalfantasy.backend.infrastructure.repository.entity.PlayerEntity;

public class PlayerEntityMapper {
    public static PlayerEntity map(final Player player){
        return PlayerEntity.Builder.newBuilder()
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
