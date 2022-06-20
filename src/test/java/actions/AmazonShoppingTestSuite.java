package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AmazonPageObject;
import pages.NavigateToURL;
import pages.StartBrowser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonShoppingTestSuite {
	private static WebDriver driver = null;

	@BeforeTest
	public void startUp() throws IOException {

		StartBrowser openConnection = new StartBrowser(driver);

		driver = openConnection.initializeBrowser();
	}

	@Test(priority = 1)
	public void TestTvAppliances() throws InterruptedException {

		NavigateToURL startWebsite = new NavigateToURL(driver);

		startWebsite.launchURL();

		AmazonPageObject amazonPageObj = new AmazonPageObject(driver);

		amazonPageObj.ClickHamburgerMenuButton();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		amazonPageObj.ClickTvAndAppliances();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		amazonPageObj.ClickTelevision();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		amazonPageObj.FilterBySamsung();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(3000);

		amazonPageObj.verifySamsungIsPresent();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(3000);

		amazonPageObj.SortByDropDown();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		amazonPageObj.SelectHighToLow();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		List<WebElement> prices = driver.findElements(By.className("a-price-whole"));

		String[] beforeSort_price = new String[prices.size()];

		//Get the prices in to an array
		for(int i=0; i<prices.size(); i++) {
			beforeSort_price[i] = prices.get(i).getText().trim();
		}

		System.out.println("*****Before Sort Function*****");
		Print(beforeSort_price);

		driver.findElements(By.className("a-price-whole"));

		String[] afterSort_price = new String[prices.size()];

		//Get the prices in to an array
		for(int i=0; i<prices.size(); i++) {
			afterSort_price[i] = prices.get(i).getText().trim();
		}

		Assert.assertEquals(afterSort_price,beforeSort_price);
		System.out.println("*****Sort Verified Properly*****");

		String winHandleBefore = driver.getWindowHandle();

		amazonPageObj.SelectSecondHighest();

		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		amazonPageObj .verifyAboutThisItemIsPresent();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		WebElement about = driver.findElement(By.xpath("//div[@id='feature-bullets']"));
		String printAbout = about.getText();
		System.out.println(printAbout);
	}

	public static void Print(String[] pr) {
		for(int i =0 ; i<pr.length;i++) {
			System.out.println(pr[i]);
		}

	}

	@AfterTest

	public void TearDown() {
		driver.close();
		driver.quit();
		System.out.print("Amazon shopping Test Ran with status ");
	}

}






