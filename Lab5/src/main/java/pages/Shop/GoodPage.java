package pages.Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class GoodPage extends BasePage{
   // private WebDriver driver;

    private By goodName = By.xpath("//*[@itemprop='name' and @class='h1']");
    private By goodPrice = By.xpath("//*[@itemprop='price']");
    private By goodsCount = By.xpath("//div[@class='product-quantities']//span");
    public GoodPage(WebDriver driver){
        this.driver = driver;
    }

    public String getGoodPrice() {
        elementWait(goodPrice);
        return driver.findElement(goodPrice).getAttribute("content");
    }
    public String getGoodName() {
        elementWait(goodName);
        return driver.findElement(goodName).getText();
    }
    public String getGoodsCount() {
        elementWait(goodsCount);
        return driver.findElement(goodsCount).getText().split(" ",2)[0];
    }
}
