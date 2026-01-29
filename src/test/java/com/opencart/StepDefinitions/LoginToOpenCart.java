package com.opencart.StepDefinitions;

import com.opencart.PageObjects.LoginPage;
import com.opencart.Resources.TestDataUtility;
import com.opencart.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

import static com.opencart.TestComponents.BaseTest.log;
import static org.testng.Assert.assertTrue;


public class LoginToOpenCart {

    TestDataUtility testDataUtility = new TestDataUtility();
    LoginPage loginPage = NavigateToLoginPage.loginPage;

    @Given("User is landed on login page")
    public void userIsLandedOnLoginPage() {

        String url= loginPage.getPageURL();
        assertTrue(url.contains("practice"));
    }

    @Given("^User enters username and password for (.+)$")
    public void loginToOpenCart(String feature) throws IOException {
        //LoginPage loginPage = NavigateToLoginPage.loginPage;

        log.info("Logging in with provided credentials");
        String username = testDataUtility.getTestData(feature).get(0).toString();
        String password = testDataUtility.getTestData(feature).get(1).toString();
        loginPage.loginToAccount(username,password);
        log.info("Clicked on login button");

    }

    @Then("User is logged in the application")
    public void userIsLoggedInApplication(){
        String loginMessage = loginPage.validateLoginSuccessMessage();
        log.info("Login message is: " + loginMessage);
        Assert.assertEquals(loginMessage,"LOGIN SUCCESSFUL");
    }
}
