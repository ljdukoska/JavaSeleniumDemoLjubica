package steps;

import excel.ExcelUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;
import tests.BaseTest;

import java.io.IOException;
import java.util.Map;

public class BaseSteps extends BaseTest {

    Map<String, String> data;

    @Before
    public void setup() throws Exception {
        init("CHROME",30);
    }

    @After
    public void tearDown(){
//        quit();
    }

    @Given("I navigate to google.com")
    public void iNavigateToGoogleCom() {
        driver.get("http://www.google.com");
        }


    @Given("I have test data in {string} {string} {string}")
    public void iHaveTestDataIn(String file, String sheet, String row) throws IOException {
        data = new ExcelUtilities().getRowData(file,sheet,Integer.parseInt(row));
    }
}
