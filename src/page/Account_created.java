package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Account_created {
	WebDriver driver;
	By btnContinue = By.xpath("//a[@data-qa='continue-button']");
	WebDriverWait Wait;
	public Account_created(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Continue() {
		driver.findElement(btnContinue).click();
	}

}
