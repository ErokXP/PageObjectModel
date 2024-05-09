package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuPage;
import utils.BaseTest;
import utils.PropertiesFileProcessor;

public class LoginTest extends BaseTest {
	
	String user = PropertiesFileProcessor.readPropertiesFile("username", "credentials.properties");
	String pass = PropertiesFileProcessor.readPropertiesFile("password", "credentials.properties");
	
	@Test(priority =1)
	public void validLoginTest() {
		
		MenuPage menu = new MenuPage(driver);
		LoginPage login = new LoginPage(driver);
		
		
		menu.navigateTo(menu.LoginLink);
		login.loginInApp(user, pass);
		
		assertTrue(login.checkMsgIsDisplayed(login.successLoginMessage));
		login.logoutFromApp();
		
	}
	
	@Test(priority =2)
	public void invalidLoginTest() {
		
		MenuPage menu = new MenuPage(driver);
		LoginPage login = new LoginPage(driver);
		
		
		menu.navigateTo(menu.LoginLink);
		login.loginInApp(user, "123123123");
		assertTrue(login.checkMsgIsDisplayed(login.errorLoginMessage));
	}

}
