package screens;

import com.mycompany.app.DriverPoolHolder;
import com.mycompany.app.hashPool;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;

public class GoogleHomePage extends BasePage {

        private static final String url ="https://www.google.com/";

        public void open() {
                DriverPoolHolder.getDriver("chrome").get(url);
        }
        private static final String locatorSearchTextField = "//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input";
        WebElement searchTextField;
        private static final String locatorMakeHappySearchButton = "//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[2]";
        WebElement  makeHappySearchButton;
        private static final String locatorMakeSearchButton = "//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]";
        WebElement makeSearchButton;

       public void Startsearch(String textToFind){
                searchTextField = DriverPoolHolder.getDriver("chrome").findElement(By.xpath(locatorSearchTextField));
                makeSearchButton = DriverPoolHolder.getDriver("chrome").findElement(By.xpath(locatorMakeSearchButton));

                searchTextField.sendKeys(textToFind);
                makeSearchButton.click();
        }

        public void StartHappySearch(String textToFind) {
               searchTextField = DriverPoolHolder.getDriver("other").findElement(By.xpath(locatorSearchTextField));
               makeHappySearchButton = DriverPoolHolder.getDriver("otrher").findElement(By.xpath(locatorMakeHappySearchButton));

               searchTextField.sendKeys(textToFind);
               makeHappySearchButton.click();
        }


}
