package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loggedin_Homepage {
	WebDriver driver;
	By btnDeleteaccount = By.cssSelector(".fa.fa-trash-o");
	WebDriverWait Wait;
	public loggedin_Homepage(WebDriver driver) {
		this.driver = driver;
	}

	public void deleteaccount() {
		driver.findElement(btnDeleteaccount).click();
	}
}
