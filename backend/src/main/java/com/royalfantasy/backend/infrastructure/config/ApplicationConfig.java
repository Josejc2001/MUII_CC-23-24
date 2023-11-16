package com.royalfantasy.backend.infrastructure.config;

import com.royalfantasy.backend.application.service.PlayerService;
import com.royalfantasy.backend.application.usecase.CreatePlayerUseCaseImpl;
import com.royalfantasy.backend.application.usecase.DeletePlayerUseCaseImpl;
import com.royalfantasy.backend.application.usecase.RetrievePlayerUseCaseImpl;
import com.royalfantasy.backend.application.usecase.UpdatePlayerUseCaseImpl;
import com.royalfantasy.backend.infrastructure.repository.jpa.JpaPlayerRepositoryAdapter;
import com.royalfantasy.backend.port.out.PlayerRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public PlayerService playerService(PlayerRepositoryPort playerRepositoryPort){
        return new PlayerService(
                new CreatePlayerUseCaseImpl(playerRepositoryPort),
                new RetrievePlayerUseCaseImpl(playerRepositoryPort),
                new UpdatePlayerUseCaseImpl(playerRepositoryPort),
                new DeletePlayerUseCaseImpl(playerRepositoryPort)
        );
    }

    @Bean
    public PlayerRepositoryPort playerRepositoryPort(JpaPlayerRepositoryAdapter jpaPlayerRepositoryAdapter){
        return jpaPlayerRepositoryAdapter;
    }
}
