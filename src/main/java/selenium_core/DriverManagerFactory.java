package selenium_core;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(String type) throws Exception {
        DriverManager driverManager;

        switch (type){
            case "CHROME":{
                driverManager = new ChromeDriverManager();
            }
            break;
            case "FIREFOX":{
                driverManager = new FirefoxDriverManager();
            }
            break;
            default:
                throw new Exception("Browser: "+type+" is not currently supported!\nPlease use CHROME or FIREFOX browser!");
        }
        return driverManager;
    }
}
