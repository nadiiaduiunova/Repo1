package screens;

import com.mycompany.app.DriverPoolHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public boolean textAvailable (String textAvailable){
        boolean res = false;
        try {
            sleep(1000);
            String xpath1 = "//*[contains(@value,'" + textAvailable + "')]";
            String xpath2 = "//*[contains(@label,'" + textAvailable + "')]";
            String xpath3 = "//*[contains(@name,'" + textAvailable + "')]";
            String xpath4 = "//*[contains(text(),'" + textAvailable + "')]";
            String finalXPath = xpath1 + " | " + xpath2 + " | " + xpath3 + " | " + xpath4;
            WebDriverWait wait = new WebDriverWait(DriverPoolHolder.getDriver("OTHER"), 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(finalXPath)));

            System.out.println("Text found: " + textAvailable);
            res = true;
        }catch(Exception e) {
            System.out.println("Text not found: " + textAvailable);
        }

        return res;
    }

    public static void sleep (long timeMillis) {
        try {
            Thread.sleep(timeMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
