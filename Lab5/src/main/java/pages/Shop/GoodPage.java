package pages.Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class GoodPage extends BasePage{
   // private WebDriver driver;

    private By goodName = By.xpath("//*[@itemprop='name' and @class='h1']");
    private By goodPrice = By.xpath("//*[@itemprop='price']");
    private By goodsCount = By.xpath("//div[@class='product-quantities']//span");
    private By cart = By.xpath("//button[@data-button-action='add-to-cart']");
    private By confirm = By.xpath("//div[@class=\"cart-content\"]//a");
    private By details = By.xpath("//a[text()='Подробнее о товаре']");
    public GoodPage(WebDriver driver){
        this.driver = driver;
    }

    public String getGoodPrice() {
        elementVisibilityWait(goodPrice);
        return driver.findElement(goodPrice).getText().split(" ")[0];
    }
    public String getGoodName() {
        elementVisibilityWait(goodName);
        return driver.findElement(goodName).getText();
    }
    public String getGoodsCount() {
        elementVisibilityWait(details);
        driver.findElement(details).click();
        elementVisibilityWait(goodsCount);
        return driver.findElement(goodsCount).getText().split(" ")[0];
    }
    public void confirmClick(){
        elementVisibilityWait(confirm);
        driver.findElement(confirm).click();
    }
    public void addToCart(){
        elementVisibilityWait(cart);
        driver.findElement(cart).click();
    }

}
