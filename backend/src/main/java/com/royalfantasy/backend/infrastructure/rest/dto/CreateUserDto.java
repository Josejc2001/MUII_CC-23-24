package com.royalfantasy.backend.infrastructure.rest.dto;

import com.royalfantasy.backend.domain.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    @NotBlank(message = "username is mandatory")
    private String username;
    @NotBlank(message = "email is mandatory")
    @Email(message = "invalid email")
    private String email;
    @NotBlank(message = "password is mandatory")
    private String password;
    private Role role;
}
