package uk.axone.dockergrid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowDockerSeleniumWorks {

    @Parameters({"browserType"})
    @Test
    public void testDockerGridParallelExecution(final String browser) throws MalformedURLException, InterruptedException {
        URL remoteAddress = new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (browser.equalsIgnoreCase("chrome")){
            capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
            capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
        } else if (browser.equalsIgnoreCase("firefox")){
            capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
            capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
        }

        WebDriver driver = new RemoteWebDriver(remoteAddress, capabilities);
        driver.get("http://uitest.automationtester.uk/");
        System.out.println(driver.getTitle());
        Thread.sleep(20000);
        driver.quit();
    }

}
