package uk.axone.framework.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import uk.aoxne.framework.report.ExtentReportManager;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * Abstracts out all the common tasks performed in every test script.
 *
 * @author Karthik.Gandhinathan
 */
public class BaseTest {

    public ExtentReports report = ExtentReportManager.getInstance();
    public ExtentTest test;

    /** WebDriver Instance. */
    private WebDriver driver;
    /** Properties Instance. */
    public Properties prop;


    /**
     * default constructor which loads the config.properties.
     */
    public BaseTest() {
        //accessing the file path
        String path = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        //create an empty property list
        prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream(path);
            //load the property
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * getDriver
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * method to launch a browser of user's choice.
     */
    public void launchBrowser() {
        String browserType = prop.getProperty("browserType");
        if (browserType.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println("Invalid browser specified.");
        }

        //maximize the window
        driver.manage().window().maximize();
    }

    /**
     * method that helps to navigate to given url.
     */
    public void navigateToUrl() {
        String urlToNavigate = prop.getProperty("applicationUrl");
        driver.navigate().to(urlToNavigate);
    }

    /**
     * Identifies the web element.
     * @param locatorKey - key to specify the locator.
     * @return WebElement.
     */
    public WebElement identifyElement(final String locatorKey) {
        String elementValue = prop.getProperty(locatorKey);
        WebElement element = null;

        if (locatorKey.endsWith("xpath")) {
            element = driver.findElement(By.xpath(elementValue));
        } else if (locatorKey.endsWith("css")) {
            element = driver.findElement(By.cssSelector(elementValue));
        } else if (locatorKey.endsWith("id")) {
            element = driver.findElement(By.id(elementValue));
        } else if (locatorKey.endsWith("name")) {
            element = driver.findElement(By.name(elementValue));
        } else if (locatorKey.endsWith("tagName")) {
            element = driver.findElement(By.tagName(elementValue));
        } else if (locatorKey.endsWith("linkText")) {
            element = driver.findElement(By.linkText(elementValue));
        } else if (locatorKey.endsWith("partialLinkText")) {
            element =  driver.findElement(By.partialLinkText(elementValue));
        } else if (locatorKey.endsWith("className")) {
            element = driver.findElement(By.className(elementValue));
        } else {
            System.out.println("Invalid locator specified");
        }

        return element;
    }

    /**
     * method to click any WebElement.
     * @param locatorKey
     */
    public void clickElement(final String locatorKey){
        identifyElement(locatorKey).click();
    }

    /**
     * Method to simulate the sendkeys.
     *
     * @param locatorKey
     * @param valueToType
     */
    public void typeValues(final String locatorKey, final String valueToType){
        identifyElement(locatorKey).sendKeys(valueToType);
    }

    //ui validations

    //screenshot

    /**
     * Take full page screenshot.
     */
    public void takeScreenshot(){

        Date d = new Date();
        String fileName = d.toString().replace(" ", "_").replace(":", "_") + ".png";
        String screenshotpath = SystemUtils.getUserDir()+"/target/screenshots/"+fileName;

        //1. Taking the screenshot image.
        Screenshot screenshot = new AShot()
            .shootingStrategy(ShootingStrategies.viewportPasting(1000))
            .takeScreenshot(driver);
        //2. To save in the desired folder
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File(screenshotpath));
            test.log(LogStatus.INFO, "Snapshot attached below: " + test.addScreenCapture(screenshotpath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //reporting
    public void reportInfo(final String infoMessage){
        test.log(LogStatus.INFO,infoMessage);
    }

    public void reportFail(final String failMessage){
        test.log(LogStatus.FAIL,failMessage);
        takeScreenshot();
    }


    public void reportPass(final String passMessage){
        test.log(LogStatus.PASS,passMessage);
    }



}
