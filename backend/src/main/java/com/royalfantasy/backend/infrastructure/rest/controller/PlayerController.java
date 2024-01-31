package com.royalfantasy.backend.infrastructure.rest.controller;

import com.royalfantasy.backend.application.service.PlayerService;
import com.royalfantasy.backend.domain.action.CreatePlayerAction;
import com.royalfantasy.backend.domain.action.UpdatePlayerAction;
import com.royalfantasy.backend.domain.model.Player;
import com.royalfantasy.backend.infrastructure.rest.dto.*;
import com.royalfantasy.backend.infrastructure.rest.mapper.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(value="/api/players", produces="application/json")
    public ResponseEntity<CreatePlayerResponse> createPlayer(@RequestBody final CreatePlayerRequest request){
        CreatePlayerAction action = CreatePlayerActionMapper.map(request);

        Player player = playerService.createPlayer(action);

        CreatePlayerResponse response = CreatePlayerResponseMapper.map(player);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping(value="/api/players/{playerId}", produces="application/json")
    public ResponseEntity<RetrieveByIdPlayerResponse> getPlayerById(@PathVariable Long playerId){
        Player player = playerService.getPlayer(playerId);

        RetrieveByIdPlayerResponse response = RetrieveByIdPlayerResponseMapper.map(player);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value="/api/players", produces="application/json")
    public ResponseEntity<RetrieveAllPlayerResponse> getAllPlayers(){
        List<Player> players = playerService.getAllPlayers();

        RetrieveAllPlayerResponse response = RetrieveAllPlayerResponseMapper.map(players);
        System.out.println(response);

        return ResponseEntity.ok(response);
    }

    @PatchMapping(value="/api/players/{playerId}", produces="application/json")
    public ResponseEntity<UpdatePlayerResponse> updatePlayer(@PathVariable Long playerId, @RequestBody UpdatePlayerRequest request){
        UpdatePlayerAction action = UpdatePlayerAction.Builder.newBuilder()
                .id(playerId)
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

        Player player = playerService.updatePlayer(playerId, action);

        UpdatePlayerResponse response = UpdatePlayerResponseMapper.map(player);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value="/api/players/{playerId}")
    public ResponseEntity<Void> deletePlayerById(@PathVariable Long playerId){
        if(playerService.deletePlayer(playerId)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
