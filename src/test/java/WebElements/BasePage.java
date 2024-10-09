package WebElements;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

    public void sendKeysToElement(By locator,String keys){
        getElement(locator).sendKeys(keys);
    }


    public Actions getActions(){
        return new Actions(getDriver());
    }



    public String getCopiedText(){

        JavascriptExecutor js=(JavascriptExecutor) getDriver();
        return (String) js.executeAsyncScript(
                "var callback = arguments[0];" +
                        "navigator.clipboard.readText().then(function(text) {" +
                        "    callback(text);" +
                        "}).catch(function(err) {" +
                        "    callback('Failed to read clipboard contents: ' + err);" +
                        "});"
        );
    }

     public void copyALL(){
          Actions actions=getActions();
          actions.keyDown(Keys.CONTROL);
          actions.sendKeys("A");
          actions.keyDown(Keys.CONTROL);
          actions.sendKeys("C").build().perform();
    }

    public void pasteALL(){
        Actions actions=getActions();
        actions.keyDown(Keys.CONTROL);
        actions.sendKeys("V").build().perform();
    }



    public String getAttributeValue(By locator,String attribute){
        return getElement(locator).getAttribute(attribute);
    }

    public Boolean attributeValueMatch(By locator,String attribute,String attributeValue){
        WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.attributeToBe(locator,attribute,attributeValue));
    }

    public Boolean elementInFocus(By locator){
        JavascriptExecutor js=(JavascriptExecutor) getDriver();
        return (Boolean) js.executeScript(" return document.activeElement === arguments[0];", getElement(locator));
    }

    public Boolean elementNotInFocus(By locator){
        JavascriptExecutor js=(JavascriptExecutor) getDriver();
        return (Boolean) js.executeScript(" return document.activeElement === arguments[0];", getElement(locator));
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
