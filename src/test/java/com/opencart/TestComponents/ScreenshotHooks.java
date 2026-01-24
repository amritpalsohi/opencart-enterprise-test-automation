package com.opencart.TestComponents;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

import static com.opencart.TestComponents.BaseTest.log;

public class ScreenshotHooks {

    @After(order = 100)
    public void afterScenarioAttachScreenshot(Scenario scenario){
        WebDriver driver = BaseTest.getDriver();

        //Skip API Only Scenarios
        if(driver == null){
            return;
        }

        if(driver instanceof TakesScreenshot){
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] png = ts.getScreenshotAs(OutputType.BYTES);
            log.info("Screenshot taken for "+scenario);

            //Attach to Allure report
            Allure.addAttachment("Screenshot - "
                    +scenario.getName(),"image/png",
                    new ByteArrayInputStream(png),
                    ".png");
        }

    }
}
