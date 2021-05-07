package pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjectmodel.base.BasePage;

/**
 * @author Karthik.Gandhinathan
 */
public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    static WebElement lnkSignIn;

    public LoginPage clickAndNavToLoginPage(){
        lnkSignIn.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }


    public HomePage(WebDriver driver) {
        super(driver);
    }
}
