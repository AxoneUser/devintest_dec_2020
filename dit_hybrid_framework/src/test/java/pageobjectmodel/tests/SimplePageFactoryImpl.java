package pageobjectmodel.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Karthik.Gandhinathan
 */
public class SimplePageFactoryImpl {

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    static WebElement lnkSignIn;

    @FindBy(id = "email")
    static WebElement txtEmail;

    @FindBy(name = "passwd")
    static WebElement txtPassword;

    @FindBy(id = "SubmitLogin")
    static WebElement btnSubmit;

    @FindBy(linkText = "Sign out")
    static WebElement lnkSignOut;

    public static void clickSignInButton(){
        lnkSignIn.click();
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        Thread.sleep(2000);

        PageFactory.initElements(driver, SimplePageFactoryImpl.class);
        lnkSignIn.click();
        Thread.sleep(2000);

        txtEmail.sendKeys("karthik@axone-tech.uk");
        txtPassword.sendKeys("password");
        btnSubmit.click();
        Thread.sleep(2000);

        lnkSignOut.click();
        Thread.sleep(2000);

        driver.quit();
    }

}
