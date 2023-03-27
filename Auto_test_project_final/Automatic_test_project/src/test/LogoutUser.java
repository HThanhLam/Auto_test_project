package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	
public class LogoutUser {
	
	WebDriver driver;
//	page.Loginpage Loginpage;
	page.Homepage Homepage;
	page.Signup_login Signup_login;
	page.loggedin_Homepage loggedin_Homepage;

//	Userinfo Positive= new Userinfo("student","Password123");
//	Userinfo Negative_username= new Userinfo("student123","Password123");
//	Userinfo Negative_password= new Userinfo("student","Password");
	
	
	@Test
	public void Logout() {
		Homepage = new page.Homepage(driver);
		String url1= driver.getCurrentUrl();
		Assert.assertEquals(url1.toLowerCase(), "https://automationexercise.com/", "not homepage!!!");
		Homepage.login();
		String url= driver.getCurrentUrl();
		String text1= driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]")).getText();
		Assert.assertEquals(url.toLowerCase(), "https://automationexercise.com/login", "page transition fail!!!");
		Assert.assertEquals(text1, "Login to your account", "wrong title:"+text1);		
		Signup_login= new page.Signup_login(driver);
		Signup_login.login("daothutrang.httt@gmail.com","Trangabcxyz");
		String text2= driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")).getText();
		Assert.assertEquals(text2.toLowerCase(), "logged in as dao thu trang", "Logged unsuccessful!!");
		loggedin_Homepage = new page.loggedin_Homepage(driver);
		loggedin_Homepage.Logout();
		Assert.assertEquals(url.toLowerCase(), "https://automationexercise.com/login", "Logout fail!!!");
		
	}
	

	@BeforeMethod
	public void beforeMethod() {
//		System.setProperty("webdriver.chrome.driver", "F:\\SETUP\\Automation Test\\chromedriver_win32\\chromedriver.exe");
//        ChromeOptions option = new ChromeOptions();
//        option.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(option);
//		driver.get("https://automationexercise.com/");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
		driver.get("https://automationexercise.com/");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
	

