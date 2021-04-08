package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.Randomizer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private WebDriver driver;
	private Randomizer rndm;
	private WebElement result;

	@Given("I have opened {string} , navigated to https:\\/\\/login.mailchimp.com\\/signup\\/")
	public void i_have_opened_navigated_to_https_login_mailchimp_com_signup(String browser) {

		DriveCreator creator = new DriveCreator();
		// Bestämmer browser utifrån feature filen
		driver = creator.createBrowser(browser);
		// Sidan vi ska testa
		driver.get("https://login.mailchimp.com/signup/");
		// Maximerar fönster
		driver.manage().window().maximize();
		// Accepterar cookies
		click(driver, By.id("onetrust-accept-btn-handler"));
		//Om cookies envisas med att dyka upp igen så klickar vi en gång till
		if(driver.findElement(By.id("onetrust-accept-btn-handler")).isDisplayed()) {
			click(driver, By.id("onetrust-accept-btn-handler"));
		}

	}

	@Given("I have input {string}")
	public void i_have_input(String email) {
		// Hittar email fältet
		WebElement input = driver.findElement(By.id("email"));
		// nytt objekt av klassen Randomizer för att komma åt random email/username
		rndm = new Randomizer();
		// ger oss ett random email
		email = rndm.mail(email);
		// email matas in
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
		// scrolla ner och klickar på att skapa konto
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.id("create-account")));
		click(driver, By.id("create-account"));

	}

	@Then("the correct {string} should be shown on the screen")
	public void the_correct_should_be_shown_on_the_screen(String message) {
		// Kontrollerar meddelande vi får upp efter sign up
		if (message.equals("Check your email")) {
			result = driver.findElement(By.cssSelector(".\\!margin-bottom--lv3"));

		} else {
			result = driver.findElement(By.cssSelector(".invalid-error"));

		}
		// jämför vårt meddelande ifrån featurefilen med meddelande/felmeddelande som
		// visas efter sign up
		assertEquals(message, result.getAttribute("innerText"));
		// Matar ut och jämför så att det verkligen blir rätt
		System.out.println(result.getAttribute("innerText") + " = " + message);

		driver.quit();
	}

	public static void click(WebDriver driver, By by) {

		(new WebDriverWait(driver, 10)).until(ExpectedConditions.

				elementToBeClickable(by));

		driver.findElement(by).click();

	}

}