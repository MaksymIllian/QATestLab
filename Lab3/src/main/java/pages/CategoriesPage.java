package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesPage {
    private WebDriver driver;

    private By add = By.className("process-icon-new");
    private By success = By.className("alert");
    private By filterByName = By.xpath("//th[contains(.,'Имя')]//i[@class='icon-caret-up']");
    public CategoriesPage(WebDriver driver){
        this.driver = driver;
    }

    public void addBtnClick(){
        WebDriverWait addBtnWait = new WebDriverWait(driver,5);
        addBtnWait.until(ExpectedConditions.visibilityOfElementLocated(add));
        driver.findElement(add).click();
    }
    public void addingComplete(){
        WebDriverWait successWait = new WebDriverWait(driver,5);
        successWait.until(ExpectedConditions.visibilityOfElementLocated(success));
        System.out.println(driver.findElement(success).getText());
    }

    public void filteringByName(String name){
        // //th/span/a/i[@class='icon-caret-up']
        driver.findElement(filterByName).click();
        WebDriverWait filteringWait = new WebDriverWait(driver,5);
        filteringWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(.,"+name+")]")));
        System.out.println("filtering complete!!");
    }
}
