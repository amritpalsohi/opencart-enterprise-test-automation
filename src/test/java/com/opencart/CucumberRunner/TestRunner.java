package com.opencart.CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/opencart/FeatureFiles",
        glue = {"com.opencart.StepDefinitions"},
        tags = "@RegressionTest",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests{
}
