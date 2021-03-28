package uk.axone.alertsandmousemovements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowToHandleMultipleWindows {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://mail.axone-tech.uk/useful-links");
        driver.manage().window().maximize();
    }

    @Test
    public void testHandlingMultipleWins() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//h3[contains(text(),'How to use Xpath Functions')]")).click();

        //collection of windows
        Set<String>  windows = driver.getWindowHandles();

        //size of windows
        System.out.println("No. of windows: "+ windows.size());
        Iterator<String> itr = windows.iterator();

        String mainWindow = itr.next();
        String popUpWindow = itr.next();

        driver.switchTo().window(popUpWindow);
        System.out.println("Title of the window is: "+ driver.getTitle());
        driver.close();

        driver.switchTo().window(mainWindow);
        System.out.println("Title of the window is: "+ driver.getTitle());

        Thread.sleep(3000);
    }


    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }

}
