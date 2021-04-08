import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class RediffMoney_Solution {
	public WebDriver driver;

	String URL = "https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose";

	@BeforeClass
	public void setup() {
		//WebDriverManager.chromedriver().driverVersion("86.0.4240.183").setup();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
	}

	@Test
	public void rediffMoneyWebTable() {
		List<WebElement> companyNames = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		List<WebElement> currentPrices = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		System.out.println("Total Number of Companies in GroupA is "+companyNames.size());

		for (int i = 0; i < companyNames.size(); i++) {
			System.out.println("Company Name: " + companyNames.get(i).getText() + "--------Current Prices: "
					+ currentPrices.get(i).getText());

		}
		int output = getRowWithCellText("CARE Ratings");
		System.out.println("CARE Ratings is found at row number " + output);
		output = getRowWithCellText("Pfizer Ltd.");
		System.out.println("Pfizer Ltd. is found at row number " + output);
	}

	private int getRowWithCellText(String cellDataToFind) {
		int rowWithCellText = 0;
		// get the row size
		int rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size();
		// get the col size
		//int cols = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td")).size();
		// loop through rows remember to start from tr[1] and fetch the td in
		// each row
		// loop through each cell of a row
		for (int rowNum = 1; rowNum <= rows; rowNum++) {
			// get all the cells
			List<WebElement> rowCells = driver
					.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[" + rowNum + "]/td"));
				// compare each cell data with the passed in cellDataToFind
				if (rowCells.get(0).getText().trim().equalsIgnoreCase(cellDataToFind)) {
					// if it matches return the row number and break the routine
					rowWithCellText = rowNum;
					break;
				}
		}

		return rowWithCellText;
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
