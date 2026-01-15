package com.opencart.CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/opencart/FeatureFiles",
        glue = {"com.opencart.StepDefinitions","com.opencart.TestComponents"},
        tags = "@Login",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
}
