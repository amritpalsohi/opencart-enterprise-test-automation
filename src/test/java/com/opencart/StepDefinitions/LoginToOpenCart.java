package com.opencart.StepDefinitions;

import com.opencart.PageObjects.LoginPage;
import com.opencart.Resources.TestDataUtility;
import com.opencart.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static com.opencart.TestComponents.BaseTest.log;
import static org.testng.Assert.assertTrue;


public class LoginToOpenCart {

    //LoginPage loginPage = NavigateToLoginPage.loginPage;

    TestDataUtility testDataUtility = new TestDataUtility();

    @Given("User is landed on login page")
    public void userIsLandedOnLoginPage() {
        LoginPage loginPage = NavigateToLoginPage.loginPage;
        String url= loginPage.getPageURL();
        assertTrue(url.contains("login"));
    }

    @Given("^User enters username and password for (.+)$")
    public void loginToOpenCart(String feature) throws IOException {
        LoginPage loginPage = NavigateToLoginPage.loginPage;

        log.info("Logging in with provided credentials");
        String username = testDataUtility.getTestData(feature).get(0).toString();
        String password = testDataUtility.getTestData(feature).get(1).toString();
        loginPage.loginToAccount(username,password);

    }

    @Then("User is logged in the application")
    public void userIsLoggedInApplication(){
        System.out.println("User is logged in the application");
    }
}
