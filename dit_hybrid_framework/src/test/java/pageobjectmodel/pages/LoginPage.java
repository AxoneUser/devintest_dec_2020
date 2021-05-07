package pageobjectmodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjectmodel.base.BasePage;
import pageobjectmodel.constants.LoginPageConstants;

/**
 * @author Karthik.Gandhinathan
 */
public class LoginPage extends BasePage {

    @FindBy(id = LoginPageConstants.EMAIL_TXT)
    static WebElement txtEmail;

    @FindBy(name = LoginPageConstants.PASSWORD_TXT)
    static WebElement txtPassword;

    @FindBy(id = LoginPageConstants.SUBMIT_BTN)
    static WebElement btnSubmit;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountsPage doLoginAndNavToMyAccsPage(String userName, String password){
        txtEmail.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnSubmit.click();
        return PageFactory.initElements(driver, MyAccountsPage.class);
    }


}
