package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import page.*;

public class RegisterUserWithExistingEmail {
	WebDriver driver;
	Homepage homepage;
	Signup_login signup_login;
	
    String registeredName = "nhl1";
    String registeredEmailAddress = "nhl12@gmail.com";
    
	@Test
    public void TC5_registerUserWithExistingEmail()
    {
        homepage = new Homepage(driver);
        homepage.login();
        signup_login = new Signup_login(driver);
        Assert.assertTrue(signup_login.getSignUpTitle().contains("New User Signup!"),"Tilte Sign Up wrong");
        signup_login.signup(registeredName,registeredEmailAddress);
        Assert.assertEquals(signup_login.getErrorSignUpMessage(),"Email Address already exist!");
    }
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
