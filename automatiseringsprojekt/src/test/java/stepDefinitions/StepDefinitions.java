package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private WebDriver driver;

		@Given("I have opened {string} and navigated to https:\\/\\/login.mailchimp.com\\/signup\\/")
		public void i_have_opened_and_navigated_to_https_login_mailchimp_com_signup(String browser) {
		    
			DriveCreator creator = new DriveCreator();
			driver = creator.createBrowser(browser);
			driver.get("https://login.mailchimp.com/signup/");
		}


		@Given("I have input ")
		public void i_have_input() {
		    
		}
		
		@Given("I input ")
		public void i_input() {
		    
		}
		
		@When("I press Sign Up")
		public void i_press_sign_up() {
		    
		}
		
		@Then("the correct  should be shown on the screen")
		public void the_correct_should_be_shown_on_the_screen() {
		    
			driver.quit();
		}
	
	
	
}
