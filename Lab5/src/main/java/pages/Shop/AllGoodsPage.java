package pages.Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;

public class AllGoodsPage extends BasePage{

  //  private WebDriver driver;

    private String goodName;
    private By search = By.className("ui-autocomplete-input");
    public AllGoodsPage(WebDriver driver){
        this.driver = driver;
        this.goodName = null;
    }
    public void searchGood(){
        elementWait(search);
        WebElement searchElement = driver.findElement(search);
        searchElement.sendKeys(this.goodName);
        searchElement.sendKeys(Keys.RETURN);
    }
    public void setGoodName(String name){
        this.goodName = name;
    }
    public WebElement getGood() {
        elementWait(By.linkText(this.goodName));
        return driver.findElement(By.linkText(this.goodName));
    }
    public void addedGoodClick() {
        elementWait(By.linkText(this.goodName));
        driver.findElement(By.linkText(this.goodName)).click();
    }
}
