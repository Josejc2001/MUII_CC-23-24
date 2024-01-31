package com.royalfantasy.backend.infrastructure.rest.mapper;

import com.royalfantasy.backend.infrastructure.repository.entity.UserEntity;
import com.royalfantasy.backend.infrastructure.rest.dto.RetrieveUserByUsernameResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    RetrieveUserByUsernameResponse fromEntityToResponseGet(UserEntity user);
}
