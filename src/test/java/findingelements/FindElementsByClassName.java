package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementsByClassName {

    WebDriver driver ;

    @BeforeTest
    public void driverExe(){
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");


    }


    @Test(priority = 3)
    public void findElementsByClassName(){
        try{
            WebElement btn =  driver.findElement(By.className("radius"));
            System.out.println(btn.getText());

        } catch (NoSuchElementException e){
            System.out.println("No Element Found ");
        }

    }


    @AfterTest
    public void closeDriver()
    {
        driver.quit();
    }
}
