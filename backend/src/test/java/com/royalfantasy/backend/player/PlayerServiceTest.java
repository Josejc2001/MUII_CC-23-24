package com.royalfantasy.backend.player;

import com.royalfantasy.backend.application.service.PlayerService;
import com.royalfantasy.backend.domain.action.CreatePlayerAction;
import com.royalfantasy.backend.domain.action.UpdatePlayerAction;
import com.royalfantasy.backend.domain.model.Player;
import com.royalfantasy.backend.port.in.CreatePlayerUseCase;
import com.royalfantasy.backend.port.in.DeletePlayerUseCase;
import com.royalfantasy.backend.port.in.RetrievePlayerUseCase;
import com.royalfantasy.backend.port.in.UpdatePlayerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {
    @Mock
    private CreatePlayerUseCase createPlayerUseCase;

    @Mock
    private RetrievePlayerUseCase retrievePlayerUseCase;

    @Mock
    private UpdatePlayerUseCase updatePlayerUseCase;

    @Mock
    private DeletePlayerUseCase deletePlayerUseCase;

    @InjectMocks
    private PlayerService playerService;

    @Test
    public void createPlayerTest(){
        Player playerTest = Player.Builder.newBuilder()
                .name("prueba")
                .position("DC")
                .age(20)
                .height(2.30)
                .weight(70.4)
                .value(1)
                .clause(1)
                .points(1)
                .team("Real")
                .build();

        CreatePlayerAction actionTest = CreatePlayerAction.Builder.newBuilder()
                .name("prueba")
                .position("DC")
                .age(20)
                .height(2.30)
                .weight(70.4)
                .value(1)
                .clause(1)
                .points(1)
                .team("Real")
                .build();

        Mockito.when(createPlayerUseCase.createPlayer(actionTest))
                .thenReturn(playerTest);

        final Player result = playerService.createPlayer(actionTest);
        Assertions.assertEquals(playerTest.getName(), result.getName());
        Assertions.assertEquals(playerTest.getPosition(), result.getPosition());
        Assertions.assertEquals(playerTest.getAge(), result.getAge());
        Assertions.assertEquals(playerTest.getHeight(), result.getHeight());
        Assertions.assertEquals(playerTest.getWeight(), result.getWeight());
        Assertions.assertEquals(playerTest.getValue(), result.getValue());
        Assertions.assertEquals(playerTest.getClause(), result.getClause());
        Assertions.assertEquals(playerTest.getPoints(), result.getPoints());
        Assertions.assertEquals(playerTest.getTeam(), result.getTeam());
    }

    @Test
    public void getPlayerTest(){
        Player playerTest = Player.Builder.newBuilder()
                .id(1L)
                .name("prueba")
                .position("DC")
                .age(20)
                .height(2.30)
                .weight(70.4)
                .value(1)
                .clause(1)
                .points(1)
                .team("Real")
                .build();

        Mockito.when(retrievePlayerUseCase.getPlayer(1L))
                .thenReturn(playerTest);

        final Player result = playerService.getPlayer(1L);
        Assertions.assertEquals(playerTest, result);
    }

    @Test
    public void updatePlayerTest(){
        Player playerTestModified = Player.Builder.newBuilder()
                .id(1L)
                .name("prueba modified")
                .position("DC")
                .age(20)
                .height(2.30)
                .weight(70.4)
                .value(1)
                .clause(1)
                .points(1)
                .team("Real")
                .build();

        UpdatePlayerAction actionTest = UpdatePlayerAction.Builder.newBuilder()
                .id(1L)
                .name("prueba modified")
                .position("DC")
                .age(20)
                .height(2.30)
                .weight(70.4)
                .value(1)
                .clause(1)
                .points(1)
                .team("Real")
                .build();

        Mockito.when(updatePlayerUseCase.updatePlayer(1L, actionTest))
                .thenReturn(playerTestModified);

        final Player result = playerService.updatePlayer(1L, actionTest);
        Assertions.assertEquals(playerTestModified.getId(), result.getId());
        Assertions.assertEquals(playerTestModified.getName(), result.getName());
        Assertions.assertEquals(playerTestModified.getPosition(), result.getPosition());
        Assertions.assertEquals(playerTestModified.getAge(), result.getAge());
        Assertions.assertEquals(playerTestModified.getHeight(), result.getHeight());
        Assertions.assertEquals(playerTestModified.getWeight(), result.getWeight());
        Assertions.assertEquals(playerTestModified.getValue(), result.getValue());
        Assertions.assertEquals(playerTestModified.getClause(), result.getClause());
        Assertions.assertEquals(playerTestModified.getPoints(), result.getPoints());
        Assertions.assertEquals(playerTestModified.getTeam(), result.getTeam());
    }

    @Test
    public void deletePlayerTest(){
        Player playerTest = Player.Builder.newBuilder()
                .id(1L)
                .name("prueba")
                .position("DC")
                .age(20)
                .height(2.30)
                .weight(70.4)
                .value(1)
                .clause(1)
                .points(1)
                .team("Real")
                .build();

        Mockito.when(deletePlayerUseCase.deletePlayer(playerTest.getId()))
                .thenReturn(true);

        final boolean result = playerService.deletePlayer(1L);
        Assertions.assertTrue(result);

    }


}
