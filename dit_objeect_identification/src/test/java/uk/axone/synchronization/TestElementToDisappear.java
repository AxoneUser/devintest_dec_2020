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
public class TestElementToDisappear {

    WebDriver driver;

    @BeforeTest
    public void setUpBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void testElementToBeInvisible() throws InterruptedException {
        driver.get("http://uitest.automationtester.uk/dynamic-data-loading-demo.html");
        driver.findElement(By.id("save")).click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("loading"), "loading..."));
        System.out.println(driver.findElement(By.id("loading")).getText());

        //Thread.sleep(5000);
    }

    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }


}
