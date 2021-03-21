package uk.axone.synchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestElementToBeVisible {

    WebDriver driver;

    @BeforeTest
    public void setUpBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void testElementToBeVisible() throws InterruptedException {
        driver.get("http://uitest.automationtester.uk/jquery-download-progress-bar-demo.html");
        driver.findElement(By.id("downloadButton")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dialog > div.progress-label"))).
            getText().equals("Complete!");

        Thread.sleep(10000);
    }

    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }


}
