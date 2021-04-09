package com.dchristofolli;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

import static com.dchristofolli.UserMapper.mapToEntity;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.listAll();
    }

    public void create(UserDto user) {
        userRepository.persist(mapToEntity(user));
    }

    public User findByCpf(String cpf) throws ApiException {
        return userRepository.findByCpf(cpf).orElseThrow(() -> new ApiException("Invalid cpf number"));
    }

    public void deleteByCpf(String cpf) {
        userRepository.deleteByCpf(cpf);
    }
}
