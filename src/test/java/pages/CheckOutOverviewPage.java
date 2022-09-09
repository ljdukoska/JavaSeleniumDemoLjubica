package pages;

import helpers.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverviewPage extends CommonActions {
    WebDriver driver;

    public CheckOutOverviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".title")
    static
    WebElement checkoutOverview;

    public static String checkOutOverviewText(){
        return checkoutOverview.getText();
    }



}
