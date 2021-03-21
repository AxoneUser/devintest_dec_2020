package uk.axone.objectidentification;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
*/
public class TestHandlingDropDownList {
    WebDriver driver;

    @BeforeTest
    public void setUpBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://uitest.automationtester.uk/basic-select-dropdown-demo.html");
        Thread.sleep(5000);
    }


    @Test
    public void testHandlingDDL() throws InterruptedException {
        //1. To identify the ddl
        WebElement ddList = driver.findElement(By.id("select-demo"));
        //2. to select a value
        ddList.sendKeys("Wednesday");
        Thread.sleep(2000);

    }

    @Test
    public void testHandlingUsingSelect() throws InterruptedException {
        WebElement ddList = driver.findElement(By.id("select-demo"));
        Select dayList = new Select(ddList);
        dayList.selectByVisibleText("Friday");
        Thread.sleep(2000);
        dayList.selectByValue("Saturday");
        Thread.sleep(2000);
        dayList.selectByIndex(5);
        Thread.sleep(2000);

    }


    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }


}
