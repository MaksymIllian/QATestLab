package pages.Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.BasePage;

public class ConfirmOrderPage extends BasePage{

    private By confirmMessage = By.xpath("//h3[@class='h1 card-title']");
    private By detailsName = By.xpath("//div[@class='col-sm-4 col-xs-9 details']/span");
    private By detailsPrice = By.xpath("//div[@class='col-xs-5 text-sm-right text-xs-left']");
    private By detailsCount = By.xpath("//div[@class='col-xs-2']");
    public ConfirmOrderPage(WebDriver driver){
        this.driver = driver;
    }

    public String getDetailsName(){
        elementVisibilityWait(detailsName);
        return driver.findElement(detailsName).getText();
    }
    public String getConfirmMessage(){
        elementVisibilityWait(confirmMessage);
        WebElement message = driver.findElement(confirmMessage);
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        switch (browserName) {
            case "microsoftedge":
                return message.getText().substring(1, message.getText().length() - 1).toLowerCase();
            default:
                return message.getText().substring(1, message.getText().length()).toLowerCase();
        }
    }
    public String getDetailsPrice(){
        elementVisibilityWait(detailsPrice);
        return driver.findElement(detailsPrice).getText().split(" ")[0];
    }
    public String getDetailsCount(){
        elementVisibilityWait(detailsCount);
        return driver.findElement(detailsCount).getText();
    }
}
