package com.opencart.StepDefinitions;

import com.opencart.PageObjects.ForgotPasswordPage;
import com.opencart.PageObjects.LoginPage;
import com.opencart.PageObjects.unAuthLandingPage;
import com.opencart.Resources.TestDataUtility;
import com.opencart.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

import static com.opencart.TestComponents.BaseTest.log;
import static org.testng.Assert.assertTrue;


public class ForgotPassword {

    TestDataUtility testDataUtility = new TestDataUtility();
    ForgotPasswordPage forgotPassword;

    @Given("User is landed on Unauth page")
    public void userIsLandedOnUnauthPage() {
        //Empty as it will be taken care by BaseTest class
    }

    @When("User clicks on Forgot Password Link")
    public void userClicksOnForgotPasswordLink() {
        forgotPassword = BaseTest.getUnAuthPage().forgotPasswordLink();
    }

    @When("^User enters username and click reset password for (.+)$")
    public void resetPassword(String feature) throws IOException {
        log.info("Entering email address for reset password:");
        String username = testDataUtility.getTestData(feature).get(0).toString();
        forgotPassword.enterEmail(username);
        forgotPassword.clickOnResetPasswordButton();
    }

    @Then("Password Notification has been sent to email")
    public void validatePasswordResetMessage(){
        String passwordResetMessage = forgotPassword.validateResetPasswordMessage();
        log.info("Login message is: " + passwordResetMessage);
        Assert.assertEquals(passwordResetMessage,"CHECK EMAIL");
    }
}
