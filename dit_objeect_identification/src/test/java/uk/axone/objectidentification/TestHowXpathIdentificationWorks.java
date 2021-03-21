package uk.axone.objectidentification;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowXpathIdentificationWorks {

    WebDriver driver;

    @BeforeTest
    public void setUpBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        Thread.sleep(5000);
    }


    @Test
    public void testXpath() throws InterruptedException {
        //System.out.println("Src attribute value: "+driver.findElement(By.xpath("html/body/div/div/header/div[3]/div/div/div/a/img")).getAttribute("src"));
        System.out.println("Src attribute value2: "+driver.findElement(By.xpath("//img[@class='logo img-responsive'")).getAttribute("src"));

    }


    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }


}
