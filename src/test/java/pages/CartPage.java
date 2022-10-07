package pages;

import helpers.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CommonActions {
    //WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#continue-shopping")
    WebElement continueShopping;
    @FindBy(css = "#checkout")
    WebElement checkOut;
    @FindBy(css = ".title")

    WebElement yourCart;

    public  String yourCartText(){
        return yourCart.getText();
    }
    public void clickCheckOutButton(){
        clickElement(checkOut);
    }
    public void clickContinueShoppingButton(){
        clickElement(continueShopping);
    }





}
