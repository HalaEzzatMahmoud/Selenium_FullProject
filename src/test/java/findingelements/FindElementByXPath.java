package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByXPath {

	WebDriver driver ;

	@BeforeTest
	public void driverExe(){
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");

	}

	@Test(enabled = true)
	public void xPath(){
		WebElement xpUsername = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		WebElement xpBtn = driver.findElement(By.xpath("//button[1]"));
		WebElement xpPassword= driver.findElement(By.xpath("//input[@id='password']")); //or using [@class='classname']
		System.out.println(xpPassword.getAttribute("name"));
		System.out.println(xpBtn.getAttribute("type"));
		System.out.println(xpUsername.getAttribute("name"));

	}
	
	@AfterTest
	public void closeDriver() 
	{
		driver.quit();
	}
	
}
