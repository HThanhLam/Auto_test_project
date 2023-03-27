package test;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyTestCasesPage extends BaseTest{
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
}
