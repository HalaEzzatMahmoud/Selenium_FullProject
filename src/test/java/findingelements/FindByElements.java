package findingelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindByElements {

	WebDriver driver ;

	@BeforeTest
	public void driverExe(){
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");


	}
	
	@Test
	public void testFindElements() 
	{
		// Get All the links displayed on Page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		//Verify there are 41 Links displayed on the page
		Assert.assertEquals(2, links.size());
		
		// Print each link value
		for (WebElement link : links) {
			System.out.println(link.getAttribute("href"));
		}
	}

	@AfterTest
	public void closeDriver(){
		driver.quit();
	}
	
}
