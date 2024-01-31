package com.royalfantasy.backend.application.service;

import com.royalfantasy.backend.application.service.jwt.JwtService;
import com.royalfantasy.backend.infrastructure.repository.entity.UserEntity;
import com.royalfantasy.backend.infrastructure.repository.jpa.JpaUserRepository;
import com.royalfantasy.backend.infrastructure.rest.dto.CreateUserDto;
import com.royalfantasy.backend.infrastructure.rest.dto.JwtTokenDto;
import com.royalfantasy.backend.infrastructure.rest.dto.LoginUserDto;
import com.royalfantasy.backend.infrastructure.rest.dto.RetrieveUserByUsernameResponse;
import com.royalfantasy.backend.infrastructure.rest.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JpaUserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public JwtTokenDto register(CreateUserDto dto) {
        UserEntity user = UserEntity.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .email(dto.getEmail())
                .role(dto.getRole())
                .build();

        userRepository.save(user);

        return JwtTokenDto.builder()
                .token(jwtService.getToken(user))
                .build();
    }

    public JwtTokenDto login(LoginUserDto dto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        UserDetails user = userRepository.findByUsername(dto.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return JwtTokenDto.builder()
                .token(token)
                .build();
    }

    public RetrieveUserByUsernameResponse getByUsername(String username) {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        RetrieveUserByUsernameResponse response = UserMapper.MAPPER.fromEntityToResponseGet(user.get());
        return response;
    }
}
