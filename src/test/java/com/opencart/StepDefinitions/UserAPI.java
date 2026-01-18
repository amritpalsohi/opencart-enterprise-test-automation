package com.opencart.StepDefinitions;

import com.opencart.Models.Request.CreateUserRequest;
import com.opencart.Models.Response.CreateUserResponse;

import static io.restassured.RestAssured.*;

public class UserAPI {

    public static CreateUserResponse createUser(CreateUserRequest request){

        return given()
                .body(request)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract()
                .as(CreateUserResponse.class);

    }

    public static void getUserById(int id){
        given()
                .when()
                .get("/users/"+id)
                .then()
                .statusCode(200);
    }

    public static void getUsersByPage(int page){
        given()
                .when()
                .get("/users?page="+page)
                .then()
                .statusCode(200);
    }
}
