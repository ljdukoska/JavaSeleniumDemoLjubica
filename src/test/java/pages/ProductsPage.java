package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".title")
    WebElement productsTitle;
    @FindBy(css = ".shopping_cart_badge")
    WebElement cartItemNumber;

    public String getProductTitleText(){
        return productsTitle.getText();
    }

    public void addProductByName(String name){
        driver.findElement(By.xpath("//div[@class='inventory_list']/div[5]//div[text()='"+name+"']/../../..//button")).click();
    }

    public int getCartItemNumber() {
        return Integer.parseInt(cartItemNumber.getText());
    }
}