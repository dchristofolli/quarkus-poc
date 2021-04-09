package com.dchristofolli.v1;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;

public class UserDto {
    private String name;
    @CPF
    private String cpf;
    @Email
    private String email;

    public UserDto(String name, String cpf, String email) {
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
}
