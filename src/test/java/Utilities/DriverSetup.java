package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverSetup {


    private final String browserName=System.getProperty("browserName","chrome");
    private final static ThreadLocal<WebDriver> driverThreadLocal=new ThreadLocal<>();



    private static void setDriver(WebDriver driver){
        driverThreadLocal.set(driver);
    }

    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }




    private WebDriver getBrowser(){
        if(browserName.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--use-fake-ui-for-media-stream"); // For media permissions
            options.addArguments("--allow-file-access-from-files"); // Allow file access
            options.addArguments("--disable-popup-blocking"); // Disable popup blocking
            return new ChromeDriver(options);

        }else if(browserName.equalsIgnoreCase("firefox")){
            return new FirefoxDriver();
        }else if(browserName.equalsIgnoreCase("edge")){
            return new EdgeDriver();
        }else{
            throw new IllegalArgumentException();
        }
    }


    @BeforeMethod
    public void openABrowser(){
        WebDriver driver=getBrowser();
        setDriver(driver);
        getDriver().manage().window().maximize();
    }


    @AfterMethod
    public void quitBrowser(){
        getDriver().quit();
    }


}
