package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup_login {
	WebDriver driver;

	By txtEmailAddress = By.xpath("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[2]");
	By txtPassword = By.xpath("//body/section[@id='form']/div[1]/div[1]/div[1]/div[1]/form[1]/input[3]");
	By btnLogin = By.xpath("//button[contains(text(),'Login')]");
	By txtError = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
	//
	
	WebDriverWait Wait;
	public Signup_login(WebDriver driver) {
		this.driver = driver;
	}

	public void Login(String emailaddress,String password) {
		driver.findElement(txtEmailAddress).sendKeys(emailaddress);
		driver.findElement(txtPassword).sendKeys(password);
		driver.findElement(btnLogin).click();
	}
	
	public String getError() {
		WebElement element = driver.findElement(txtError);
		return element.getText();
	}

}
