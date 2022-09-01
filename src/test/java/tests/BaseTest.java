package tests;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    DriverManager driverManager;

    public void init(String browser, int wait) throws Exception {
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
    }

    public void quit(){
        driverManager.quitWebDriver();
    }

    public void takeScreenshot(String name) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/results/screenshots/"+name+".png"));
    }

    public void reportScreenshot(String name, String desc) throws IOException {
        takeScreenshot(name);
        Path content = Paths.get("src/results/screenshots/"+name+".png");
        InputStream is = Files.newInputStream(content);
        Allure.addAttachment(desc,is);
    }

    public void assertEqualsText(WebElement element, String expected, String log) throws IOException {
        scrollToElement(element);
        reportScreenshot("Assert","Expected: "+expected+" Actual: "+element.getText());
        Assert.assertEquals(element.getText(),expected,log);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",element);
    }

}
