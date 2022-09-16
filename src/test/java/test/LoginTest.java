package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.Dashboard;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	ExcelReader exlReader = new ExcelReader("src\\main\\java\\testData\\TF_login.xlsx");
	String username = exlReader.getCellData("LoginInfo", "Username", 2);
	String password = exlReader.getCellData("LoginInfo", "Password", 2);
	String dashboardVerify = exlReader.getCellData("Verify", "Verification", 2);
	
	@Test
	public void vllidUserShouldBeAbleToLogin() {	     
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUseName(username);
		loginPage.insertPassword(password);
		loginPage.clickSigninButton();
		
		Dashboard dashboardpage = PageFactory.initElements(driver, Dashboard.class);
		dashboardpage.validDashboardPage(dashboardVerify);
		
		//BrowserFactory.tearDown();
		
	}
}
