package uk.axone.binarymanagement;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowWebDriverManagerWorks {

    @Test
    public void testBinaryManagement(){
        //System.setProperty("webdriver.chrome.driver", "/Users/karthik/Documents/software/drivers/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://amazon.co.uk");
        System.out.println(driver.getTitle());
        driver.quit();



    }

    @Test
    public void testBinaryManagementUsingFirefox(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://amazon.co.uk");
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
