package com.dchristofolli;

public class UserMapper {
    public static User mapToEntity(UserDto dto){
        return new User(dto.getName(), dto.getCpf(), dto.getEmail());
    }
}
