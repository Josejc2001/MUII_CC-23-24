package com.royalfantasy.backend.infrastructure.config;

import com.royalfantasy.backend.application.service.PlayerService;
import com.royalfantasy.backend.application.usecase.CreatePlayerUseCaseImpl;
import com.royalfantasy.backend.application.usecase.DeletePlayerUseCaseImpl;
import com.royalfantasy.backend.application.usecase.RetrievePlayerUseCaseImpl;
import com.royalfantasy.backend.application.usecase.UpdatePlayerUseCaseImpl;
import com.royalfantasy.backend.infrastructure.repository.jpa.JpaPlayerRepositoryAdapter;
import com.royalfantasy.backend.infrastructure.repository.jpa.JpaUserRepository;
import com.royalfantasy.backend.port.out.PlayerRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final JpaUserRepository userRepository;

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

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
