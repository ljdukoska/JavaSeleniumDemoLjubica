package tests;

import excel.ExcelUtilities;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import java.io.IOException;
import java.util.Map;

public class SearchGoogleTests extends BaseTest{
    @BeforeMethod
    public void setup() throws Exception {
        init("CHROME",30);
    }

    @AfterMethod
    public void tearDown(){
        quit();
    }


    @Test(description = "Login")
    @Feature("SauceDemo Login")
    @Story("I log in to Sauce Demo with valid credentials in row \"<row>\"")

    public void sauceDemoLogin() throws InterruptedException, IOException {
        //TestNG test
        driver.get("https://saucedemo.com/");
        Map<String,String> data = new ExcelUtilities().getRowData("src/test/java/test_data/SauceDemo.xlsx","Data", Integer.parseInt("0"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(data.get("Username"));
        loginPage.enterPassword(data.get("Password"));
        loginPage.clickLoginButton();
        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(productsPage.getProductTitleText(), "PRODUCTS");

        reporterScreenshot("Inventory_"+System.currentTimeMillis(), "Inventory page screenshot");

    }

}
