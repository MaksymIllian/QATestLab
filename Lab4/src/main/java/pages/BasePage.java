package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected void elementWait(By by, WebDriver driver) {
        WebDriverWait goodNameWait = new WebDriverWait(driver,10);
        goodNameWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    protected void elementWait(By by) {
        WebDriverWait goodNameWait = new WebDriverWait(driver,10);
        goodNameWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
