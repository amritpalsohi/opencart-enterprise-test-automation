package com.opencart.PageObjects;

import com.opencart.WaitComponents.WaitComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends WaitComponents {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="input-email")
    WebElement emailField;

    @FindBy(id="input-password")
    WebElement passwordField;

    @FindBy(xpath="//button[@class='btn btn-primary btn-lg hidden-xs']")
    WebElement loginButton;

    @FindBy(xpath="//a[@class='btn-link']")
    WebElement forgotPasswordLink;

    public void loginToAccount(String email, String password){
        waitForElementToAppear(emailField);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }
}
