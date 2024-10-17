package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {

	public WebDriver driver;
	
	public WebDriver webDriverManager() 
	{
	
		if(driver==null) //To initialize the driver only for once
		{	
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		
		return driver;
	}
}
