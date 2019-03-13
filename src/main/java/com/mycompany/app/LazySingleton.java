package com.mycompany.app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHolder {
    private static WebDriver storedDriver;
    public static WebDriver getDriver() {
        if (storedDriver == null) {
            WebDriverManager.chromedriver().setup();
            storedDriver = new ChromeDriver();
        }
        return storedDriver;
    }
    public static void resetSession() {
        storedDriver.quit();
        storedDriver = null;
    }
}
