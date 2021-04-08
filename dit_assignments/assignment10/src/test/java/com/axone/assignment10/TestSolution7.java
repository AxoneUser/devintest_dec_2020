package com.axone.assignment10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Using	Smart	customised	css	selector	achieve	the	following
 * a)	Login	to	http://uitest.automationtester.uk/basic-first-form-demo.html
 * b)	Write	your	own	custom	css	selector	to	click	on	the	All	Examples menu on	the
 * left	hand	tree	structure.	Navigate	to	Input	Forms	>	Select	Dropdown	List
 * PS: Don’t	navigate	directly	to	the	URL.
 * c)	Navigate	to	“Multi	Select	List	Demo”	section
 * d)	Write	a	test	to	validate	the	following:
 * - it’s	a	multi	select	box
 * - to	multi-select:	California,	Pennsylvania values
 * e)	Write	another	test	to	verify	first	selected	logic
 * f)	Write	another	test	to	verify	get	all	selected	logic
 */
public class TestSolution7 {
    public WebDriver driver;

    @BeforeTest
    public void launchApplication() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://uitest.automationtester.uk/basic-first-form-demo.html");
    }

    @Test
    public void testMultiSelectDemo() throws InterruptedException {

        driver.findElement(By.cssSelector(".tree-branch>ul>li:first-of-type")).click();

        List<WebElement> list = driver.findElements(By.cssSelector(".tree-branch>ul>li:nth-of-type(1) :nth-child(4)"));

        Thread.sleep(3000);

        for (WebElement element : list) {

            System.out.println(element.getText());

            if (element.getText().equalsIgnoreCase("Select Dropdown List")) {

                element.click();

                break;

            }

        }

        Thread.sleep(3000);
        WebElement multiSelect = driver.findElement(By.id("multi-select"));
        Select states = new Select(multiSelect);
        System.out.println("is this a Multi select ddl: "+states.isMultiple());
        List<WebElement> listOfStates = states.getOptions();
        for (WebElement webElement : listOfStates) {
            if (webElement.getText().equalsIgnoreCase("California") || webElement.getText().equalsIgnoreCase("Pennsylvania")) {
                webElement.click();
            }
        }

        System.out.println("First selected: "+states.getFirstSelectedOption().getText());
        List<WebElement> allStates = states.getAllSelectedOptions();
        for (WebElement webElement2 : allStates) {
            System.out.println("Multi-selected value: "+ webElement2.getText());
        }

        //asserts

    }

    @AfterTest
    public void tearDownBrowser() {
        driver.quit();
    }
}
