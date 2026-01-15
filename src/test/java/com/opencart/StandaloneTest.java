package com.opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.Arrays;

public class StandaloneTest {

    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver",
//                "C:\\Users\\amritpal.b.singh\\Enterprise Test Framework\\enterprise-test-automation-framework\\src\\main\\java\\org\\example\\Resources\\chromedriver-win64\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//
//        WebDriver driver = new ChromeDriver(options);
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().deleteAllCookies();
//        driver.manage().window().maximize();
//
//        driver.get("https://www.opencart.com/");

        String str1 = "iceaan";
        String str2 = "cinema";

        if(str1.length()!=str2.length()){
            System.out.println("Strings are not anagram");
        }

        char[] str1CharArray = str1.toCharArray();
        char[] str2CharArray = str2.toCharArray();

        Arrays.sort(str1CharArray);
        Arrays.sort(str2CharArray);

        if(Arrays.equals(str1CharArray, str2CharArray)){
            System.out.println("Strings are anagram");
        }else{
            System.out.println("Strings are not anagram");
        }


    }
}
