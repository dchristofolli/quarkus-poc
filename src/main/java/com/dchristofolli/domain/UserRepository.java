package com.dchristofolli.domain;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<UserEntity> {
    public List<UserEntity> find(String param) {
        return find("_id like ?1 or cpf like ?1 or name like ?1 or email like ?1", param)
            .stream().collect(Collectors.toList());
    }

    public void deleteByCpf(String cpf) {
        delete("cpf", cpf);
    }
}
