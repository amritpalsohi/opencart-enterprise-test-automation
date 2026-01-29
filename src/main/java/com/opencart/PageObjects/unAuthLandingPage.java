package com.opencart.PageObjects;

import com.opencart.WaitComponents.WaitComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class unAuthLandingPage extends WaitComponents {

    WebDriver driver;

    public unAuthLandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="li[id='login'] span[class='text flex-1']")
    WebElement loginLink;

    @FindBy(css="li[id='registration'] span[class='text flex-1']")
    WebElement registerLink;

    @FindBy(css="li[id='forgot-password'] span[class='text flex-1']")
    WebElement forgotPasswordLink;

    public void loadOpenCartApplication(String url){
        driver.get(url);
    }

    public LoginPage clickLoginLink(){
        waitForElementToAppear(loginLink);
        loginLink.click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }

    public void clickRegisterLink(){
        waitForElementToAppear(registerLink);
        registerLink.click();
    }

    public ForgotPasswordPage forgotPasswordLink(){
        waitForElementToAppear(forgotPasswordLink);
        forgotPasswordLink.click();
        ForgotPasswordPage forgotPassword = new ForgotPasswordPage(driver);
        return forgotPassword;
    }

}
