package uk.axone.binarymanagement;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHeadlessBrowser {

    @Test
    public void testChromeHeadless(){

        System.setProperty("webdriver.chrome.driver", "/Users/karthik/Documents/software/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.setAcceptInsecureCerts(true);

        WebDriver driver = new ChromeDriver(options);
        driver.get("http://uitest.automationtester.uk");
        System.out.println("Title: "+driver.getTitle());
        System.out.println("url is: "+driver.getCurrentUrl());
        driver.quit();
    }


    @Test(enabled = false)
    public void testHeadlessHUD(){
        WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME, true);

        driver.get("http://uitest.automationtester.uk");
        System.out.println("Title: "+driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }

}
