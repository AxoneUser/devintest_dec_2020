package uk.axone.alertsandmousemovements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHandlingWebTables {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.londonstockexchange.com/indices/ftse-100/constituents/table?lang=en");
        driver.manage().window().maximize();
    }

    @Test
    public void testHandlingWebTables() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> stockNamesList = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
        List<WebElement> stockPriceList = driver.findElements(By.xpath("//table/tbody/tr/td[5]"));

        for (int i = 0; i < stockNamesList.size(); i++) {
            System.out.println("StockName: " + stockNamesList.get(i).getText() + " ========== price is: " + stockPriceList.get(i).getText());
        }

        Thread.sleep(3000);
    }


    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }

}
