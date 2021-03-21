package uk.axone.objectidentification;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowToHandleLinkText {

    WebDriver driver;

    @BeforeTest
    public void setUpBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.bbc.co.uk/");
        Thread.sleep(3000);
    }


    @Test
    public void testLinkText() throws InterruptedException {
        driver.findElement(By.linkText("Weather")).click();
        Thread.sleep(3000);

    }

    @Test
    public void testPartialLinkText() throws InterruptedException {
        driver.findElement(By.partialLinkText("vaccine")).click();
        Thread.sleep(3000);

    }



    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }

}
