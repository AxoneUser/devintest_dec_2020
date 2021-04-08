
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/** * @author Karthik.Gandhinathan */
public class TestAssignment5 {




    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().driverVersion("86.0.4240.183").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/bootstrap-dual-list-box-demo.html");
        // 1. Implicit wait - applied for the entire session
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
    }

    @Test
    public void testDynamicText() throws InterruptedException, IOException {
        Thread.sleep(5000);
        driver.findElement(By.name("SearchDualList")).sendKeys("bootstrap");
        WebElement element = driver.findElement(By.xpath("//div[@class='well text-right']//ul[@class='list-group']"));
        element.click();
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm move-right']")).click();
        //verify the right hand side list box contains the bootstrap text
        List<WebElement> listBox = driver.findElements(By.xpath("//div[@class='well']//ul[@class='list-group']/li"));
        System.out.println("Size of elements: "+listBox.size());
        
        boolean isBootStrapPresent = false;
        for (WebElement webElement : listBox) {
            if (webElement.getText().contains("bootstrap-duallist")) {
                System.out.println("Bootstrap is present");
                isBootStrapPresent = true;
            }
        }
        Thread.sleep(5000);
        
        Assert.assertTrue(isBootStrapPresent);
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }



}

