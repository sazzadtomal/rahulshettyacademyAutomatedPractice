package WebElements;

import Utilities.DriverSetup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextInputField extends DriverSetup {

    BasePage basePage=new BasePage();


    By textInputField = By.id("autocomplete");
    By textFieldHeading=By.cssSelector("div[id='select-class-example'] fieldset legend");
    By anotherTextField=By.id("displayed-text");


    @BeforeMethod
    public void loadWebSite(){
        basePage.loadWebsite();
        System.out.println(basePage);
    }

    @Test
    public void textInputFieldVisibility(){
        Assert.assertTrue(basePage.getElementDisplayStatus(textInputField));
    }

    @Test
    public void textInputFieldHeading(){
        Assert.assertTrue(basePage.getElementDisplayStatus(textFieldHeading));
        Assert.assertEquals(basePage.getElementText(textFieldHeading),"Suggession Class Example");

    }


    @Test
    public void textInputFieldAcceptsText() throws InterruptedException {
        basePage.sendKeysToElement(textInputField,"abcd");
        Assert.assertTrue(basePage.attributeValueMatch(textInputField,"value","abcd"));
    }

    @Test
    public void textInputFieldPlaceholderText() {
        Assert.assertTrue(basePage.attributeValueMatch(textInputField,"placeholder","Type to Select Countries"));
    }


    @Test
    public void textInputFieldIsFocusedWhenClicked(){
        basePage.clickOnElement(textInputField);
        Assert.assertTrue(basePage.elementInFocus(textInputField));
    }

    @Test
    public void textInputFieldIsNotFocusedWhenClickedOutside(){
        basePage.clickOnElement(textInputField);
        Assert.assertTrue(basePage.elementInFocus(textInputField));
        basePage.clickOnElement(textFieldHeading);
        Assert.assertFalse(basePage.elementInFocus(textInputField));
    }


    @Test
    public void textInputFieldCopyFunctionality(){
        basePage.sendKeysToElement(textInputField,"abcd");
        basePage.copyALL();
        basePage.clickOnElement(anotherTextField);
        basePage.pasteALL();
        Assert.assertEquals(basePage.getAttributeValue(anotherTextField,"value"),"abcd");
    }

    @Test
    public void textInputFieldPasteFunctionality() throws InterruptedException {
        basePage.sendKeysToElement(anotherTextField,"abcd");
        basePage.copyALL();
        basePage.clickOnElement(textInputField);
        basePage.pasteALL();
        Assert.assertEquals(basePage.getAttributeValue(textInputField,"value"),"abcd");
        Thread.sleep(2000);
    }





}
