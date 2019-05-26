package com.mycompany.app;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverPoolHolder {
    private static WebDriver firefoxInstance;
    private static WebDriver chromeInstance;

    public synchronized static WebDriver getDriver(String expectedDriverName)  {
        WebDriver result = null;
        if (expectedDriverName.equalsIgnoreCase("chrome")) {
            if (chromeInstance == null) {
                WebDriverManager.chromedriver().version("74").setup();
                chromeInstance = new ChromeDriver();
            }
            result = chromeInstance;
        } else if (expectedDriverName.equalsIgnoreCase("FIREFOX")) {
            if (firefoxInstance == null) {
                WebDriverManager.firefoxdriver().arch32().setup();
                firefoxInstance = new FirefoxDriver();
            }
            result = firefoxInstance;
        } else {
            //throw new Exception("unable to recognize expectedDriver's name " + expectedDriverName);
        }
        return result;
    }

    public static void resetSession(String expectedDriverName) throws Exception {
        if (expectedDriverName.equalsIgnoreCase("chrome")) {
            if (chromeInstance != null) {
                chromeInstance.quit();
            } else if (firefoxInstance != null) {
                firefoxInstance.quit();
            } else {
                throw new Exception("unable to recognize expectedDriver's name " + expectedDriverName);
            }

        }

    }
}
