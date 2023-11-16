package com.royalfantasy.backend.infrastructure.rest.controller;

import com.royalfantasy.backend.application.service.PlayerService;
import com.royalfantasy.backend.domain.action.CreatePlayerAction;
import com.royalfantasy.backend.domain.model.Player;
import com.royalfantasy.backend.infrastructure.rest.dto.CreatePlayerRequest;
import com.royalfantasy.backend.infrastructure.rest.dto.CreatePlayerResponse;
import com.royalfantasy.backend.infrastructure.rest.mapper.CreatePlayerActionMapper;
import com.royalfantasy.backend.infrastructure.rest.mapper.CreatePlayerResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "*")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<CreatePlayerResponse> createPlayer(@RequestBody final CreatePlayerRequest request){
        CreatePlayerAction action = CreatePlayerActionMapper.map(request);

        Player player = playerService.createPlayer(action);

        CreatePlayerResponse response = CreatePlayerResponseMapper.map(player);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

}
