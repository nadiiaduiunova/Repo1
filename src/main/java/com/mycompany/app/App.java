package com.mycompany.app;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://goole.com");
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(3000);
        driver.quit();

        System.out.println( "Hello World!" );
    }
}
