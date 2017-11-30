package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewGoodPage {
    private WebDriver driver;
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
        driver.findElement(goodName).sendKeys(name);
    }

    public void fillGoodPrice(String price){
        WebElement priceElement = driver.findElement(goodPrice);
        priceElement.clear();
        priceElement.sendKeys(price);
    }

    public void fillGoodCount(String count){
        WebElement countElement = driver.findElement(goodCount);
        countElement.clear();
        countElement.sendKeys(count);
    }

    public void switchButtonClick(){
        WebDriverWait switchButtonWait = new WebDriverWait(driver,10);
        switchButtonWait.until(ExpectedConditions.visibilityOfElementLocated(switchButton));
        driver.findElement(switchButton).click();
    }

    public void saveButtonClick(){
        WebDriverWait saveButtonWait = new WebDriverWait(driver,10);
        saveButtonWait.until(ExpectedConditions.visibilityOfElementLocated(message));
        driver.findElement(saveButton).click();
        saveButtonWait.until(ExpectedConditions.visibilityOfElementLocated(message));
    }
}
