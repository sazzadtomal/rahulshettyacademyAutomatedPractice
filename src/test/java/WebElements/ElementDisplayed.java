package WebElements;

import Utilities.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementDisplayed extends DriverSetup {

    BasePage basepage=new BasePage();
    By element= By.id("displayed-text");
    By hideButton= By.id("hide-textbox");
    By showButton= By.id("show-textbox");


    @BeforeMethod
    public void loadWebSite(){
        basepage.loadWebsite();
    }

    @Test
    public void elementShouldBeVisibleByDefault(){
        Assert.assertTrue(basepage.getElementDisplayStatus(element));
    }


    @Test
    public void clickingHideButtonHidesElement(){
        basepage.clickOnElement(hideButton);
        Assert.assertFalse(basepage.getElementDisplayStatus(element));
    }
    @Test
    public void clickingShowButtonShowElement(){
        basepage.clickOnElement(showButton);
        Assert.assertTrue(basepage.getElementDisplayStatus(element));
    }

    @Test
    public void elementAcceptsInputWhenVisible(){
        basepage.clickOnElement(showButton);
        basepage.sendKeysToElement(element,"abcd");
        Assert.assertEquals(basepage.getAttributeValue(element,"value"),"abcd");
    }

    @Test
    public void elementDoNotAcceptsInputWhenHidden(){
        basepage.clickOnElement(hideButton);

        Assert.assertThrows(ElementNotInteractableException.class,()->{
            basepage.sendKeysToElement(element,"abcd");
        });


    }




}
