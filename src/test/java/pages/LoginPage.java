package pages;

import excel.ExcelUtilities;
import helpers.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class LoginPage {

    WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(css = "#user-name")
    WebElement username;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement loginButton;
    @FindBy(css = "[data-test=\"error\"]")
    WebElement loginErrorMessage;



    public void enterUsername(String value){

        username.sendKeys(value);
    }

    public void enterPassword(String value){
        password.sendKeys(value);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
            }



    public String getLoginErrorMessage(){
        return loginErrorMessage.getText();
    }


}