package com.dchristofolli;

public class UserMapper {
    private UserMapper() {
    }

    public static User mapToEntity(UserDto dto){
        return new User(dto.getName(), dto.getCpf(), dto.getEmail());
    }
    public static UserDto mapToResponse(User user){
        return new UserDto(user.getName(), user.getCpf(), user.getEmail());
    }
}
