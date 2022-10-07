package pages;

import helpers.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverviewPage extends CommonActions {
    //WebDriver driver;

    public CheckOutOverviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".title")

    WebElement checkoutOverview;

    public  String checkOutOverviewText(){
        return checkoutOverview.getText();
    }



}
