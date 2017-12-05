package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class GoodsPage extends BasePage{
    //private WebDriver driver;
    private By newGoodButton = By.id("page-header-desc-configuration-add");

    public GoodsPage(WebDriver driver) {
       this.driver = driver;
    }

    public void newGoodButtonClick(){
        elementWait(newGoodButton);
        driver.findElement(newGoodButton).click();
    }
}
