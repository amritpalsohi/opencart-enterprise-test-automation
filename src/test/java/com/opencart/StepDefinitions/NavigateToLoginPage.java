package com.opencart.StepDefinitions;

import com.opencart.PageObjects.LoginPage;
import com.opencart.TestComponents.BaseTest;

public class NavigateToLoginPage extends BaseTest{

    public static LoginPage loginPage;

    public void navigateToLoginPage() {

        loginPage = unAuthPage.clickLoginLink();

    }
}
