package uk.axone.testngadvanced.seleniumbasics;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Karthik.Gandhinathan
 */
public class HelloWorldSelenium {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/karthik/Documents/software/drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        Thread.sleep(15000);
        driver.close();
    }
}
