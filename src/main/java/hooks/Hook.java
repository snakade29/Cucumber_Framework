package hooks;

import org.openqa.selenium.WebDriver;

import factory.BrowserFactory;
import helper.Utility;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

	
	WebDriver driver;

	
	@Before
	public void startBrowser()
	{
		System.out.println("LOG:INFO - Before Hooks - Setting up browser");
		
		BrowserFactory browserFactory=new BrowserFactory();
		
		driver=browserFactory.init_driver("Chrome");
		
		System.out.println("LOG:INFO - Before Hooks - Browser is setup");
	}
	
	@After
	public void closeBrowser()
	{
		System.out.println("LOG:INFO - After Hooks - Closing the browser");
		driver.quit();
		System.out.println("LOG:INFO - After Hooks - Browser terminated");
	}
	
	@AfterStep
	public void tearDown(Scenario scenario)
	{
		
		System.out.println("LOG:INFO - After Steps - Running for steps");
		
		String name=scenario.getName();
		
		byte []screenshot=Utility.captureScreenshotInByte(driver);
		
		scenario.attach(screenshot, "image/png", name);
		
		/*if(scenario.isFailed())
		{
			String name=scenario.getName();
			
			byte []screenshot=Utility.captureScreenshotInByte(driver);
			
			scenario.attach(screenshot, "image/png", name);
		}
		*/
		
	
	}
		
}
