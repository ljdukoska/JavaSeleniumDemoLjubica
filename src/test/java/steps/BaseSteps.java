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
import pages.*;
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
        quit();
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

    @When("I click cart button")
    public void iClickCartButton() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickShoppingCartLink();
    }

    @And("I should be on Cart page")
    public void iShouldBeOnCartPage() throws IOException {
        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(CartPage.yourCartText(),"YOUR CART");
        takeScreenshot("test2");
    }
    @When("I click Continue Shopping button")
    public void iClickContinueShoppingButton() {
        CartPage cartPage = new CartPage(driver);
        cartPage.clickContinueShoppingButton();
    }
    @When("I click CheckOut button")
    public void iClickCheckOutButton() {
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckOutButton();
    }

    @And("I should be on CheckOut page")
    public void iShouldBeOnCheckOutPage() throws IOException {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        Assert.assertEquals(CheckOutPage.yourInformationText(), "CHECKOUT: YOUR INFORMATION");
        takeScreenshot("test3");
    }

    @And ("I click Cancel button")
    public void iClickCancelButton() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.clickCancelButton();
    }

    @And ("I enter First Name {string}")
    public void iEnterFirstName(String firstName) {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterFirstName(firstName);
    }

    @And ("I enter Last Name {string}")
    public void iEnterLastName(String lastName) {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterLastName(lastName);
    }

    @And ("I enter Postal Code {string}")
    public void iEnterPostalCode(String postalCode) {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterPostalCode(postalCode);
    }
    @And ("I click Continue button")
    public void iClickContinueButton() {
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.clickContinueButton();
    }
    @And("I should be on CheckOut Overview page")
    public void iShouldBeOnCheckOutOverviewPage() throws IOException {
        CheckOutOverviewPage checkOutOverviewPage = new CheckOutOverviewPage(driver);
        Assert.assertEquals(CheckOutOverviewPage.checkOutOverviewText(), "CHECKOUT: OVERVIEW");
        takeScreenshot("test3");
    }

}
