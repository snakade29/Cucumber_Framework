package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //Step 1: Create a global driver
    WebDriver driver;

    // Step 2: Create a constructor as below which will be called the moment i create an object, and it will accept a driver

    public LoginPage(WebDriver driver){
        //Now i am assigning the constructor driver to the global driver above( which i now call: this.driver)
        this.driver = driver;
    }

    //Step 3: I can now create my locators using a By class

    By user = By.id("email1");
    By pass = By.name("password1");
    By login = By.xpath("//button[@class='submit-btn']");
    By signOut=By.xpath("//button[normalize-space()='Sign out']");
    
 
    By socialMediaIcons=By.xpath("//div[@class='social-btns']//a");
    
    
    public int getSocialMediaCount()
    {
    	return driver.findElements(socialMediaIcons).size();	
    }
    
    public void loginToApplication(String username , String password) {

            driver.findElement(user).sendKeys(username);
            driver.findElement(pass).sendKeys(password);
            driver.findElement(login).click();
        }
    
    public void enterUsername(String uname)
    {
    	driver.findElement(user).sendKeys(uname);
    		
    }
    
    public void enterPassword(String password)
    {
    	driver.findElement(pass).sendKeys(password);
 	
    }
    public void clickOnLoginButton()
    {
    	driver.findElement(login).click();
 	
    }
    
    public boolean verifyDashboard()
    {
    	return driver.findElement(signOut).isDisplayed();
    }
    
    
    }
