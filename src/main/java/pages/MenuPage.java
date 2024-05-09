package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {

	public WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//driver.findElement(By.Locator);
	
	public By LoginLink = By.linkText("Login");
	public By contactsLink = By.linkText("CONTACTS");
	public By shopLink = By.linkText("BOOKS");
	
/*	public void navigateToLogin() {
		driver.findElement(By.linkText("Login")).click();
	}
	public void navigateToContacts() {
		driver.findElement(By.linkText("CONTACTS")).click();
	}
*/
	
	public void navigateTo(By locator) {
		driver.findElement(locator).click();
	}
	//navigateTo(loginLink)
	//navigateTo(contactsLink)
	//navigateTo(shopLink)
	
}
