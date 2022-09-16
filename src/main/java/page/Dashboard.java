package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


public class Dashboard {
		WebDriver driver;

		public Dashboard(WebDriver driver) {
			this.driver = driver;
		}

		@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2")
		WebElement Dashboard_header;
		@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Customers')]")
		WebElement CUSTOMER_MENU_ELEMENT;
		@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Add Customer')]")
		WebElement ADD_CUSTOMER_MENU_ELEMENT;
		@FindBy(how = How.XPATH, using = "//a[contains(text(), 'List Customers')]")
		WebElement List_CUSTOMER_MENU_ELEMENT;
		@FindBy (how = How.XPATH,using = "//span[contains(text(),'Bank & Cash')]")
		WebElement BANK_CASH_MENU_ELEMENT;
		
		public void validDashboardPage(String dashboard) {
			Assert.assertEquals(Dashboard_header.getText(), dashboard, "Dashboard is not available");
		}
		
		public void clickCustomerMenuButton() {
			CUSTOMER_MENU_ELEMENT.click();
		}
		public void clickAddCustomerMenuButton() {
			ADD_CUSTOMER_MENU_ELEMENT.click();
		}
		public void clickListCustomerMenuButton() {
			List_CUSTOMER_MENU_ELEMENT.click();
		}
		public void clickBankAndCash() {
			BANK_CASH_MENU_ELEMENT.click();
		}
	}
