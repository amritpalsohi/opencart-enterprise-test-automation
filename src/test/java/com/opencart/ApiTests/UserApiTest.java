package com.opencart.ApiTests;

import com.opencart.Models.Request.CreateUserRequest;
import com.opencart.Models.Response.CreateUserResponse;
import com.opencart.StepDefinitions.UserAPI;
import com.opencart.TestComponents.BaseTestApi;

import static com.opencart.TestComponents.BaseTest.log;

public class UserApiTest extends BaseTestApi {

    void createUserTest(){
        CreateUserRequest request = new CreateUserRequest("test001@mailinator.com","First_Test","Last_Test","https://reqres.in/img/faces/4-image.jpg");

        CreateUserResponse response = UserAPI.createUser(request);

        log.info("User created with id: "+response.getId());

    }

    void getUserByIdTest(){
        UserAPI.getUserById(1);
    }

    void getUsersByPageTest(){
        UserAPI.getUsersByPage(1);
    }
}
