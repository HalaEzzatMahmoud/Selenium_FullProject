package workingwithelements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CheckAllBrokenLinks 
{
	public WebDriver driver ;

	private int invalidLinks;

	@BeforeClass
	public void setUp() 
	{

		driver = new ChromeDriver(); 
		driver.navigate().to("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void testBrokenLinks() 
	{
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		System.out.println("Total Links are: "+ linksList.size());
		for (WebElement linkElement : linksList)
		{
			if(linkElement != null) {
				VerifyLink(linkElement);
			}

		}
		System.out.println("Total no. of invalid links are : " + invalidLinks);
	}


	public void VerifyLink(WebElement link)
	{
		try {
			String url = link.getAttribute("href");
			URL urllink = new URL(url);
			// create a connection using URL object
			HttpURLConnection httpConn = (HttpURLConnection) urllink.openConnection();
			httpConn.setConnectTimeout(2000);
			httpConn.connect();
			
			// use getResponseCode() to get the response code
			if(httpConn.getResponseCode() == 200) {
				System.out.println(url + " - " + httpConn.getResponseMessage());
			}
			if (httpConn.getResponseCode() == 404) {
				System.out.println(url+" - "+httpConn.getResponseMessage());
				invalidLinks++;
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}

}
