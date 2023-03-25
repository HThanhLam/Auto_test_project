package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import page.ContactPage;
import page.Homepage;

public class ContactTest {
	WebDriver driver;
	Homepage homePage;
    ContactPage contactPage;

    @Test
    public void TC6_sendContact() throws Exception {
        homePage = new Homepage(driver);
        contactPage = homePage.openContactPage();
        Assert.assertEquals(contactPage.getTitlePage(),"GET IN TOUCH","Contact title should be GET IN TOUCH");
        contactPage.sendContact("nhl","nhl@gmail.com","contact","content message");
        Assert.assertTrue(contactPage.getSuccessStatus().contains("Success! Your details have been submitted successfully"));
        contactPage.goToHomePage();
        closeGoogleAd();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.verifyThatLandedToHomepage(),"Not home page");
    }
    
    @BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.manage().window().maximize();
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
