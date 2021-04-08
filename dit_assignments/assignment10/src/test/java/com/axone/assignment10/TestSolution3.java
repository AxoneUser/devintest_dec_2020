package com.axone.assignment10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

/**
 * Using	Smart	customised	XPath	achieve	the	following
 * a)	Login	to	https://www.zoho.eu/
 * b)	Write	your	own	custom	XPath to	click	on	the	Login	link	on	the	top	right	hand
 * corner
 * c)	Type	random	email	address	into	the	“Email	address”	field
 * d)	Using	appropriate	methods	fetch	the	above	typed	value	of	the	email	address
 */
public class TestSolution3 {
    public WebDriver driver;

    @BeforeTest
    public void launchApplication() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.zoho.eu/");

    }

    @Test
    public void fetchEmailAddressFieldValue() {
        driver.findElement(By.xpath("//a[@class='zh-login']")).click();

        driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys("mahalakshmi@automationtester.co.uk");
        String actualEmailId = driver.findElement(By.cssSelector("input[id='login_id']")).getAttribute("value");
        System.out.println("The value typed in email address is: " + actualEmailId);
        assertEquals("mahalakshmi@automationtester.co.uk", actualEmailId);
    }

    @AfterClass
    public void closeApplication() {
        // close the application after the test is finished
        driver.quit();
    }
}
