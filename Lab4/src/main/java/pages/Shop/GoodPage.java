package pages.Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoodPage {
    private WebDriver driver;

    private By goodName = By.xpath("//*[@itemprop='name' and @class='h1']");
    private By goodPrice = By.xpath("//*[@itemprop='price']");
    private By goodCount = By.xpath("//div[@class='product-quantities']//span");
    public GoodPage(WebDriver driver){
        this.driver = driver;
    }

    public String getGoodPrice() {
        return driver.findElement(goodPrice).getAttribute("content");
    }
    public String getGoodName() {
        return driver.findElement(goodName).getText();
    }
    public String getGoodCount() {
        return driver.findElement(goodName).getText();
    }
}
