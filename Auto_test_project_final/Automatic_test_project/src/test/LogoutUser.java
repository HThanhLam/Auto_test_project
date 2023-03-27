package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

	
public class LogoutUser extends BaseTest{
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
}
	

