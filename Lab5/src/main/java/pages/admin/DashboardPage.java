package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

public class DashboardPage extends BasePage {
   // private WebDriver driver;

    private By catalog = By.xpath(".//*[@id='subtab-AdminCatalog']/a");
    private By categories = By.partialLinkText("категории");
    private By goods = By.partialLinkText("товары");
    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public void moveToCatalog(){
        elementVisibilityWait(catalog);
        Actions moveAction = new Actions(driver);
        moveAction.moveToElement(driver.findElement(catalog)).build().perform();
    }
    public void categoriesClick(){
        elementVisibilityWait(categories);
        driver.findElement(categories).click();
    }

    public void goodsClick(){
        elementVisibilityWait(goods);
        driver.findElement(goods).click();
    }
}
