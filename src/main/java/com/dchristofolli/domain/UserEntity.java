package com.dchristofolli.domain;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.Objects;

@MongoEntity(database = "crud", collection = "users")
public class UserEntity extends PanacheMongoEntity {
    private String name;
    private String cpf;
    private String email;

    public UserEntity() {
    }

    public UserEntity(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity userEntity = (UserEntity) o;
        return name.equals(userEntity.name) && Objects.equals(cpf, userEntity.cpf) && Objects.equals(email, userEntity.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cpf, email);
    }
}
