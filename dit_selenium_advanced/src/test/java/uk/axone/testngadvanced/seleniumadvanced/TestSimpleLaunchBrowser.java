package uk.axone.seleniumadvanced;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestSimpleLaunchBrowser {

    @Test
    public void testSimpleBrowser() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","/Users/karthik/Documents/software/drivers/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
        Thread.sleep(15000);
        driver.close();
    }

}
