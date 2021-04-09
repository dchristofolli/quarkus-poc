package com.dchristofolli.v1;

import com.dchristofolli.domain.UserEntity;

public class UserMapper {
    private UserMapper() {
    }

    public static UserEntity mapToEntity(UserDto dto) {
        return new UserEntity(dto.getName(), dto.getCpf(), dto.getEmail());
    }

    public static UserDto mapToResponse(UserEntity userEntity) {
        return new UserDto(userEntity.getName(), userEntity.getCpf(), userEntity.getEmail());
    }
}
