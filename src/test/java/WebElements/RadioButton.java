package WebElements;

import Utilities.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButton extends DriverSetup {

    BasePage basePage=new BasePage();

    By radioButtonGroup = By.id("radio-btn-example");
    By radioButtonHeading = By.xpath("//legend[normalize-space()='Radio Button Example']");

    By radioButtonLabel1=By.xpath("//label[@for='radio1']");
    By radioButton1=By.xpath("//label[@for='radio1'] / input");

    By radioButtonLabel2=By.xpath("//label[@for='radio2']");
    By radioButton2=By.xpath("//label[@for='radio2'] / input");

    By radioButtonLabel3=By.xpath("//label[@for='radio3']");
    By radioButton3=By.xpath("//label[@for='radio3'] / input");


    @BeforeMethod
    public void loadWebSite(){
        basePage.loadWebsite();
    }




    @Test
    public void radioButtonGroupDisplayStatus(){
        Assert.assertTrue(basePage.getElementDisplayStatus(radioButtonGroup));
    }


    @Test
    public void radioButtonGroupHeadingVerification(){
        Assert.assertTrue(basePage.getElementDisplayStatus(radioButtonHeading));
        Assert.assertEquals(basePage.getElementText(radioButtonHeading),"Radio Button Example");

    }

    @Test
    public void radioButtonOptionsByLabelAndValue(){
        Assert.assertEquals(basePage.getElementText(radioButtonLabel1),"Radio1");
        Assert.assertEquals(basePage.getAttributeValue(radioButton1,"value"),"radio1");

        Assert.assertEquals(basePage.getElementText(radioButtonLabel2),"Radio2");
        Assert.assertEquals(basePage.getAttributeValue(radioButton2,"value"),"radio2");

        Assert.assertEquals(basePage.getElementText(radioButtonLabel3),"Radio3");
        Assert.assertEquals(basePage.getAttributeValue(radioButton3,"value"),"radio3");
    }

    @Test
    public void radioButtonOptionsAreSelectable(){
        basePage.clickOnElement(radioButton1);
        Assert.assertTrue(basePage.getElement(radioButton1).isSelected());

        basePage.clickOnElement(radioButton2);
        Assert.assertTrue(basePage.getElement(radioButton2).isSelected());

        basePage.clickOnElement(radioButton3);
        Assert.assertTrue(basePage.getElement(radioButton3).isSelected());

    }

    @Test
    public void radioButtonMultipleOptionsAreNotSelectable(){
        basePage.clickOnElement(radioButton1);
        Assert.assertTrue(basePage.getElement(radioButton1).isSelected());
        Assert.assertFalse(basePage.getElement(radioButton2).isSelected());
        Assert.assertFalse(basePage.getElement(radioButton3).isSelected());



        basePage.clickOnElement(radioButton2);
        Assert.assertTrue(basePage.getElement(radioButton2).isSelected());
        Assert.assertFalse(basePage.getElement(radioButton1).isSelected());
        Assert.assertFalse(basePage.getElement(radioButton3).isSelected());


        basePage.clickOnElement(radioButton3);
        Assert.assertTrue(basePage.getElement(radioButton3).isSelected());
        Assert.assertFalse(basePage.getElement(radioButton1).isSelected());
        Assert.assertFalse(basePage.getElement(radioButton2).isSelected());

    }


    @Test
    public void radioButtonClickUnLabelSelects(){
        basePage.clickOnElement(radioButtonLabel1);
        Assert.assertTrue(basePage.getElement(radioButton1).isSelected());

        basePage.clickOnElement(radioButtonLabel2);
        Assert.assertTrue(basePage.getElement(radioButton2).isSelected());

        basePage.clickOnElement(radioButtonLabel3);
        Assert.assertTrue(basePage.getElement(radioButton3).isSelected());
    }

    @Test
    public void radioButtonSelectionByKeyboardArrows(){
        Actions actions=basePage.getActions();
        basePage.clickOnElement(radioButton1);

        actions.sendKeys(Keys.DOWN).build().perform();

        Assert.assertTrue(basePage.getElement(radioButton2).isSelected());

        actions.sendKeys(Keys.DOWN).build().perform();
        Assert.assertTrue(basePage.getElement(radioButton3).isSelected());

        actions.sendKeys(Keys.DOWN).build().perform();
        Assert.assertTrue(basePage.getElement(radioButton1).isSelected());

    }














}
