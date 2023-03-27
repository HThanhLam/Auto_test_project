package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class VerifyTestCasesPage {
	WebDriver driver;
//	page.Loginpage Loginpage;
	page.Homepage Homepage;

//	Userinfo Positive= new Userinfo("student","Password123");
//	Userinfo Negative_username= new Userinfo("student123","Password123");
//	Userinfo Negative_password= new Userinfo("student","Password");
	

	@Test
	public void Testcases_Test(){
		Homepage = new page.Homepage(driver);
		Homepage.testcases();
		String url= driver.getCurrentUrl();
		Assert.assertEquals(url.toLowerCase(), "https://automationexercise.com/test_cases", "account create fail!!!");
		String textcheck= driver.findElement(By.xpath("//section//h2/b")).getText();
		Assert.assertEquals(textcheck, "TEST CASES", "not show info:"+textcheck);		

	}

	
	@BeforeMethod
	public void beforeMethod() {
//		System.setProperty("webdriver.chrome.driver", "E:\\Learning\\Selenium\\Building\\chromedriver_110\\chromedriver.exe");
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
