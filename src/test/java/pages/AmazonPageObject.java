package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonPageObject {

	private By hamburgerMenu = By.xpath("//a[@id='nav-hamburger-menu']");
	private By tvAndAppliances = By.xpath("//div[contains(text(),'TV, Appliances, Electronics')]");
	private By tv = By.xpath("//a[contains(text(),'Televisions')]");
	private By samsung = By.linkText("Samsung");
	private By sortBy = By.xpath("//span[contains(text(),'Sort by:')]");
	private By highToLow = By.linkText("Price: High to Low");
	private By secondHighest = By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[3]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h2[1]/a[1]/span[1]");
	private By aboutThisItem = By.xpath("//h1[contains(text(),'About this item')]");
	private By getAboutThisItemContent = By.id("//div[@id='feature-bullets']");


	private WebDriver driver;

	public AmazonPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickHamburgerMenuButton() {

		try{
			driver.findElement(hamburgerMenu).click();

			System.out.println("Hamburger Button was Clicked");

		}
		catch(Exception e) 
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	public void ClickTvAndAppliances(){

		try{
			driver.findElement(tvAndAppliances).click();

			System.out.println("Tv and Appliances Button was Clicked");

		}
		catch(Exception e) 
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	public void ClickTelevision() {


		try{
			driver.findElement(tv).click();

			System.out.println("Television was clicked successfully");

		}
		catch(Exception e) 
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	public void FilterBySamsung () {

		try{
			driver.findElement(samsung).click();

			System.out.println("Filter for samsung was Clicked");

		}
		catch(Exception e) 
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	public void verifySamsungIsPresent(){
		if( driver.findElement(samsung).isDisplayed())
		{
			System.out.println("Samsung is Present");
		}else{
			System.out.println("Samsung is Absent");
		}
	}

	public void SortByDropDown() {

		try{
			driver.findElement(sortBy).click();

			System.out.println("Sort By button was Clicked");

		}
		catch(Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	public void SelectHighToLow() {

		try{
			driver.findElement(highToLow).click();

			System.out.println("High to Low was selected");

		}
		catch(Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	public void SelectSecondHighest() {

		try{
			driver.findElement(secondHighest).click();

			System.out.println("Second highest was clicked");

		}
		catch(Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	public void verifyAboutThisItemIsPresent(){
		if( driver.findElement(aboutThisItem).isDisplayed())
		{
			System.out.println("About this item is Present");
		}else{
			System.out.println("About this item is Absent");
		}
	}

	public void printAboutThisItemContent(){
		if( driver.findElement(aboutThisItem).isDisplayed())
		{
			System.out.println("About this item is Present");
		}else{
			System.out.println("About this item is Absent");
		}
	}
}







