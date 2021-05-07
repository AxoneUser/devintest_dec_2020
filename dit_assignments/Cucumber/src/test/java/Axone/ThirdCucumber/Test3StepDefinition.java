package Axone.ThirdCucumber;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test3StepDefinition {

    WebDriver driver;

    String text, text2;

    @Given("User can Launch Browser")
    public void user_can_Launch_Browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("User can Launch Browser");
    }

    @And("Navigate to the following website")
    public void navigate_to_the_following_website() {
        driver.get("http://seleniumpractice.axone-tech.uk");
        System.out.println("Navigate to the following website");
    }

    @When("I Click Sign-in link")
    public void i_Click_Sign_in_link() {
        driver.findElement(By.linkText("Sign in")).click();
        System.out.println("I Click Sign-in link");
    }

    @And("Enter UserName \"(.*)\" and Password \"(.*)\"")
    public void enter_UserName_and_Password(String string, String string2) throws InterruptedException {
        System.out.println(string);
        System.out.println(string2);
        Thread.sleep(5000);
        driver.findElement(By.id("email")).sendKeys(string);
        driver.findElement(By.id("passwd")).sendKeys(string2);
        driver.findElement(By.id("SubmitLogin")).click();
        System.out.println("Entered login credentials and logged in");
    }

    @Then("Verify that you have logged in successfully")
    public void verify_that_you_have_logged_in_successfully() throws InterruptedException {
        Thread.sleep(5000);
        text = driver
                .findElement(By.xpath(
                        "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"))
                .getText();
        if (text.equalsIgnoreCase("Karthik gandhinathan")) {
            System.out.println("Logged in successfully");
        }
    }

    @And("Click on Logout")
    public void click_on_Logout() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.linkText("Sign out")).click();
        System.out.println("Clicked on Logout");
    }

    @Then("Verify that you have logged out of the application")
    public void verify_that_you_have_logged_out_of_the_application()
            throws InterruptedException {
        Thread.sleep(5000);
        text2 = driver
                .findElement(By.xpath(
                        "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"))
                .getText();

        if (text2.equalsIgnoreCase("Sign in")) {
            System.out.println("Logged out of the application successfully");
            Thread.sleep(2000);
            driver.close();
        }

    }

}
