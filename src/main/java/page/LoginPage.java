package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

WebDriver driver;
	
	public LoginPage (WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	//Element list
	@FindBy(how = How.XPATH, using ="//input[@id='username']")
	WebElement Username_Element;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement Password_Element;
	@FindBy(how = How.XPATH, using = "//button[@name='login']")
	WebElement Sign_Button;

	public void insertUseName(String userName) {
		Username_Element.sendKeys(userName);
	}
	
	public void insertPassword(String password) {
		Password_Element.sendKeys(password);
	}
	
	public void clickSigninButton() {
		Sign_Button.click();
	}
}
