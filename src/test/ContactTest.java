package test;

import org.testng.annotations.Test;
import org.testng.Assert;
import page.ContactPage;
import page.Homepage;

public class ContactTest extends BaseTest{
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
        Thread.sleep(2000);
        Assert.assertTrue(homePage.verifyThatLandedToHomepage(),"Not home page");
    }
}
