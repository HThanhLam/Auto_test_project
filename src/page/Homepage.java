package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
	WebDriver driver;
	By btnLogin = By.cssSelector(".fa.fa-lock");
	By btnTestcases = By.cssSelector(".fa.fa-list");
    By contactLink = By.xpath("//a[normalize-space()='Contact us']");

	WebDriverWait Wait;
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login() {
		driver.findElement(btnLogin).click();
	}
	public void testcases() {
		driver.findElement(btnTestcases).click();
	}
	
	public ContactPage openContactPage() {
       driver.findElement(contactLink).click();
        return new ContactPage(driver);
    }
	public boolean verifyThatLandedToHomepage()
	{
		return driver.getCurrentUrl().equals("https://automationexercise.com/");
	}

}
