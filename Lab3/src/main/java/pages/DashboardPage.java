package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriver driver;

    private By catalog = By.linkText("Каталог");
    private By categories = By.linkText("категории");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public void moveToCatalog(){
        WebDriverWait catalogWait = new WebDriverWait(driver,5);
        catalogWait.until(ExpectedConditions.visibilityOfElementLocated(catalog));
        Actions moveAction = new Actions(driver);
        moveAction.moveToElement(driver.findElement(catalog)).build().perform();
    }
    public void categoriesClick(){
        WebDriverWait categoriesWait = new WebDriverWait(driver,10);
        categoriesWait.until(ExpectedConditions.visibilityOfElementLocated(categories));
        driver.findElement(categories).click();
    }
}
