package test;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterUser extends BaseTest{
	page.Homepage Homepage;
	page.Signup_login Signup_login;
	page.Account_signup Account_signup;
	page.Account_created Account_created;
	page.loggedin_Homepage loggedin_Homepage;
	page.Account_deleted Account_deleted;

//	Userinfo Positive= new Userinfo("student","Password123");
//	Userinfo Negative_username= new Userinfo("student123","Password123");
//	Userinfo Negative_password= new Userinfo("student","Password");
	

	@Test
	public void TestLogin() {
		Homepage = new page.Homepage(driver);
		String url1= driver.getCurrentUrl();
		Assert.assertEquals(url1.toLowerCase(), "https://automationexercise.com/", "not homepage!!!");
		Homepage.login();
		String url= driver.getCurrentUrl();
		String textcheck1= driver.findElement(By.cssSelector("div.signup-form h2")).getText();
		Assert.assertEquals(url.toLowerCase(), "https://automationexercise.com/login", "page transition fail!!!");
		Assert.assertEquals(textcheck1, "New User Signup!", "wrong title:"+textcheck1);		
		Signup_login= new page.Signup_login(driver);
		Signup_login.signup("username", "lam0123hgyzazy@gmail.com");
		String textcheck2= driver.findElement(By.cssSelector("div.login-form h2 b")).getText();
		Assert.assertEquals(textcheck2, "ENTER ACCOUNT INFORMATION", "wrong title:"+textcheck2);
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		Account_signup = new page.Account_signup(driver);		
		Account_signup.signup("male", "123456", 1, 10, 2000, "lam", "hoang", "nashtech", "dinhcong", "India", "hanoi", "hanoi","10000", "0943528238");
//	    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(4));
		String url2= driver.getCurrentUrl();
		Assert.assertEquals(url2.toLowerCase(), "https://automationexercise.com/account_created", "account create fail!!!");
		String textcheck3= driver.findElement(By.xpath("//div/h2/b")).getText();
		Assert.assertEquals(textcheck3, "ACCOUNT CREATED!", "wrong title:"+textcheck3);		
		Account_created = new page.Account_created(driver);
		Account_created.Continue();
		String textcheck4= driver.findElement(By.cssSelector(".nav.navbar-nav li:nth-child(10) a")).getText();
		Assert.assertEquals(textcheck4, "Logged in as username", "not show info:"+textcheck4);		
		loggedin_Homepage = new page.loggedin_Homepage(driver);
		loggedin_Homepage.deleteaccount();
		String textcheck5= driver.findElement(By.xpath("//div/h2/b")).getText();
		Assert.assertEquals(textcheck5, "ACCOUNT DELETED!", "wrong title:"+textcheck5);		
		Account_deleted = new page.Account_deleted(driver);
		Account_deleted.Continue();
		
	}

//	@Test(priority=2)
//	public void Testcases_Test(){
//		Homepage = new page.Homepage(driver);
//		Homepage.testcases();
//		String url= driver.getCurrentUrl();
//		Assert.assertEquals(url.toLowerCase(), "https://automationexercise.com/test_cases", "account create fail!!!");
//		String textcheck= driver.findElement(By.xpath("//section//h2/b")).getText();
//		Assert.assertEquals(textcheck, "TEST CASES", "not show info:"+textcheck);		
//
//	}
//
//	
}
