package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchGoogleTests extends BaseTest{
    @BeforeMethod
    public void setup() throws Exception {
        init("CHROME",30);
    }

    @AfterMethod
    public void tearDown(){
        quit();
    }

    @Test
    public void detailedSearch() {
        //TestNG test

    }

}
