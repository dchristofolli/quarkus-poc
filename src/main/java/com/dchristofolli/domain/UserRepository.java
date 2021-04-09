package com.dchristofolli.domain;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<UserEntity> {
    public Optional<UserEntity> findByCpf(String cpf) {
        return find("cpf", cpf).firstResultOptional();
    }

    public void deleteByCpf(String cpf) {
        delete("cpf", cpf);
    }
}
