package com.royalfantasy.backend.infrastructure.rest.controller;

import com.royalfantasy.backend.application.service.UserService;
import com.royalfantasy.backend.infrastructure.rest.dto.CreateUserDto;
import com.royalfantasy.backend.infrastructure.rest.dto.JwtTokenDto;
import com.royalfantasy.backend.infrastructure.rest.dto.LoginUserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping(value="register", produces="application/json")
    public ResponseEntity<JwtTokenDto> register(@RequestBody CreateUserDto dto){
        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping(value="login", produces="application/json")
    public ResponseEntity<JwtTokenDto> login(@Valid @RequestBody LoginUserDto dto){
        return ResponseEntity.ok(userService.login(dto));
    }
}
