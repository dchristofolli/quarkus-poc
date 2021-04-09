package com.dchristofolli;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User> {
    public Optional<User> findByCpf(String cpf) {
        return find("cpf", cpf).firstResultOptional();
    }

    public void deleteByCpf(String cpf) {
        delete("cpf", cpf);
    }
}
