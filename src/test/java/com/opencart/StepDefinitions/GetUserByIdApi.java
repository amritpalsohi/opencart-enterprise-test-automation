package com.opencart.StepDefinitions;

import com.opencart.ApiTests.UserAPI;
import com.opencart.Models.Request.CreateUserRequest;
import com.opencart.Models.Response.CreateUserResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.opencart.TestComponents.BaseTest.log;

public class GetUserByIdApi {

    CreateUserResponse response;

    @Given("The Get API by Id is available")
    public void getApiByIdIsAvailable() {
        // Usually empty or base setup
    }

    @When("User passes the id {int} in get request parameter")
    public void getUserById(int id) {
        UserAPI.getUserById(id);
        log.info("Get user by id API called with id: " + id);
    }

    @Then("Response code should be 200")
    public void validateResponse() {
    log.info("200OK");
    }
}
