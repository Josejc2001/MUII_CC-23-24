package com.royalfantasy.backend.player;

import com.royalfantasy.backend.infrastructure.repository.entity.PlayerEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerEntityTest {
    @Test
    void test(){
        PlayerEntity playerEntity = new PlayerEntity();

        playerEntity.setId(1L);
        playerEntity.setName("Name");

        assertEquals(1, playerEntity.getId());
        assertEquals("Name",playerEntity.getName());
    }
}
