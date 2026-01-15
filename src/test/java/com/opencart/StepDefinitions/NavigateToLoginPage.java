package com.opencart.StepDefinitions;

import com.opencart.PageObjects.LoginPage;
import com.opencart.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class NavigateToLoginPage {

    WebDriver driver;
    public static LoginPage loginPage;

    public NavigateToLoginPage() {
        // Empty constructor for PicoContainer
    }

//    public NavigateToLoginPage(WebDriver driver, LoginPage loginPage) {
//        this.driver = driver;
//        //this.loginPage = loginPage;
//    }

    @Given("Navigate to login page")
    public void navigateToLoginPage() {

        loginPage = BaseTest.unAuthPage.clickLoginLink();

    }
}
