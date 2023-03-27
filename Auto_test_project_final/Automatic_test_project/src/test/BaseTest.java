package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver_110\\chromedriver.exe");
        
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
        
        driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
