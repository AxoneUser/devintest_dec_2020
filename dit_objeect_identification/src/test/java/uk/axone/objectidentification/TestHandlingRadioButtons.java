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
 * @project dit_selenium_advanced
 */
public class TestHandlingRadioButtons {
    WebDriver driver;

    @BeforeTest
    public void setUpBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://uitest.automationtester.uk/basic-radiobutton-demo.html");
        Thread.sleep(5000);
    }


    @Test
    public void testRadio() throws InterruptedException {
        List<WebElement> allRadioButtons = driver.findElements(By.name("optradio"));
        allRadioButtons.get(0).click();
        Thread.sleep(2000);

        for (WebElement radio : allRadioButtons) {
            System.out.println(radio.getAttribute("value") + " -- is Selected?: " + radio.isSelected());
        }
    }


    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }

}
