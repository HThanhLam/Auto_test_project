package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Account_signup {
	WebDriver driver;
	By btnRadiomale = By.id("id_gender1");
	By btnRadiofemale = By.id("id_gender2");
	By txtPassword = By.id("password");
	By selectDay = By.id("days");
	By selectMonth = By.id("months");
	By selectYear = By.id("years");
	By btnNewletter = By.id("newsletter");
	By btnOffers = By.id("optin");
	By txtFirst_name = By.id("first_name");
	By txtLast_name = By.id("last_name");
	By txtCompany = By.id("company");
	By txtAddress = By.id("address1");
	By selectCountry = By.id("country");
	By txtState  = By.id("state");
	By txtCity = By.id("city");
	By txtZipcode = By.id("zipcode");
	By txtMobile_Number  = By.id("mobile_number");
	By btnSignup = By.xpath("//button[@data-qa='create-account']");

	WebDriverWait Wait;
	public Account_signup(WebDriver driver) {
		this.driver = driver;
	}
	public void signup(String gender,String password,Integer Day,Integer Month,Integer Year,String First_name,String Last_name,
				String Company,String Address,String Country,String State,String City,String zipcode,String Mobile_number) {
		if (gender.equals("male")) {	
				driver.findElement(btnRadiomale).click();
				}
		else
				{
				driver.findElement(btnRadiofemale).click();
				}
			driver.findElement(txtPassword).sendKeys(password);
	        WebElement selectElement = driver.findElement(selectDay);
	        Select select = new Select(selectElement);
	        select.selectByIndex(Day);
	        WebElement selectElement2 = driver.findElement(selectMonth);
	        Select select2 = new Select(selectElement2);
	        select2.selectByIndex(Month);
	        WebElement selectElement3 = driver.findElement(selectYear);
	        Select select3 = new Select(selectElement3);
	        select3.selectByIndex(2022-Year);
			driver.findElement(btnOffers).click();
			driver.findElement(btnNewletter).click();
			driver.findElement(txtFirst_name).sendKeys(First_name);
			driver.findElement(txtLast_name).sendKeys(Last_name);
			driver.findElement(txtCompany).sendKeys(Company);
			driver.findElement(txtAddress).sendKeys(Address);
		    WebElement selectElement4 = driver.findElement(selectCountry);
		    Select select4 = new Select(selectElement4);
		    select4.selectByValue(Country);
			driver.findElement(txtState).sendKeys(State);
			driver.findElement(txtCity).sendKeys(City);
			driver.findElement(txtMobile_Number).sendKeys(Mobile_number);
			driver.findElement(txtZipcode).sendKeys(zipcode);
			driver.findElement(btnSignup).click();
	}
}
