package pages;

import org.openqa.selenium.WebDriver;

public class URL {
	private WebDriver driver = null;
	/* Used only for amazon */
	String AmazonUrl() {
		String BASE_URL = "https://www.amazon.in";
		String urlPath = "/";
		return BASE_URL + urlPath;
	}

	public void launchURL(){
		driver.get(AmazonUrl());
		driver.manage().window().maximize();
	}


}
