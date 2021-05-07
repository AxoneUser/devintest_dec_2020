package pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjectmodel.base.BasePage;

/**
 * @author Karthik.Gandhinathan
 */
public class LaunchPage extends BasePage {

    public LaunchPage(WebDriver driver) {
        super(driver);
    }

    public HomePage navToHomePage(String urlToNavigate){
        driver.get(urlToNavigate);
        return PageFactory.initElements(driver, HomePage.class);
    }
}
