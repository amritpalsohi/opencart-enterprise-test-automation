package com.opencart.PageObjects;

import com.opencart.WaitComponents.WaitComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends WaitComponents {

    WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="#email")
    WebElement emailField;

    @FindBy(css="button[type='submit']")
    WebElement resetPasswordButton;

    @FindBy(css="h2[class='text-xl font-oswald mb-3 uppercase not-odd:font-bold']")
    WebElement resetPasswordSuccessMessage;

    public void enterEmail(String email){
        waitForElementToAppear(emailField);
        emailField.sendKeys(email);
    }

    public void clickOnResetPasswordButton(){
        waitForElementToAppear(emailField);
        resetPasswordButton.click();

    }

    public String validateResetPasswordMessage(){
        waitForElementToAppear(resetPasswordSuccessMessage);
        return resetPasswordSuccessMessage.getText();

    }

}
