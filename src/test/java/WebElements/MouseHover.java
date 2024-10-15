package WebElements;

import Utilities.DriverSetup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHover extends DriverSetup {
    BasePage basepage=new BasePage();
    By mouseHoverElement=By.id("mousehover");
    By mouseHoverOptions=By.className("mouse-hover-content");


    @BeforeMethod
    public void loadWebSite(){
        basepage.loadWebsite();
    }


    @Test
    public void mouseHoverElementVisibility(){
        basepage.bringElementIntoView(mouseHoverElement);
        Assert.assertTrue(basepage.getElementDisplayStatus(mouseHoverElement));
    }


    @Test
    public void mouseHoverOptionsNotVisibleByDefault(){
        Assert.assertFalse(basepage.getElementDisplayStatus(mouseHoverOptions));
    }

    @Test
    public void mouseHoverOptionsVisibleWhileHovered() throws InterruptedException {
        basepage.bringElementIntoView(mouseHoverElement);
        basepage.simulateMouseHover(mouseHoverElement);
        Assert.assertTrue(basepage.getElementDisplayStatus(mouseHoverOptions));
    }

}
