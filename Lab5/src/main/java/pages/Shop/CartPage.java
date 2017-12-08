package pages.Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CartPage extends BasePage {

    private By confirm = By.xpath("//div[@class=\"text-xs-center\"]");
    private By goodName = By.xpath("//a[@class=\"label\"]");
    private By goodPrice = By.xpath("//span[@class=\"value\"]");
    private By goodsCount = By.xpath("//div[@id=\"cart-subtotal-products\"]/span");
    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    public void confirmClick(){
        elementVisibilityWait(confirm);
        driver.findElement(confirm).click();
    }

    public String getGoodName() {
        elementVisibilityWait(goodName);
        return driver.findElement(goodName).getText().toLowerCase();
    }
    public String getGoodPrice() {
        elementVisibilityWait(goodPrice);
        return driver.findElement(goodPrice).getText().split(" ")[0];
    }
    public String getGoodsCount() {
        elementVisibilityWait(goodsCount);
        return driver.findElement(goodsCount).getText().split(" ")[0];
    }
}
