package com.opencart.StepDefinitions;

import com.opencart.ApiTests.UserAPI;
import com.opencart.Models.Request.CreateUserRequest;
import com.opencart.Models.Response.CreateUserResponse;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.opencart.TestComponents.BaseTest.log;

public class CreateUserApi {

    CreateUserResponse response;

    @Given("The API is available")
    public void apiIsAvailable() {
        // Usually empty or base setup
    }

    @When("User I create the user with body details of id {int} email {string} first_name {string} last_name {string} avatar {string}")
    public void createUser(int id, String email, String first_name, String last_name, String avatar) {
        CreateUserRequest request =
                new CreateUserRequest(id, email, first_name, last_name, avatar);

        response = UserAPI.createUser(request);
    }

    @Then("Response code should be 201")
    public void validateResponse() {

        log.info(response.getId());
        log.info(response.getEmail());
        log.info(response.getFirst_name());
        log.info(response.getLast_name());
    }
}
