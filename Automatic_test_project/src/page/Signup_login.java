package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup_login {
	WebDriver driver;
	By txtUsername = By.xpath("//form[@action='/signup']/input[2]");
	By txtEmail = By.xpath("//form[@action='/signup']/input[3]");
	By btnSignup = By.cssSelector("div.signup-form button");
	WebDriverWait Wait;
	public Signup_login(WebDriver driver) {
		this.driver = driver;
	}

	public void signup(String username,String email) {
		driver.findElement(txtUsername).sendKeys(username);
		driver.findElement(txtEmail).sendKeys(email);
		driver.findElement(btnSignup).click();
	}
}
