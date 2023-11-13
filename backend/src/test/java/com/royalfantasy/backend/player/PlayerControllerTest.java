package com.royalfantasy.backend.player;

import com.royalfantasy.backend.domain.record.Player;
import com.royalfantasy.backend.infrastructure.rest.controller.PlayerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlayerController.class)
@AutoConfigureMockMvc
public class PlayerControllerTest {
    @Autowired
    MockMvc mockMvc;

    List<Player> players = new ArrayList<>();

    @BeforeEach
    void setUp() {
        // create some players
        players = List.of(
                new Player((long)1,"Jose", "MC", 22, 1.72, 70.4, 25000000, 50000000, 50, "Real Madrid CF"),
                new Player((long)2,"Pepe", "DC", 30, 1.90, 82.4, 27000000, 52000000, 70, "FC Barcelona")
        );
    }

    // REST API

    // list
    @Test
    void shouldFindAllPlayers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/players"))
                .andExpect(status().isOk());
    }

}
