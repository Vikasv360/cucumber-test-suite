package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

public class ResusableTestComponents {

	public WebDriver driver;
	public int NeededItemsSize;
	public PageObjectManager pageObjects;
	public TestBase testBase;
	
	public ResusableTestComponents(){
		
		testBase=new TestBase();
		pageObjects =new PageObjectManager(testBase.webDriverManager());
	}

}
