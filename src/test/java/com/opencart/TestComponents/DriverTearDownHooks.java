package com.opencart.TestComponents;

import io.cucumber.java.After;

public class DriverTearDownHooks {

    @After(order = 10)
    public void tearDown(){
        BaseTest.closeDriver();
    }

}
