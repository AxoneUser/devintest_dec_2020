
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/** * @author Karthik.Gandhinathan */
public class TestAssignment6 {


    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().driverVersion("86.0.4240.183").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/bootstrap-download-progress-demo.html");
        // 1. Implicit wait - applied for the entire session
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
    }

    @Test
    public void testSynchronization()
            throws InterruptedException, IOException {
        driver.findElement(By.id("cricle-btn")).click();
        WebElement element = driver.findElement(By.xpath("//div[@class='percenttext']"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(element, "100%"));
        System.out.println(element.getText());
        Assert.assertEquals(element.getText(), "100%");
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}

