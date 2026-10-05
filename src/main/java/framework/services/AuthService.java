package framework.services;

import framework.core.RequestSpec;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthService {

    public String generateToken(String username, String password) {

        Response response = given()
                .spec(RequestSpec.getSpec())
                .body(Map.of("username", username, "password", password))
                .when()
                .post("/auth");

        return response.jsonPath().getString("token");
    }
}
