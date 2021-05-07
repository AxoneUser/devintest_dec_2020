package uk.axone.coreaxoneframework.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SingleWindow {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitest.automationtester.uk/window-popup-modal-demo.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSingleWindows() throws InterruptedException, IOException {
        handleSingleWindow("//a[contains(text(),'Follow On Twitter')]");
        handleSingleWindow("//a[contains(text(),'Like us On Facebook')]");
    }

    private void handleSingleWindow(final String elementText) throws InterruptedException, IOException {
            driver.findElement(By.xpath(elementText)).click();
            Thread.sleep(2000);
            String parent = driver.getWindowHandle();
            // This will return the number of windows opened by Webdriver and will
            // return Set of Strings
            Set<String> s1 = driver.getWindowHandles();
            System.out.println("Number of windows opened "+s1.size());

            // Now we will iterate using Iterator
            Iterator<String> I1 = s1.iterator();
            while (I1.hasNext()) {
                String child_window = I1.next();
                // Here we will compare if parent window is not equal to child
                // window then we will close
                if (!parent.equals(child_window)) {
                    driver.switchTo().window(child_window);
                    System.out.println(driver.switchTo().window(child_window).getTitle());
                    driver.close();
                }
            }
        driver.switchTo().window(parent);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
