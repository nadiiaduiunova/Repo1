package com.mycompany.app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

public class AppLazy {
    public static void main( String[] args ) throws Exception {
        hashPool.getDriver("other").get("https://ua.fm");
        String title = hashPool.getDriver("other").getTitle();
        hashPool.getDriver("other").findElement(By.xpath("/html/body/div/div[5]/center/a/font")).click();

        System.out.println(title);

        hashPool.resetSession("Chrome");
        System.out.println( "Hello World!" );

    }
}