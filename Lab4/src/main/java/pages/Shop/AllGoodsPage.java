package pages.Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AllGoodsPage {

    private WebDriver driver;

    private String goodName;
    private By search = By.className("ui-autocomplete-input");
    public AllGoodsPage(WebDriver driver){
        this.driver = driver;
        this.goodName = null;
    }

    public void searchGood(){
        WebElement searchElement = driver.findElement(search);
        searchElement.sendKeys(this.goodName);
        searchElement.sendKeys(Keys.RETURN);
    }
    public void setGoodName(String name){
        this.goodName = name;
    }
    public WebElement getGood() {
        return driver.findElement(By.linkText(this.goodName));
    }
    public void addedGoodClick() {
        WebDriverWait allGoodsWait = new WebDriverWait(driver,5);
        allGoodsWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(this.goodName)));
        driver.findElement(By.linkText(this.goodName)).click();
    }
}
