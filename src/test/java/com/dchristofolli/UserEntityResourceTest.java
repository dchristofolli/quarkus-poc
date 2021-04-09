package com.dchristofolli;

import com.google.gson.Gson;
import io.quarkus.test.junit.QuarkusTest;
import io.vertx.core.json.JsonObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class UserEntityResourceTest {
    Gson gson = new Gson();
    JsonObject requestParams = new JsonObject()
        .put("name", "quarkus")
        .put("cpf", "61126823031")
        .put("email", "quarkus@redhat.com");

    @Test
    void testCreateUserEndpoint() {
        given()
            .when().post("/users")
            .then()
            .statusCode(201);
    }

    @Test
    void testFindAllEndpoint() {
        given().get("/users")
            .then()
            .statusCode(200);
    }
}