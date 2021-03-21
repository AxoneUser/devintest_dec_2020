package uk.axone.objectidentification;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHandlingPortionOfAWebPage {

    WebDriver driver;

    @BeforeTest
    public void setUpBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //to maximize the window
        driver.manage().window().maximize();
        driver.get("http://shopping.rediff.com/");
        Thread.sleep(5000);
    }


    @Test
    public void testPortionOfAWebPage() throws InterruptedException {
        WebElement popularCat = driver.findElement(By.id("popular_cat"));
        List<WebElement> popularCatList = popularCat.findElements(By.tagName("a"));

        String element1 = "//div[@id='popular_cat']/h3[";
        String element2 = "]/a";


        for (int i = 1; i < popularCatList.size(); i++) {
            System.out.println(driver.findElement(By.xpath(element1 + i + element2)).getText());
        }

    }

    @Test
    public void testPortionOfAWebPage2() throws InterruptedException {
        WebElement popularCat = driver.findElement(By.id("popular_cat"));
        List<WebElement> popularCatList = popularCat.findElements(By.tagName("a"));

        for (WebElement category : popularCatList) {
            System.out.println(category.getText());
        }

    }


    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }

}
