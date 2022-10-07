package pages;

import helpers.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends CommonActions {
   // WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".title")
    static
    WebElement yourInformation;
    @FindBy(css = "#first-name")
    WebElement firstName;
    @FindBy(css = "#last-name")
    WebElement lastName;
    @FindBy(css = "#postal-code")
    WebElement postalCode;
    @FindBy(css = "#cancel")
    WebElement cancelButton;
    @FindBy(css = "#continue")
    WebElement continueButton;


    public void enterFirstName(String value){

        typeText(firstName,value);
    }
    public void enterLastName(String value){

        typeText(lastName,value);
    }
    public void enterPostalCode(String value){

        typeText(postalCode,value);
    }


    public void clickCancelButton(){
        clickElement(cancelButton);
    }
    public void clickContinueButton(){
        clickElement(continueButton);
    }

    public static String yourInformationText(){
        return yourInformation.getText();
    }



}
