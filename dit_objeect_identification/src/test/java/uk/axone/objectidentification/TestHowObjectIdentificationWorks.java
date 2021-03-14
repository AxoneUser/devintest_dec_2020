package uk.axone.objectidentification;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowObjectIdentificationWorks {

    WebDriver driver;

    @BeforeTest
    public void setUpBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        Thread.sleep(5000);
    }


    @Test
    public void testObjectIdentification() throws InterruptedException {
        //1. to identify the element
        WebElement searchQueryTxtBox = driver.findElement(By.id("search_query_top"));
        //2. perform the operation
        searchQueryTxtBox.sendKeys("Searching some product");
        Thread.sleep(5000);
        searchQueryTxtBox.clear();
        Thread.sleep(5000);
        searchQueryTxtBox.sendKeys("Another Search...");
        Thread.sleep(5000);
        System.out.println("typed value is: "+searchQueryTxtBox.getAttribute("value"));
    }


    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }


}
