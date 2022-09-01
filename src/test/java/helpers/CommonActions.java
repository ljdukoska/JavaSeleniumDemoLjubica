package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {

    WebDriver driver;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element, String log){
        WebDriverWait wdWait = new WebDriverWait(driver,30);
        wdWait.until(ExpectedConditions.elementToBeClickable(element));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        System.out.println("Clicked element: "+log);
    }

    public void clickElement(WebElement element){
        WebDriverWait wdWait = new WebDriverWait(driver,30);
        wdWait.until(ExpectedConditions.elementToBeClickable(element));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public void typeText(WebElement element, String text, String log){
        WebDriverWait wdWait = new WebDriverWait(driver,30);
        wdWait.until(ExpectedConditions.elementToBeClickable(element));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        element.clear();
        element.sendKeys(text);

        System.out.println("Typed text: "+text+" to element: "+log);
    }

    public void typeText(WebElement element, String text){
        WebDriverWait wdWait = new WebDriverWait(driver,30);
        wdWait.until(ExpectedConditions.elementToBeClickable(element));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        element.clear();
        element.sendKeys(text);
    }
}
