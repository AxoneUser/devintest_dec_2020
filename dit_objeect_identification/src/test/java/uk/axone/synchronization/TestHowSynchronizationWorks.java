package uk.axone.synchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowSynchronizationWorks {

    WebDriver driver;

    @BeforeTest
    public void setUpBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //1. implicit wait - applied for the entire session
        //2. applicable for findElement or findElements - not for any other selenium webdriver commands.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void testImplicitWait() throws InterruptedException {
        driver.get("https://www.bbc.co.uk/");
        driver.findElements(By.id(""));
        driver.findElements(By.id(""));
        driver.findElements(By.id(""));

        driver.findElement(By.name(""));
        driver.findElement(By.cssSelector(""));
    }

    @Test
    public void testExplicitWait(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //isElementClickable
        wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
        //isElementVisible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        //isElementInvisible
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));
        //isElementPresent
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("")));
    }

    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }


}
