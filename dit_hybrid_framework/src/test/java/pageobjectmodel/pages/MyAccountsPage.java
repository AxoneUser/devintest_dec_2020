package pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;
import pageobjectmodel.base.BasePage;

/**
 * @author Karthik.Gandhinathan
 */
public class MyAccountsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'My personal information')]")
    WebElement lnkPersonalInfo;

    @FindBy(xpath = "//span[contains(text(),'Order history and details')]")
    WebElement lnkOrderHistory;

    public MyAccountsPage(WebDriver driver) {
        super(driver);
    }

    public IdentityPage navToIdentityPage(){
        lnkPersonalInfo.click();
        return PageFactory.initElements(driver, IdentityPage.class);
    }

    public OrderHistoryPage navToOrderHistoryPage(){
        lnkOrderHistory.click();
        return PageFactory.initElements(driver, OrderHistoryPage.class);
    }
}
