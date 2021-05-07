package pageobjectmodel.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * 1. Launch the browser of user choice
 * 2. Navigate to axone practice portal
 * 3. Click on the sign-in link
 * 4. enter username
 * 5. enter password
 * 6. Click on the sign-in button
 * 7. validate the login.
 *
 * @author Karthik.Gandhinathan
 */
public class TestAxoneOnlinePortal {

    @Test
    public void testAxoneOnlinePortal() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("karthik@axone-tech.uk");
        driver.findElement(By.id("passwd")).sendKeys("password");
        Thread.sleep(2000);

        driver.findElement(By.id("SubmitLogin")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Sign out")).click();
        Thread.sleep(2000);

        driver.close();

    }

}
