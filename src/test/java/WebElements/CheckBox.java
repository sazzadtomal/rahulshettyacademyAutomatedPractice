package WebElements;

import Utilities.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckBox extends DriverSetup {


    BasePage basepage=new BasePage();
    String[] labels={"Option1","Option2","Option3"};
    By checkboxGroup=By.id("checkbox-example");
    By checkBoxLabels=By.xpath("//div[@id='checkbox-example'] / fieldset / label");
    By checkBoxInputs=By.xpath("//div[@id='checkbox-example'] / fieldset //input");




    public Map<String,String> checkboxInputData(){
        Map<String,String> options=new HashMap<>();
        options.put("checkBoxOption1","option1");
        options.put("checkBoxOption2","option2");
        options.put("checkBoxOption3","option3");
        return options;
    }



    @BeforeMethod
    public void loadWebSite(){
        basepage.loadWebsite();
    }

    @Test
    public void setCheckboxGroupVisibility(){
        Assert.assertTrue(basepage.getElementDisplayStatus(checkboxGroup));
    }


    @Test
    public void dropdownSelectionOptionsLabelAndValue(){
        List<WebElement> labelElements=basepage.getElements(checkBoxLabels);

        Assert.assertEquals(labels.length,labelElements.size());

        for(int i=0;i<labels.length;i++){
            Assert.assertEquals(labelElements.get(i).getText().trim(),labels[i]);
        }

        Map<String,String> inputOptions= this.checkboxInputData();

        List<WebElement> inputElements=basepage.getElements(checkBoxInputs);
        Assert.assertEquals(inputOptions.size(),inputElements.size());

        for(WebElement option:inputElements){
            Assert.assertEquals(option.getAttribute("value"),inputOptions.get(option.getAttribute("id")));
        }

    }



    @Test
    public void clickingCheckboxSelectsOption(){

        List<WebElement> inputOptions=basepage.getElements(checkBoxInputs);

        for(WebElement option:inputOptions){
            option.click();
            Assert.assertTrue(option.isSelected());
        }
    }


    @Test
    public void checkboxMultipleOptionsAreSelectable(){

        List<WebElement> inputOptions=basepage.getElements(checkBoxInputs);

        for(WebElement option:inputOptions){
            option.click();
        }
        for(WebElement option:inputOptions){
            Assert.assertTrue(option.isSelected());
        }
    }


    @Test
    public void clickingSelectedOptionsDeSelects(){

        List<WebElement> inputOptions=basepage.getElements(checkBoxInputs);

        for(WebElement option:inputOptions){
            option.click();
            if(option.isSelected()){
                option.click();
            }
            Assert.assertFalse(option.isSelected());
        }
    }







}
