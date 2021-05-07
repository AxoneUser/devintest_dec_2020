package pageobjectmodel.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjectmodel.pages.*;

import java.util.concurrent.TimeUnit;

/**
 * @author Karthik.Gandhinathan
 */
public class AxoneShoppingCartTest {

    public WebDriver driver;

    @BeforeTest
    public void setUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void tetPracticePortal(){
        LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
        HomePage homePage = launchPage.navToHomePage("http://seleniumpractice.axone-tech.uk/index.php");
        LoginPage loginpage = homePage.clickAndNavToLoginPage();
        MyAccountsPage myAccpage = loginpage.doLoginAndNavToMyAccsPage("karthik@axone-tech.uk", "password");
        IdentityPage identityPage = myAccpage.navToIdentityPage();
        identityPage.topMenuPage.doLogout();

    }

    @AfterTest
    public void tearDownBrowser(){
        driver.quit();
    }


}
