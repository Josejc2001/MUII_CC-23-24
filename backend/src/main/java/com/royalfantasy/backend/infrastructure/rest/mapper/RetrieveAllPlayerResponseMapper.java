package com.royalfantasy.backend.infrastructure.rest.mapper;

import com.royalfantasy.backend.domain.model.Player;
import com.royalfantasy.backend.infrastructure.rest.dto.RetrieveAllPlayerResponse;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveAllPlayerResponseMapper {
    public static RetrieveAllPlayerResponse map(List<Player> players){
        return RetrieveAllPlayerResponse.Builder.newBuilder()
                .playersRetrieveByIdResponse(players.stream()
                        .map(RetrieveByIdPlayerResponseMapper::map)
                        .collect(Collectors.toList()))
                .build();
    }
}
