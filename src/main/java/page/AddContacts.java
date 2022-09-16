package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddContacts extends  BasePage {
	WebDriver driver;

	public AddContacts(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h5[contains(text(), 'Add Contact')]")
	WebElement ADD_CONTACT_HEADER_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id='account']")
	WebElement FULL_NAME_ELEMENT;

	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADDRESS_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement STATE_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SAVE_BUTTON_ELEMENT;

	public void validateAddContactPage(String addContact) {
		Assert.assertEquals(ADD_CONTACT_HEADER_ELEMENT.getText(), addContact, "Wrong Page!!");
	}
	
	String namePrint;
	public void insertFullName(String fullName) {
		namePrint = fullName + generateRandomNo(99999);
		FULL_NAME_ELEMENT.sendKeys(namePrint);
	
	}

	public void selectCompany(String company) {
		selectFromDropdown(COMPANY_ELEMENT, company);
	}
	
	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNo(99999)+ email);
	}
	
	public void insertPhone(String phone) {
		PHONE_ELEMENT.sendKeys(phone + generateRandomNo(9999));
	}

	public void insertAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}

	public void insertCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}

	public void insertState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}

	public void insertZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}

	public void selectCountry(String country) {
		selectFromDropdown(COUNTRY_ELEMENT, country);
	}

	public void clickSaveButton() {
		SAVE_BUTTON_ELEMENT.click();
	}
		
	 //tbody/tr[1]/td[3]
	 //tbody/tr[2]/td[3]
	 //tbody/tr[3]/td[3]
	String beforeXpath = "//tbody/tr[";
	String afterXpath = "]/td[3]";
	String afterXpathDelete = "]/td[7]/a[2]";
	
	public void variefyInsertedName() {
		for(int i=1;i<=5;i++) {
		
		String nameList = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
		System.out.println(nameList);
		if (nameList.contains(namePrint)) {
			System.out.println("Name Exits");
			driver.findElement(By.xpath(beforeXpath + i + afterXpathDelete)).click();
		}
		break;
	 }
		try {
			Thread.sleep(5000);
		WebElement alert = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
		System.out.println(alert.getText());
		alert.click();
		} catch (Exception e) {
			System.out.println("couldn't see the alert");
		}
		
	}
	

}
