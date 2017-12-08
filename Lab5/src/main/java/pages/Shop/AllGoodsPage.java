package pages.Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AllGoodsPage extends BasePage{

  //  private WebDriver driver;

    private String goodName;
    private String goodPrice;
    private String goodCount;
    private By search = By.className("ui-autocomplete-input");
    private By products = By.xpath("//article");
    public AllGoodsPage(WebDriver driver){
        this.driver = driver;
        this.goodName = null;
    }
    private static Integer generate(int min, int max) {
        return Math.round(ThreadLocalRandom.current().nextInt(min, max));
    }
    public void randomGoodClick(){
        elementVisibilityWait(products);
        List<WebElement> elements= driver.findElements(products);
        WebElement randomElement = elements.get(generate(0, elements.size()));
        setGoodName(randomElement.findElement(By.xpath("./*" + "//h1/a")).getText());
        setGoodPrice(randomElement.findElement(By.xpath("./*" + "//span[@class=\"price\"]")).getText().split(" ",2)[0]);

        randomElement.findElement(By.xpath("./*" + "//a")).click();
    }
    public void searchGood(){
        elementVisibilityWait(search);
        WebElement searchElement = driver.findElement(search);
        searchElement.sendKeys(this.goodName);
        searchElement.sendKeys(Keys.RETURN);
    }

    private void setGoodName(String name){
        this.goodName = name;
    }
    private void setGoodPrice(String price){
        this.goodPrice = price;
    }
    private void setGoodCount(String count){
        this.goodCount = count;
    }

    public String getGoodCount() {
        return goodCount;
    }

    public String getGoodName() {
        return goodName;
    }

    public String getGoodPrice() {
        return goodPrice;
    }

    public WebElement getGood() {
        elementVisibilityWait(By.linkText(this.goodName));
        return driver.findElement(By.linkText(this.goodName));
    }
    public void addedGoodClick() {
        elementVisibilityWait(By.linkText(this.goodName));
        driver.findElement(By.linkText(this.goodName)).click();
    }
}
