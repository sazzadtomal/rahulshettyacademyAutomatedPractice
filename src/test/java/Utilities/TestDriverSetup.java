package Utilities;

import org.testng.annotations.Test;

public class TestDriverSetup extends DriverSetup {



    @Test
    public void openABrowserAndWait() throws InterruptedException {
        getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(3000);
    }

}
