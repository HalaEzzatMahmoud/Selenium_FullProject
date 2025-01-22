package findingelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBrowserCommands {

	WebDriver driver ;

	@BeforeTest
	public void driverExe(){
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com");


	}

	@Test
	public void testBrowserCommands() 
	{
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().refresh();
		System.out.println(driver.getCurrentUrl());

	}

	@AfterTest
	public void closeDriver() {
		driver.quit();
	}

}
