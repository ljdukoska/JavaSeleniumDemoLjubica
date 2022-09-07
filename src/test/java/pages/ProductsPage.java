package pages;

import helpers.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends CommonActions {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".title")
    WebElement productsTitle;
    @FindBy(css = ".shopping_cart_badge")
    WebElement cartItemNumber;

    @FindBy(css = ".shopping_cart_link")
    WebElement shoppingCartLink;



    public void clickShoppingCartLink(){
        clickElement(shoppingCartLink);
    }


    public String getProductTitleText(){
        return productsTitle.getText();
    }

    public void addProductByName(String name){
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
    }

    public int getCartItemNumber() {
        return Integer.parseInt(cartItemNumber.getText());
    }
}