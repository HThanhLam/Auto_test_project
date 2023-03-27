package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import page.*;

public class LoginUserWithCorrectEmailAndPassword {
	WebDriver driver;
	Homepage homePage;
	Signup_login signup_login;
	page.loggedin_Homepage loggedin_Homepage;
	page.Account_deleted Account_deleted;
	   // Phai tao email truoc khi thu test case nay
    String email = "lam0123hgxyz@gmail.com";
    String password = "123456";
	
	@Test
    public void TC2_loginUserSuccessful() throws InterruptedException {
        homePage = new Homepage(driver);
        homePage.login();
        signup_login = new Signup_login(driver);
        Assert.assertEquals(signup_login.getSignInTitle().toLowerCase(),"login to your account","Tilte Sign Up");
        signup_login.login(email,password);
        String textcheck4= driver.findElement(By.cssSelector(".nav.navbar-nav li:nth-child(10) a")).getText();
		Assert.assertTrue(textcheck4.contains("Logged in as"), "not show info");		
		loggedin_Homepage = new page.loggedin_Homepage(driver);
		loggedin_Homepage.deleteaccount();
		closeGoogleAd();
		String textcheck5= driver.findElement(By.xpath("//div/h2/b")).getText();
		Assert.assertEquals(textcheck5, "ACCOUNT DELETED!", "wrong title:"+textcheck5);		
		Account_deleted = new page.Account_deleted(driver);
		Account_deleted.Continue();
    }
	
	@BeforeMethod
	public void beforeMethod() {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver_110\\chromedriver.exe");
//        driver = new ChromeDriver();
//		driver.manage().window().maximize();
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
	
	public void closeGoogleAd()
    {
        if(driver.getCurrentUrl().contains("#google_vignette"))
        {
            //System.out.println(driver.findElements(By.xpath("/html/ins/div/iframe")).size());
            WebElement iframe = driver.findElement(By.xpath("/html/ins/div/iframe"));

            driver.switchTo().frame(iframe);

            if (driver.findElements(By.id("dismiss-button")).size() > 0) {
                driver.findElement(By.id("dismiss-button")).click();
            } else {
                driver.switchTo().frame("ad_iframe");
                driver.findElement(By.id("dismiss-button")).click();
            }
            driver.switchTo().defaultContent();
        }
    }


}
