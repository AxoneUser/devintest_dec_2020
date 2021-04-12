package uk.axone.framework.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import uk.axone.framework.base.BaseTest;

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
public class SecondTestCase extends BaseTest {

    @BeforeTest
    public void setUpTest(){
        test = report.startTest("Second test");

    }

    @Test
    public void axonePortalTest() throws InterruptedException {

        reportInfo( "Launching the browser.");
        launchBrowser();

        reportInfo( "Navigating to the url.");
        navigateToUrl();
        Thread.sleep(5000);
        takeScreenshot();

        reportInfo( "clicking the sign in link.");
        clickElement("sign_in_xpath");

        reportInfo( "entering username value.");
        typeValues("username_id","karthik@axone-tech.uk");

        reportInfo( "entering login password.");
        typeValues("password_name","password");
        takeScreenshot();


        reportInfo( "clicking the submit login button.");
        clickElement("submit_btn_id");
        takeScreenshot();
        Thread.sleep(2000);
        reportFail("Submit login button is not appearing.");

        clickElement("signout_linkText");
        Thread.sleep(2000);

    }

    @AfterMethod
    public void tearDown(){
        report.endTest(test);
        report.flush();
        getDriver().quit();

    }
}
