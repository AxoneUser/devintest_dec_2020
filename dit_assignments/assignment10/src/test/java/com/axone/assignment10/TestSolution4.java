package com.axone.assignment10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

/**
 * Using	Smart	customised	css	selector	achieve	the	following
 * a)	Login	to	http://uitest.automationtester.uk/basic-first-form-demo.html
 * b)	Write	your	own	custom	css	selector	to	click	on	the	All	Examples menu on	the
 * left	hand	tree	structure.	Navigate	to	Input	Forms	>	Simple	Form	Demo
 * PS: Don’t	navigate	directly	to	the	URL.
 * c)	Navigate	to	“Two	Input	Fields”	section
 * d)	Write	a	test	to	validate	the	addition	operation	for	the	given	fields
 */
public class TestSolution4 {
    public WebDriver driver;
    @BeforeTest
    public void launchApplication() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mahalakshmi\\Desktop\\Mala-coaching\\Selenium\\Chrome-86\\chromedriver_win32\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://uitest.automationtester.uk/basic-first-form-demo.html");
    }

    @Test
    public void testAddition() throws InterruptedException {
        WebElement inputForms = driver.findElement(By.xpath("//a[contains(text(),'Input Forms')]")); // Css selector???
        inputForms.click();

        WebElement checkBoxDemo = driver.findElement(By.xpath(" //a[contains(text(),'Simple Form Demo')]"));
        checkBoxDemo.click();

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        driver.findElement(By.id("sum1")).sendKeys("25");
        driver.findElement(By.id("sum2")).sendKeys("25");
        driver.findElement(By.xpath("//*[@id='gettotal']/button")).click();

        assertEquals(driver.findElement(By.id("displayvalue")).getText(), "50");
    }

    @AfterTest
    public void closeApplication() {
        // close the application after the test is finished
        if (driver != null) {
            driver.quit();
        }
    }
}
