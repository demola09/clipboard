package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class NavigateToURL {
		private WebDriver driver;
		private URL baseUrl = new URL();

		public NavigateToURL(WebDriver driver) {
			this.driver = driver;
		}
		public void launchURL() {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(baseUrl.AmazonUrl());
			driver.manage().window().maximize();
						
			System.out.println("Url Launched Successfully");
		}
	}

