package WebElements;
import Utilities.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dropdown extends DriverSetup {

    BasePage basepage=new BasePage();
    By dropdownHeader= By.xpath("//legend[normalize-space()='Dropdown Example']");
    By dropdownSelection=By.cssSelector("#dropdown-class-example");


    @BeforeMethod
    public void loadWebSite(){
        basepage.loadWebsite();
    }

    public Map<String,String> dropdownOptions(){

        Map<String,String> options=new HashMap<>();
        options.put("","Select");
        options.put("option1","Option1");
        options.put("option2","Option2");
        options.put("option3","Option3");
        return options;
    }




    @Test
    public void dropdownSelectionVisibility(){
        Assert.assertTrue(basepage.getElementDisplayStatus(dropdownSelection));
    }


    @Test
    public void dropdownSelectionOptionsLabelAndValue(){
        Map<String,String> options=dropdownOptions();
        List<WebElement> elementList=basepage.getSelectionOptions(dropdownSelection);

        for(WebElement option:elementList){
            Assert.assertEquals(options.get(option.getAttribute("value")),option.getText());
        }
    }


    @Test
    public void dropdownSelectionDefaultOption(){
        Map<String,String> options=dropdownOptions();
        Assert.assertEquals(basepage.getDefaultSelection(dropdownSelection).getText(),options.get(""));
    }

    @Test
    public void dropdownSelectionOptionsAreVisible(){
        Map<String,String> options=dropdownOptions();
        Assert.assertEquals(basepage.getDefaultSelection(dropdownSelection).getText(),options.get(""));
    }

    @Test
    public void dropdownSelectionOptionsAreSelectable(){

        List<WebElement> elementList=basepage.getSelectionOptions(dropdownSelection);
        Select dropdown=basepage.getDropDown(dropdownSelection);

        for(int i=0;i<elementList.size();i++){
            dropdown.selectByIndex(i);
            Assert.assertTrue(elementList.get(i).isSelected());
        }
    }

    @Test
    public void dropdownSelectionMultipleOptionsAreNotSelectable(){

        Select dropdown=basepage.getDropDown(dropdownSelection);
        Assert.assertFalse(dropdown.isMultiple());
    }


    @Test
    public void dropdownSelectionOptionsByArrow(){

        List<WebElement> elementList=basepage.getSelectionOptions(dropdownSelection);
        Actions actions=basepage.getActions();

        basepage.clickOnElement(dropdownSelection);

        for(int i=1;i<elementList.size()-1;i++){
            actions.sendKeys(Keys.ARROW_DOWN);
            actions.sendKeys(Keys.ENTER).build().perform();
            Assert.assertTrue(elementList.get(i).isSelected());
        }

    }









}
