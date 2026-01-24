package com.opencart.ApiTests;

import com.opencart.Models.Request.CreateUserRequest;
import com.opencart.Models.Response.CreateUserResponse;
import com.opencart.Spec.RequestSpecFactory;
import io.restassured.specification.RequestSpecification;

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
                .spec(RequestSpecFactory.getRequestSpecification())
                .log().all()
                .when()
                .get("/users/"+id)
                .then()
                .log().all()
                .statusCode(200)
                .extract();
    }

    public static void getUsersByPage(int page){
        given()
                .when()
                .get("/users?page="+page)
                .then()
                .statusCode(200);
    }
}
