package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoodsPage {
    private WebDriver driver;
    private By newGoodButton = By.id("page-header-desc-configuration-add");

    public GoodsPage(WebDriver driver) {
       this.driver = driver;
    }

    public void newGoodButtonClick(){
        driver.findElement(newGoodButton).click();
    }
}
