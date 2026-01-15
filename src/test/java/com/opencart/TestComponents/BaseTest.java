package com.opencart.TestComponents;

import com.opencart.PageObjects.LoginPage;
import com.opencart.PageObjects.unAuthLandingPage;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static unAuthLandingPage unAuthPage;

    public WebDriver InitializeDriver() throws IOException {

        Properties property = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/com/opencart/Resources/GlobalData.properties");
        property.load(fis);

        String browserName = property.getProperty("Browser");

        if(browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/java/com/opencart/Resources/chromedriver-win64/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }else if(browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/java/com/opencart/Resources/geckodriver-v0.30.0-win64/geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new FirefoxDriver(options);
        }else if(browserName.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "src/main/java/com/opencart/Resources/msedgedriver.exe");
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();


        return driver;
    }

    @Before
    public void launchApplication() throws IOException {
        Properties property = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/com/opencart/Resources/GlobalData.properties");
        property.load(fis);

        String environment = property.getProperty("Environment");

        driver = InitializeDriver();
        unAuthPage = new unAuthLandingPage(driver);

        if(environment.equalsIgnoreCase("PROD")) {
            unAuthPage.loadOpenCartApplication("https://www.opencart.com/");
        }else if(environment.equalsIgnoreCase("QA")) {
            unAuthPage.loadOpenCartApplication("test.com");
        }
    }

    public void closeDriver() {
        driver.close();
    }

}
