package com.axone.assignment10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *  Fetch	all	the	HREFs	for	the	link texts	and	then	print	them
 * a) Navigate to	https://www.bbc.co.uk/
 * b) Using	CSS	Selector	locator	strategy	fetch	the	link texts	available	in	the	home
 * page	top	Menu.
 */
public class TestSolution2 {

    public WebDriver driver;

    @BeforeTest
    public void launchApplication() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mahalakshmi\\Desktop\\Mala-coaching\\Selenium\\Chrome-86\\chromedriver_win32\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.bbc.co.uk/");

    }

    @Test
    public void getLinkTextsFromBBC() {

        //List<WebElement> allLinks = driver.findElements(By.cssSelector("a")); // this will find all the links in page
        List<WebElement> allLinks = driver.findElements(By.cssSelector("ul[class='ssrcss-1ceb9ru-GlobalNavigationLinkList-En e1b8fg8n0'] li a"));

        System.out.println("total number of links present in BBC home page: "+allLinks.size());
        for (WebElement eachLinkText : allLinks) {
            System.out.println(eachLinkText.getText());
            System.out.println(eachLinkText.getAttribute("href"));
        }
    }

    @AfterTest
    public void closeApplication() {
        // close the application after the test is finished
        if (driver != null) {
            driver.quit();
        }
    }
}
