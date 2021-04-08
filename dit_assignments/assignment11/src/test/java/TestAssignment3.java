
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/** * @author Karthik.Gandhinathan */
public class TestAssignment3 {

    public WebDriver driver;

    private static final String URL = "http://the-internet.herokuapp.com/horizontal_slider";

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().driverVersion("86.0.4240.183").setup();
        driver = new ChromeDriver();
        driver.navigate().to(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {

        WebElement elementToSlide = driver.findElement(By.xpath("//div[@class='sliderContainer']//input"));
        dragAndDropElement(elementToSlide, 30);
        Thread.sleep(2000);
        // assert that the expected range value is reached
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='range']")).getText(), "4");
    }

    private void dragAndDropElement(final WebElement itemToSlide, final int xOffSetToSlide) {
        Actions action = new Actions(driver);
        action.dragAndDropBy(itemToSlide, xOffSetToSlide, 0).build().perform();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
