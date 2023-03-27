package test;

import org.testng.annotations.Test;
import org.testng.Assert;

import page.*;

public class RegisterUserWithExistingEmail extends BaseTest{
	Homepage homepage;
	Signup_login signup_login;
	
    String registeredName = "nhl1";
    String registeredEmailAddress = "lam0123hg123@gmail.com";
    
	@Test
    public void TC5_registerUserWithExistingEmail()
    {
        homepage = new Homepage(driver);
        homepage.login();
        signup_login = new Signup_login(driver);
        Assert.assertTrue(signup_login.getSignUpTitle().contains("New User Signup!"),"Tilte Sign Up wrong");
        signup_login.signup(registeredName, registeredEmailAddress);
        Assert.assertEquals(signup_login.getErrorSignUpMessage(),"Email Address already exist!");
    }
}
