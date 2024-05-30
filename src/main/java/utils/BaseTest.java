package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.LoginPage;
import pages.MenuPage;

public class BaseTest {

	public WebDriver driver;
	public MenuPage menu;
	public LoginPage login;
	
	@BeforeClass
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://keybooks.ro/");
		
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {	
		Thread.sleep(5000);
		driver.quit();//inchide toate taburile
		//driver.close();//inchide tabul curent
	}
	
	
	@BeforeMethod
	public void initPageObjects() {
		
		menu = new MenuPage(driver);
		login = new LoginPage(driver);
		
	}
	
	
	
	
}