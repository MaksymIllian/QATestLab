package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public abstract class BasePage {
    protected WebDriver driver;
    protected void elementVisibilityWait(By by, WebDriver driver) {
        WebDriverWait goodNameWait = new WebDriverWait(driver,10);
        goodNameWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    protected void elementVisibilityWait(By by) {
        WebDriverWait goodNameWait = new WebDriverWait(driver,10);
        goodNameWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    protected void elementClickableWait(By by) {
        WebDriverWait goodNameWait = new WebDriverWait(driver,10);
        goodNameWait.until(ExpectedConditions.elementToBeClickable(by));
    }
    protected void fillInput(By element, String data)
    {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(data);
    }
    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
