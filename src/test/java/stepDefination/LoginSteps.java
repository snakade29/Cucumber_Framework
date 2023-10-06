package stepDefination;

import org.junit.Assert;

import factory.BrowserFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {

	LoginPage login;
	
	@Given("User is able to open the application")
	public void user_is_able_to_open_the_application() 
	{
		login=new LoginPage(BrowserFactory.getDriver());
		BrowserFactory.getDriver().get("https://ineuron-courses.vercel.app/login");
	}

	@Given("User is able to land on home page with all elements")
	public void user_is_able_to_land_on_home_page_with_all_elements() 
	{
		Assert.assertTrue(login.getSocialMediaCount()==4);
	}

	@When("User enter username  {string}")
	public void user_enter_username(String user) {
		login.enterUsername(user);
	}

	@When("enter password {string}")
	public void enter_password(String pass) {
		login.enterPassword(pass);
	}

	@When("click on login button")
	public void click_on_login_button() {
		login.clickOnLoginButton();
	}

	@Then("User should be able to login")
	public void user_should_be_able_to_login() {
		Assert.assertTrue(login.verifyDashboard());
	}

}
