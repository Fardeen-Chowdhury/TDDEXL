package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContacts;
import page.Dashboard;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddContactTest {

	WebDriver driver;
	
	ExcelReader exlReader = new ExcelReader("src\\main\\java\\testData\\TF_login.xlsx");
	String username = exlReader.getCellData("LoginInfo", "Username", 2);
	String password = exlReader.getCellData("LoginInfo", "Password", 2);
	String dashboardVerify = exlReader.getCellData("Verify", "Verification", 2);
	String addContactVerify = exlReader.getCellData("AddContact", "Validation", 2);
	String fullName = exlReader.getCellData("AddContact", "FullName", 2);
	String companyName = exlReader.getCellData("AddContact", "CompanyName", 2);
	String email = exlReader.getCellData("AddContact", "Email", 2);
	String phone = exlReader.getCellData("AddContact", "Phone", 2);
	String address = exlReader.getCellData("AddContact", "Address", 2);
	String city = exlReader.getCellData("AddContact", "City", 2);
	String country = exlReader.getCellData("AddContact", "Country", 2);
	String state = exlReader.getCellData("AddContact", "State", 2);
	String zip = exlReader.getCellData("AddContact", "Zip", 2);
	
	
	public void validUserShouldBeAnbleTOAddCustomer() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUseName(username);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		Dashboard dashboardpage = PageFactory.initElements(driver, Dashboard.class);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dashboardpage.validDashboardPage(dashboardVerify);
		dashboardpage.clickCustomerMenuButton();
		dashboardpage.clickAddCustomerMenuButton();
		
		
		AddContacts addContactPage = PageFactory.initElements(driver, AddContacts.class);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addContactPage.validateAddContactPage(addContactVerify);
		addContactPage.insertFullName(fullName);
		addContactPage.selectCompany(companyName);
		addContactPage.insertEmail(email);
		addContactPage.insertPhone(phone);
		addContactPage.insertAddress(address);
		addContactPage.insertCity(city);
		addContactPage.insertState(state);
		addContactPage.insertZip(zip);
		addContactPage.selectCountry(country);
		addContactPage.clickSaveButton();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dashboardpage.clickListCustomerMenuButton();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addContactPage.variefyInsertedName();
	
	//	BrowserFactory.tearDown();
	}
	
	@Test
	public void clickCHeck() {
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUseName(username);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		Dashboard dashboardpage = PageFactory.initElements(driver, Dashboard.class);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dashboardpage.clickBankAndCash();
	}
}
