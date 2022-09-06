package steps;

import excel.ExcelUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import pages.GooglePage;
import pages.LoginPage;
import pages.ProductsPage;
import tests.BaseTest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class BaseSteps extends BaseTest {

    Map<String, String> data;

    @Before
    public void setup() throws Exception {
        init("CHROME",30);
    }

    @After
    public void tearDown(){
//        quit();
    }

    @Given("I am on Sauce Demo Login Page")
    public void iAmOnSauceDemoLoginPage() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
    }

    @And("I enter username")
    public void iEnterUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(data.get("Username"));
    }
    @And("I enter username {string}")
    public void iEnterUsername(String username) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
    }

    @And("I enter password")
    public void iEnterPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword(data.get("Password"));
    }
    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPassword(password);
    }

    @When("I click login button")
    public void iClickLoginButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
    }

    @Then("I should be on Inventory page")
    public void iShouldBeOnInventoryPage() throws IOException {
        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(productsPage.getProductTitleText(), "PRODUCTS");

        reporterScreenshot("Inventory_"+System.currentTimeMillis(), "Inventory page screenshot");
    }

    @And("I should see an error message on login")
    public void iShouldSeeAnErrorMessage() {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertEquals(loginPage.getLoginErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @And("I entered test data in Excel {string} {string} {string}")
    public void iEnteredTestDataInExcel(String file, String sheet, String rowNum) throws IOException {
        data = new ExcelUtilities().getRowData("src/test/java/test_data/"+file+".xlsx",sheet,Integer.parseInt(rowNum));
    }


    public void takeScreenshot(String fileName) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/screenshots/"+fileName+".png"));
    }

    public void reporterScreenshot(String name, String desc) throws IOException {
        takeScreenshot(name);
        Path content = Paths.get("src/tests/screenshots/"+name+".png");
        try(InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment(desc,is);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @And("I add a product {string}")
    public void iAddAProduct(String productName) {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductByName(productName);
    }

    @And("I verify cart number icon {string}")
    public void iVerifyCartNumberIcon(String num) throws IOException {
        ProductsPage productsPage = new ProductsPage(driver);

        Assert.assertEquals(productsPage.getCartItemNumber(), Integer.parseInt(num));
        takeScreenshot("test");
    }
}
