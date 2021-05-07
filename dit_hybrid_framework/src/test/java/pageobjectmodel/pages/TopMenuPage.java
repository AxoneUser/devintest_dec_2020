package pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Karthik.Gandhinathan
 */
public class TopMenuPage {

    @FindBy(linkText = "Sign out")
    static WebElement lnkSignOut;

    public WebDriver driver;

    public TopMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage doLogout(){
        lnkSignOut.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }
}
