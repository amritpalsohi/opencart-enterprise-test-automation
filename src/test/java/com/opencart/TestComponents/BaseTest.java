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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    private static final ThreadLocal<unAuthLandingPage> UNAUTH_PAGE = new ThreadLocal<>();

    public static final Logger log = LogManager.getLogger(BaseTest.class);

    public static WebDriver getDriver(){
        return DRIVER.get();
    }

    public static unAuthLandingPage getUnAuthPage(){
        return UNAUTH_PAGE.get();
    }

    public static WebDriver InitializeDriver() throws IOException {

        Properties property = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/com/opencart/Resources/GlobalData.properties");
        property.load(fis);

        String browserName = property.getProperty("Browser");

        log.info("Initializing driver based on browser configuration");
        WebDriver driver;
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
        }else{
            log.error("Browser not supported");
            throw new IllegalArgumentException("Browser not supported: " + browserName);

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        DRIVER.set(driver);
        return driver;
    }

    @Before
    public static void launchApplication() throws IOException {
        Properties property = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/com/opencart/Resources/GlobalData.properties");
        property.load(fis);

        String environment = property.getProperty("Environment");

        WebDriver driver = InitializeDriver();
        UNAUTH_PAGE.set(new unAuthLandingPage(driver));

        log.info("Launching application based on environment configuration");
        if(environment.equalsIgnoreCase("PROD")) {
            UNAUTH_PAGE.get().loadOpenCartApplication("https://www.opencart.com/");
        }else if(environment.equalsIgnoreCase("QA")) {
            UNAUTH_PAGE.get().loadOpenCartApplication("test.com");
        }else{
            log.error("Environment not supported");
            throw new IllegalArgumentException("Environment not supported: " + environment);
        }
    }

    public static void closeDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            driver.quit();
        }
        DRIVER.remove();
        UNAUTH_PAGE.remove();
    }

}
