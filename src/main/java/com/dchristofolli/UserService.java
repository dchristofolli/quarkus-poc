package com.dchristofolli;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import static com.dchristofolli.UserMapper.mapToEntity;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.listAll()
            .parallelStream()
            .map(UserMapper::mapToResponse)
            .collect(Collectors.toList());
    }

    public void create(UserDto user) {
        userRepository.persist(mapToEntity(user));
    }

    public UserDto findByCpf(String cpf) throws ApiException {
        return UserMapper.mapToResponse(userRepository.findByCpf(cpf)
            .orElseThrow(() -> new ApiException("Invalid cpf number")));
    }

    public void deleteByCpf(String cpf) {
        userRepository.deleteByCpf(cpf);
    }

    public void updateUsername(String cpf, String newName) {
        userRepository.update("name", newName).where("cpf", cpf);
    }
}
