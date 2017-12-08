package pages.Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utils.Properties;

public class MainPage extends BasePage{
   // private WebDriver driver;

    private By allGoods = By.partialLinkText("Все товары");
    private By img = By.className("img-fluid");
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(Properties.getShopUrl());
    }

    public boolean imgIsPresent(){
        return isElementPresent(img);
    }
    public void allGoodsClick() {
        elementVisibilityWait(allGoods);
        driver.findElement(allGoods).click();
    }
}
