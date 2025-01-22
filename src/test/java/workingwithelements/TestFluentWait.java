package workingwithelements;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestFluentWait 
{
	public WebDriver driver ; 

	@BeforeClass
	public void setUp() 
	{

		driver = new ChromeDriver(); 
		driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
	}

	@Test
	public void testImplicityWait() 
	{

		try {
			driver.findElement(By.linkText("Page 4")).click();

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(NoSuchElementException.class);

			WebElement message = wait
					.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(By.id("page4"));
						}
					});


			assertTrue(message.getText().contains("Nunc nibh tortor"));

		}

		finally {

		}
	}


	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}

}
