package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class NewGoodPage extends BasePage{
   // private WebDriver driver;
    private By goodName = By.id("form_step1_name_1");
    private By goodPrice = By.id("form_step1_price_shortcut");
    private By goodCount = By.id("form_step1_qty_0_shortcut");
    private By message = By.className("growl-message");
    private By saveButton = By.xpath("//input[@id='submit']");
    private By switchButton = By.className("switch-input");
    public NewGoodPage(WebDriver driver) {
        this.driver = driver;
    }


    public void fillGoodName(String name){
        elementWait(goodName, driver);
        driver.findElement(goodName).sendKeys(name);
    }

    public void fillGoodPrice(String price){
        elementWait(goodName, driver);
        WebElement priceElement = driver.findElement(goodPrice);
        priceElement.clear();
        priceElement.sendKeys(price);
    }

    public void fillGoodCount(String count){
        elementWait(goodCount, driver);
        WebElement countElement = driver.findElement(goodCount);
        countElement.clear();
        countElement.sendKeys(count);
    }

    public void switchButtonClick(){
        elementWait(switchButton, driver);
        driver.findElement(switchButton).click();
        elementWait(message, driver);
    }

    public void saveButtonClick(){
        driver.findElement(saveButton).click();
        elementWait(message, driver);
    }
}
