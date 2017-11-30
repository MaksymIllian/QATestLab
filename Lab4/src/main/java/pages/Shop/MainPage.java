package pages.Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Properties;

public class MainPage {
    private WebDriver driver;

    private By allGoods = By.partialLinkText("Все товары");
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(Properties.getShopUrl());
    }

    public void allGoodsClick() {
        WebDriverWait allGoodsWait = new WebDriverWait(driver,5);
        allGoodsWait.until(ExpectedConditions.visibilityOfElementLocated(allGoods));
        driver.findElement(allGoods).click();
    }
}
