package uk.axone.testngadvanced.seleniumadvanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Karthik.Gandhinathan
 */
public class TestLaunchBrowsersDynamically {

    WebDriver driver;
    String browserType;
    String appUrl;

    @Test
    public void testLaunchingBrowsers() throws InterruptedException {

        //accessing the file path
        String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        //create an empty property list
        Properties prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream(path);
            //load the property
            prop.load(fis);
            browserType = prop.getProperty("browser");
            appUrl = prop.getProperty("applicationUrl");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (browserType.equalsIgnoreCase("chrome")) {
            //to launch the chrome browser
            System.setProperty("webdriver.chrome.driver", "/Users/karthik/Documents/software/drivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            //code to launch the firefox browser
            System.setProperty("webdriver.gecko.driver", "/Users/karthik/Documents/software/drivers/geckodriver");
            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("ie")) {
            //code to launch the ie browser
        } else if (browserType.equalsIgnoreCase("safari")) {
            //code to launch the safari browser
        } else if (browserType.equalsIgnoreCase("opera")) {
            //code to launch the opera browser
        } else if (browserType.equalsIgnoreCase("edge")) {
            //code to launch the edge browser
        } else {
            System.out.println("Invalid browser specified.");
        }

        driver.get(appUrl);
        System.out.println("Title is: " + driver.getTitle());
        Thread.sleep(5000);
        driver.close();


    }


}
