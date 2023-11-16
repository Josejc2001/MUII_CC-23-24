package com.royalfantasy.backend.infrastructure.rest.mapper;

import com.royalfantasy.backend.domain.action.CreatePlayerAction;
import com.royalfantasy.backend.infrastructure.rest.dto.CreatePlayerRequest;

public class CreatePlayerActionMapper {
    public CreatePlayerActionMapper() {
    }

    public static CreatePlayerAction map(final CreatePlayerRequest request){
        return CreatePlayerAction.Builder.newBuilder()
                .name(request.getName())
                .position(request.getPosition())
                .age(request.getAge())
                .height(request.getHeight())
                .weight(request.getWeight())
                .value(request.getValue())
                .clause(request.getClause())
                .points(request.getPoints())
                .team(request.getTeam())
                .build();
    }
}
