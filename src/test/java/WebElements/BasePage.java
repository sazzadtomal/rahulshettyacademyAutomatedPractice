package WebElements;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.DriverSetup.getDriver;

public class BasePage {

    private String BASE_URL ="https://rahulshettyacademy.com/AutomationPractice/";


    public void loadWebsite(){
        getDriver().get(BASE_URL);
    }



    public WebElement getElement(By locator){
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }

    public void clickOnElement(By locator){
        getElement(locator).click();
    }


    public Actions getActions(){
        return new Actions(getDriver());
    }



    public String getAttributeValue(By locator,String attribute){
        return getElement(locator).getAttribute(attribute);
    }







    public Boolean getElementDisplayStatus(By locator){
        try {
             return getElement(locator).isDisplayed();
        }
        catch (Exception e){
            return false;
        }

    }




    public String getBASE_URL() {
        return BASE_URL;
    }


}
