package uk.axone.alertsandmousemovements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHandlingMouseMovements {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.americangolf.co.uk/");
        driver.manage().window().maximize();
    }

    @Test
    public void testHandlingMouseMovements() throws InterruptedException {
        Thread.sleep(5000);
        WebElement golfClubsMenu = driver.findElement(By.xpath("//div[@id='header-navigation']/div[1]/ul/li[2]/a"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(golfClubsMenu));

        Actions actions = new Actions(driver);
        actions.moveToElement(golfClubsMenu).perform();

        WebElement setsOfIronMenuItem = driver.findElement(By.xpath("//div[@id='CLUBS_1']/ul/li[2]/ul/li[1]/a/span"));
        wait.until(ExpectedConditions.elementToBeClickable(setsOfIronMenuItem)).click();

        Thread.sleep(3000);
    }


    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }

}
