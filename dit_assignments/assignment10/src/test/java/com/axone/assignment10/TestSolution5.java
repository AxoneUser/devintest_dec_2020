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
 * Using	Smart	customised	XPath	selector achieve	the	following
 * a)	Login	to	http://uitest.automationtester.uk/basic-first-form-demo.html
 * b)	Write	your	own	custom	css	selector	to	click	on	the	All	Examples menu on	the
 * left	hand	tree	structure.	Navigate	to	Input	Forms	>	Checkbox Demo page
 * PS: Don’t	navigate	directly	to	the	URL.
 * c)	Navigate	to	“Multiple	Checkbox	demo”	section
 * d)	Write	a	test	to	fetch	all	the	values	of	the	checkboxes	and	print	them. Also	print
 * whether	they	are	checked	or	not
 * e)	Write	another	test	to	try	“Check	All”	and	“Uncheck	All”	operations	and	verify	the
 * results.
 */
public class TestSolution5 {
    public WebDriver driver;

    @BeforeTest
    public void launchApplication() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://uitest.automationtester.uk/basic-first-form-demo.html");
    }
    @Test(priority=0)
    public void testSimpleFormDemo() throws InterruptedException {

        WebElement inputForms = driver
                .findElement(By.xpath("//a[contains(text(),'Input Forms')]"));
        inputForms.click();

        WebElement checkBoxDemo = driver.findElement(By.xpath(" //a[contains(text(),'Checkbox Demo')]"));
        checkBoxDemo.click();

        Thread.sleep(3000);

        List<WebElement> list = driver.findElements(By.xpath(
                "//div[contains(text(),'Multiple Checkbox Demo')]/following-sibling::div/div[contains(@class,'checkbox')]"));

        for (WebElement element : list) {
            System.out.println("Check box options are : " + element.getText()
                    + "---" + element.isSelected());
        }

    }

    @Test(priority=1)
    public void test2() throws InterruptedException {
        Thread.sleep(200);
        WebElement checkAll = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        checkAll.click();

        if (checkAll.getAttribute("value").equals("Uncheck All")) {
            System.out.println("All checkboxes are checked");
        }

        Thread.sleep(3000);
        checkAll.click();

        if (checkAll.getAttribute("value").equals("Check All")) {
            System.out.println("All checkboxes are unchecked");
        }

        Thread.sleep(300);
    }

    @AfterTest
    public void tearDowwn() {
        driver.quit();
    }

}
