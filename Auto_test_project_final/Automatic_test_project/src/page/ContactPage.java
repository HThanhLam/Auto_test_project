package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {
	By contactTitle = By.xpath("//div[@class='contact-form']/h2[@class='title text-center']");
    By nameInput = By.xpath("//input[@name='name']");
    By emailInput = By.xpath("//input[@name='email']");

    By subjectInput = By.xpath("//input[@name='subject']");
    By textArea = By.xpath("//textarea[@id='message']");
    By uploadFileButton = By.xpath("//input[@name='upload_file']");
    By submitButton = By.xpath("//input[@name='submit']");
    By statusLable = By.xpath("//div[@class='status alert alert-success']");
    By homeButton = By.xpath("//a[@class='btn btn-success']");

    WebDriver driver;
    
    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitlePage()
    {
        return driver.findElement(contactTitle).getText();
    }

    public String getSuccessStatus()
    {
        return driver.findElement(statusLable).getText();
    }

    public void sendContact(String name,String email,String subject,String message)
    {
    	driver.findElement(nameInput).sendKeys(name);
    	driver.findElement(emailInput).sendKeys(email);
    	driver.findElement(subjectInput).sendKeys(subject);
    	driver.findElement(textArea).sendKeys(message);
        driver.findElement(uploadFileButton).sendKeys(System.getProperty("user.dir") + "\\resources\\test.txt");
        driver.findElement(submitButton).click();
        driver.switchTo().alert().accept();
    }

    public void goToHomePage() {
        driver.findElement(homeButton).click();
    }

}
