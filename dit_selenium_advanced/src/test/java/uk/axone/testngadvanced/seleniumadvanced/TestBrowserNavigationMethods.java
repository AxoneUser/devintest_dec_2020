package uk.axone.testngadvanced.seleniumadvanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestBrowserNavigationMethods {

    @Test
    public void testNavigationalMethods(){
        WebDriver driver = new ChromeDriver();

        //easiest and convenient way to navigate to a url
        driver.get("http://uitest.automationtester.uk/");

        //longer way but to access the browser's history
        driver.navigate().to("http://uitest.automationtester.uk/");
        //go back
        driver.navigate().back();
        //go forward
        driver.navigate().forward();
        //refresh the browser
        driver.navigate().refresh();
    }
}
