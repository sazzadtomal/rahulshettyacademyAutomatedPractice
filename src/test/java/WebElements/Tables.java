package WebElements;

import Utilities.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Tables extends DriverSetup {

    BasePage basepage=new BasePage();
    By tableElement= By.xpath("//legend[text()='Web Table Example'] /following-sibling::table");
    By tableHeadings=By.xpath("//legend[text()='Web Table Example'] /following-sibling::table //th");
    By tableRows=By.xpath("//legend[text()='Web Table Example'] /following-sibling::table //tr");

    String[] headingTitles ={"Instructor","Course","Price"};
    int totalRows=11;

    @BeforeMethod
    public void loadWebSite(){
        basepage.loadWebsite();
    }


    @Test
    public void tableElementVisibility(){
        Assert.assertTrue(basepage.getElementDisplayStatus(tableElement));
    }

    @Test
    public void tableHeadingsAreVisible(){
        List<WebElement> headings=basepage.getElements(tableHeadings);

        for(int i=0;i<headings.size();i++){

            Assert.assertEquals(headings.get(i).getText(),headingTitles[i]);

        }

    }

    @Test
    public void numberOfTableRows(){
        List<WebElement> rows=basepage.getElements(tableRows);

        Assert.assertEquals(rows.size(),totalRows);

    }









}
