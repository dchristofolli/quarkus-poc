package com.dchristofolli;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.listAll();
    }

    public void create(User user) {
        userRepository.persist(user);
    }

    public User findByCpf(String cpf) throws ApiException {
        return userRepository.findByCpf(cpf).orElseThrow(() -> new ApiException("Invalid cpf number"));
    }
}
