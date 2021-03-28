package uk.axone.alertsandmousemovements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowToHandleAlerts {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://uitest.automationtester.uk/javascript-alert-box-demo.html");
        driver.manage().window().maximize();
    }

    @Test
    public void testHandleAlerts() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(text(),'Click for Prompt Box')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Text inside the alert: "+alert.getText());
        Thread.sleep(2000);

        alert.sendKeys("Hello World!!!");
        Thread.sleep(2000);

        alert.accept();
        Thread.sleep(3000);

        System.out.println("After clicking the alert: "+driver.findElement(By.id("prompt-demo")).getText());
        Thread.sleep(3000);
    }


    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }

}
