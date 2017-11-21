package tests;

import Log.WebDriverLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.AddPage;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by User on 15.11.2017.
 */
public class Tests extends BaseTest {

    private static void login(WebDriver driver){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.fillEmailInput();
        loginPage.fillPasswordInput();
        loginPage.submit();
    }

    private static List<String> getMenuElements(WebDriver driver){
        List<WebElement> menu= driver.findElements(By.className("maintab"));
        List<String> menuElements = new ArrayList<String>();
        for (WebElement element:
                menu) {
            String e = element.getText();
            menuElements.add(e);
        }
        return menuElements;
    }
    private static String generateName(){
        Random rName = new Random();
        return Double.toString(rName.nextDouble());
    }
    private static void test1(WebDriver driver){
        login(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.moveToCatalog();
        dashboardPage.categoriesClick();

        CategoriesPage categoriesPage = new CategoriesPage(driver);
        categoriesPage.addBtnClick();

        String nameInput = generateName();
        AddPage addPage = new AddPage(driver);
        addPage.fillNameInput(nameInput);
        addPage.submit();

//        categoriesPage = new CategoriesPage(driver);
        categoriesPage.addingComplete();
        categoriesPage.filteringByName(nameInput);


    }
    public static void main(String[] args) {
        WebDriver driver = getConfiguredDriver();
        EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
        WebDriverLogger logger = new WebDriverLogger();
        e_driver.register(logger);
        test1(e_driver);
        quiteDriver(e_driver);

    }
}
