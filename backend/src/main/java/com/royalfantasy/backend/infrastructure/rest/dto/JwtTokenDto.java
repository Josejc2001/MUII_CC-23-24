package com.royalfantasy.backend.infrastructure.rest.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtTokenDto {
    private String token;
}

