package uk.axone.seleniumgrid;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowGridWorks {

    @Test
    public void testSeleniumGrid() throws MalformedURLException, InterruptedException {
        URL remoteAddress = new URL("http://10.37.129.2:4444/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
        capabilities.setCapability(CapabilityType.BROWSER_VERSION, "90.0.4430.72");

        WebDriver driver = new RemoteWebDriver(remoteAddress, capabilities);
        driver.get("http://uitest.automationtester.uk/");
        System.out.println(driver.getTitle());
        Thread.sleep(10000);
        driver.quit();
    }
}
