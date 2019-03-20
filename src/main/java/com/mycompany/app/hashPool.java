package com.mycompany.app;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class hashPool {
    private static WebDriver firefoxInstance;
    private static WebDriver chromeInstance;
    private static HashMap <String, WebDriver> Session = new HashMap<String, WebDriver>();

    public synchronized static WebDriver getDriver(String expectedDriverName) throws Exception {
        WebDriver result = null;
        if (expectedDriverName.equalsIgnoreCase("chrome")) {
            if (chromeInstance == null) {
                WebDriverManager.chromedriver().version("73").setup();
                chromeInstance = new ChromeDriver();
            }
            result = chromeInstance;
        } else if (expectedDriverName.equalsIgnoreCase("FIREFOX")) {
            if (firefoxInstance == null) {
                WebDriverManager.firefoxdriver().arch32().setup();
                firefoxInstance = new FirefoxDriver();
            }
            result = firefoxInstance;
        } else if (expectedDriverName.equalsIgnoreCase("other")) {
            if (Session.get(expectedDriverName) == null) {
                WebDriverManager.chromedriver().version("73").setup();
                ChromeOptions options =  new ChromeOptions();
                options.addArguments("start-maximized");
                result = new ChromeDriver(options);

                if(expectedDriverName.contains("slow")) {
                    result.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                    result.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                    result.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
                }
                Session.put(expectedDriverName, result);
            }
            result = Session.get(expectedDriverName);
        }

        else {
            throw new Exception("unable to recognize expectedDriver's name " + expectedDriverName);
        }
        return result;
    }

    public static void resetSession(String expectedDriverName) throws Exception {
        if (expectedDriverName.equalsIgnoreCase("firefox")) {
            if (chromeInstance != null) {
                chromeInstance.quit();
            } else if (firefoxInstance != null) {
                firefoxInstance.quit();
            }

            else {
                throw new Exception("unable to recognize expectedDriver's name " + expectedDriverName);
            }

        }

    }
}
