package pageobjectmodel.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjectmodel.pages.TopMenuPage;

/**
 * Any common tasks within pages.
 *
 * @author Karthik.Gandhinathan
 */
public class BasePage {

    public WebDriver driver;
    public TopMenuPage topMenuPage;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        topMenuPage = PageFactory.initElements(driver, TopMenuPage.class);
    }
}
