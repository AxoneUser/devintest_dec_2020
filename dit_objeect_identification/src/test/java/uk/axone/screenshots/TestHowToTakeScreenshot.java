package uk.axone.screenshots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowToTakeScreenshot {

    WebDriver driver;

    @BeforeTest
    public void setUpBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.bbc.co.uk/");
        Thread.sleep(5000);
    }


    @Test
    public void testTakeScreenshot() throws InterruptedException {
        //1. To taking screenshot and save it to a temporary file.
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //2. to store in a specified desired location
        try {
            FileUtils.copyFile(srcFile, new File(SystemUtils.getUserDir()+"/target/screenshots/bbc_ss.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void takeFullScreenshot(){

        //1. Taking the screenshot image.
        Screenshot screenshot = new AShot()
            .shootingStrategy(ShootingStrategies.viewportPasting(1000))
            .takeScreenshot(driver);
        //2. To save in the desired folder
        try {
            ImageIO.write(screenshot.getImage(), "PNG", new File(SystemUtils.getUserDir()+"/target/screenshots/FullPage_SS.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }


}
