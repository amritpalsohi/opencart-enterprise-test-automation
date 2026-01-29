package com.opencart.TestComponents;

import com.opencart.PageObjects.LoginPage;
import com.opencart.PageObjects.unAuthLandingPage;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
        boolean isHeadless = "true".equalsIgnoreCase(property.getProperty("Headless"));
        boolean isRemote = "true".equalsIgnoreCase(property.getProperty("Remote"));
        String remoteUrl = property.getProperty("RemoteUrl", "http://localhost:4444");

        log.info("Initializing driver based on browser configuration");
        WebDriver driver;
        if(browserName.equalsIgnoreCase("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--window-size=1280,800");
            if(isHeadless){
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--force-device-scale-factor=1");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }else{
                options.addArguments("--start-maximized");
            }
            if (isRemote) {
                driver = buildRemoteDriver(options, remoteUrl);
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
            }
        }else if(browserName.equalsIgnoreCase("Firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--remote-allow-origins=*");
            if (isHeadless) {
                options.addArguments("-headless");
            }
            if (isRemote) {
                driver = buildRemoteDriver(options, remoteUrl);
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(options);
            }
        }else if(browserName.equalsIgnoreCase("Edge")) {
            EdgeOptions options = new EdgeOptions();
            if (isHeadless) {
                options.addArguments("headless");
            }
            if (isRemote) {
                driver = buildRemoteDriver(options, remoteUrl);
            } else {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(options);
            }
        }else{
            log.error("Browser not supported");
            throw new IllegalArgumentException("Browser not supported: " + browserName);

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();

        DRIVER.set(driver);
        return driver;
    }

    private static RemoteWebDriver buildRemoteDriver(org.openqa.selenium.Capabilities options, String remoteUrl) {
        try {
            return new RemoteWebDriver(new URL(remoteUrl), options);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid RemoteUrl: " + remoteUrl, e);
        }
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
            UNAUTH_PAGE.get().loadOpenCartApplication("https://practice.qabrains.com/");
        }else if(environment.equalsIgnoreCase("QA")) {
            UNAUTH_PAGE.get().loadOpenCartApplication("https://practice.qabrains.com/");
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
