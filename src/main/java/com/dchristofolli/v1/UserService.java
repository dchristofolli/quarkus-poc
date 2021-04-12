package com.dchristofolli.v1;

import com.dchristofolli.domain.UserRepository;
import com.dchristofolli.exception.ApiException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import static com.dchristofolli.v1.UserMapper.mapToEntity;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    public List<UserDto> find(String param) throws ApiException {
        if (param == null)
            return findAll();
        return findByParam(param);
    }

    public List<UserDto> findAll() {
        return userRepository.listAll()
            .parallelStream()
            .map(UserMapper::mapToResponse)
            .collect(Collectors.toList());
    }

    public void create(UserDto user) {
        userRepository.persist(mapToEntity(user));
    }

    public List<UserDto> findByParam(String param) {
        return userRepository.find(param).parallelStream()
            .map(UserMapper::mapToResponse)
            .collect(Collectors.toList());
    }

    public void deleteByCpf(String cpf) {
        userRepository.deleteByCpf(cpf);
    }

    public UserDto updateUsername(String cpf, String newName) {
        userRepository.update("name", newName).where("cpf", cpf);
        return findByParam(cpf).stream().findFirst().orElse(new UserDto());
    }
}
