package com.dchristofolli.v1;

import com.dchristofolli.domain.UserEntity;
import com.dchristofolli.domain.UserRepository;
import io.quarkus.mongodb.panache.PanacheQuery;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.inject.Inject;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserServiceTest {
    @Inject
    UserService service;

    UserRepository repository;

    UserEntity entity = new UserEntity(
        "daniel", "38076426090", "daniel@quarkus.com");
    List<UserEntity> entityList = Collections.singletonList(entity);

    UserDto dto = new UserDto("daniel", "38076426090", "daniel@quarkus.com");

    List<UserDto> dtoList = Collections.singletonList(dto);

    @Test
    void findAll() {
        Mockito.when(repository.findAll())
            .thenReturn((PanacheQuery<UserEntity>) entityList);
        Assertions.assertEquals(dtoList, service.findAll());
    }

    @Test
    void create() {
    }

    @Test
    void findByCpf() {
    }

    @Test
    void deleteByCpf() {
    }

    @Test
    void updateUsername() {
    }
}