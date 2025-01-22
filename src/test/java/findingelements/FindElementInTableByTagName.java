package findingelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementInTableByTagName {

	WebDriver driver ;

	@BeforeTest
	public void driverExe(){
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");
	}

	@Test
	public void testFindByTageName() 
	{
		WebElement table = driver.findElement(By.id("table1"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.get(3).getText());
	}
	
	@AfterTest
	public void closeDriver() 
	{
		driver.quit();
	}
	
}
