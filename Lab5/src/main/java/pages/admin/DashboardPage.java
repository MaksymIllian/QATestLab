package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class DashboardPage extends BasePage {
   // private WebDriver driver;

    private By catalog = By.xpath(".//*[@id='subtab-AdminCatalog']/a");
    private By categories = By.partialLinkText("категории");
    private By goods = By.partialLinkText("товары");;
    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public void moveToCatalog(){
        elementWait(catalog);
        Actions moveAction = new Actions(driver);
        moveAction.moveToElement(driver.findElement(catalog)).build().perform();
    }
    public void categoriesClick(){
        elementWait(categories);
        driver.findElement(categories).click();
    }
    public void goodsClick(){
        elementWait(goods);
        driver.findElement(goods).click();
    }
}
