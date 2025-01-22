package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindLinksByLinkText {

	WebDriver driver ;

	@BeforeTest
	public void driverExe(){
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");


	}

	@Test(priority = 1)
	public void textLinkText() 
	{
		WebElement seleniumLink = driver.findElement(By.linkText("Elemental Selenium"));
		System.out.println(seleniumLink.getAttribute("href"));	
	}
	
	@Test
	public void textLinkPartialText() 
	{
		WebElement seleniumLink = driver.findElement(By.partialLinkText("Elemental"));
		System.out.println(seleniumLink.getAttribute("href"));	
	}

	@AfterTest
	public void closeDriver() 
	{
		driver.quit();
	}
}
