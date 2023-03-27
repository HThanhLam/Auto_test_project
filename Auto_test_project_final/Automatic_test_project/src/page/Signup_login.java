package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Signup_login {
	WebDriver driver;
	By txtUsername = By.xpath("//form[@action='/signup']/input[2]");
	By txtEmail = By.xpath("//form[@action='/signup']/input[3]");
	By btnSignup = By.cssSelector("div.signup-form button");
	By signUpTile = By.cssSelector("div[class='signup-form'] h2");	WebDriverWait Wait;
	By errorSignUpMessage = By.cssSelector(".signup-form p");
    By loginTile = By.cssSelector("div[class='login-form'] h2");
    By loginEmailInput = By.xpath("//input[@data-qa='login-email']");
    By loginPasswordInput = By.xpath("//input[@placeholder='Password']");
    By loginButton = By.xpath("//button[normalize-space()='Login']");
	By txtErrorlogin = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");



	public Signup_login(WebDriver driver) {
		this.driver = driver;
	}

	public void signup(String username,String email) {
		driver.findElement(txtUsername).sendKeys(username);
		driver.findElement(txtEmail).sendKeys(email);
		driver.findElement(btnSignup).click();
	}
	
	public void signIn(String username,String email) {
		driver.findElement(txtUsername).sendKeys(username);
		driver.findElement(txtEmail).sendKeys(email);
		driver.findElement(btnSignup).click();
	}
	
	public String getSignUpTitle()
	{
		return driver.findElement(signUpTile).getText();
	}
	
	public String getSignInTitle()
	{
		return driver.findElement(loginTile).getText();
	}
	
	public String getErrorSignUpMessage()
    {
        return driver.findElement(errorSignUpMessage).getText();
    }
	
	public void login(String email, String password)
    {
        driver.findElement(loginEmailInput).sendKeys(email);
        driver.findElement(loginPasswordInput).sendKeys(password);
        driver.findElement(loginButton).click();;
    }
	public String getError() {
		return driver.findElement(txtErrorlogin).getText();
	}

}
