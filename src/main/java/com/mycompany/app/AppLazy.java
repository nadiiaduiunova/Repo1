package com.mycompany.app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import screens.GoogleHomePage;

public class AppLazy {

    public static void main( String[] args ) throws Exception {

        WebDriverManager.chromedriver().setup();

        GoogleHomePage homePage = new GoogleHomePage();

        homePage.open();
        homePage.Startsearch("dfjkbvjfbkjf");
        //homePage.sleep(5000);
        homePage.textAvailable("hello");

        DriverPoolHolder.resetSession("Chrome");
        System.out.println( "Hello World!" );

    }
}