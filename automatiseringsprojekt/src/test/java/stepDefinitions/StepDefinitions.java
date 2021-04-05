package stepDefinitions;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import common.Randomizer;

public class StepDefinitions {

	private WebDriver driver;
	private Randomizer rndm;
	private WebElement result;

	@Given("I have opened {string} , navigated to https:\\/\\/login.mailchimp.com\\/signup\\/")
	public void i_have_opened_navigated_to_https_login_mailchimp_com_signup(String browser) {

		DriveCreator creator = new DriveCreator();
		driver = creator.createBrowser(browser);
		driver.get("https://login.mailchimp.com/signup/");
		driver.manage().window().maximize();

	}

	@Given("I have input {string}")
	public void i_have_input(String email) {
		WebElement input = driver.findElement(By.id("email"));
		rndm = new Randomizer();
		email = rndm.mail(email);
		input.sendKeys(email);
	}

	@Given("I input {string}")
	public void i_input(String username) {
		WebElement input = driver.findElement(By.id("new_username"));
		username = rndm.user(username);
		input.sendKeys(username);
	}

	@Given("I also input {string}")
	public void i_also_input(String password) {
		WebElement input = driver.findElement(By.id("new_password"));
		input.sendKeys(password);

	}

	@When("I press Sign Up")
	public void i_press_sign_up() {

		WebElement signUp = driver.findElement(By.id("create-account"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signUp);
		signUp.click();
	}

	@Then("the correct {string} should be shown on the screen")
	public void the_correct_should_be_shown_on_the_screen(String message) {

		if (message.equals("Check your email")) {
			result = driver.findElement(By.cssSelector(".\\!margin-bottom--lv3"));

		} else {
			result = driver.findElement(By.cssSelector(".invalid-error"));

		}

		assertEquals(message, result.getAttribute("innerText"));
		System.out.println(result.getAttribute("innerText") + " = " + message);

		driver.quit();
	}

}
