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

    @FindBy(xpath="//*[@id=\"navbar-collapse-header\"]/div/a[1]")
    WebElement loginLink;

    @FindBy(xpath="//*[@id=\"navbar-collapse-header\"]/div/a[2]")
    WebElement registerButton;

    public void loadOpenCartApplication(String url){
        driver.get(url);
    }

    public LoginPage clickLoginLink(){
        waitForElementToAppear(loginLink);
        loginLink.click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }

    public void clickRegisterButton(){
        waitForElementToAppear(registerButton);
        registerButton.click();
    }

}
