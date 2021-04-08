
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/** * @author Karthik.Gandhinathan */
public class TestAssignment4 {

    public WebDriver driver;

    private static final String URL = "http://the-internet.herokuapp.com/tables";

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().driverVersion("86.0.4240.183").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(priority=0)
    public void testSortingDuesColumn() throws InterruptedException, IOException {
        Thread.sleep(3000);
        // sort dues column in ascending order
        driver.findElement(By.xpath("//*[@id='table1']//thead//th[4]")).click();

        // get values from dues column
        List<WebElement> dues = driver.findElements(By.xpath("//*[@id='table1']//tbody/tr/td[4]"));
        List<Double> dueValues = new ArrayList<Double>();
        for (WebElement element : dues) {
            // converting the string due value to double
            dueValues.add(Double.parseDouble(element.getText().replace("$", "")));
        }
        boolean isDuesListAsc = true;
        for (int i = 0; i < dueValues.size() - 1; i++) {
            if (dueValues.get(i + 1) < dueValues.get(i)) {
                isDuesListAsc = false;
                break;
            }

        }

        // print them
        System.out.println(dueValues);

        Assert.assertTrue(isDuesListAsc);
        Thread.sleep(3000);
    }

    @Test(priority=1)//dependsOnMethods="testSortingDuesColumn"
    public void testEmailSorting() throws InterruptedException {
        Thread.sleep(3000);
        // sort email column in ascending order
        driver.findElement(By.xpath("//*[@id='table1']//thead//th[3]")).click();

        // get values from email column
        List<WebElement> emails = driver.findElements(By.xpath("//*[@id='table1']//tbody/tr/td[3]"));

        ArrayList<String> emailText = new ArrayList<>();
        for (WebElement element : emails) {
            emailText.add(element.getText());
        }

        SortedSet<String> emailTextCopy = new TreeSet<>(emailText);
        System.out.println(emailText);
        System.out.println(emailTextCopy);
        Assert.assertEquals(emailText, emailTextCopy);
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
