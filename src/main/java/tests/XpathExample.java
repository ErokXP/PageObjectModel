package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.PropertiesFileProcessor;

public class XpathExample extends BaseTest{
	String user = PropertiesFileProcessor.readPropertiesFile("username", "credentials.properties");
	String pass = PropertiesFileProcessor.readPropertiesFile("password", "credentials.properties");

	/*
	 * CSS :
	 *    li[class='menu_user_login']
	 * 
	 * XPATH:
	 *    //li[@class='menu_user_login']
	 * 
	 */
	
	
	@Test(priority = 1)
	public void xpathExampleTest() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebElement loginButton =  driver.findElement(By.xpath("//li[@class='menu_user_login']"));
	
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: yellow;border:6px solid green;')", loginButton);
		
		loginButton.click();
		
		//OR
		WebElement userField = driver.findElement(By.xpath("//input[@id='log' or @name='log']"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: yellow;border:6px solid green;')", userField);
		
		userField.sendKeys(user);
		//AND
		WebElement passField =  driver.findElement(By.xpath("//input[@type='password' and @name='pwd']"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: yellow;border:6px solid green;')", passField);
		
		passField.sendKeys(pass);
		
		
		WebElement submitButton = driver.findElement(By.xpath("//div[@class='popup_form_field submit_field']/input"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: yellow;border:6px solid green;')", submitButton);
		
		submitButton.click();
		
		Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void xpathExample2() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebElement userName = driver.findElement(By.xpath("//span[@class='user_name']"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: yellow;border:6px solid green;')", userName);
		Thread.sleep(2000);
		userName.click();
		//<a href="https://keybooks.ro/wp-admin/profile.php" class="icon icon-cog">Settings</a>
		
		//text() --> referinta catre textul dintre tag-urile html
		WebElement textSettings = driver.findElement(By.xpath("//a[text()='Settings']"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: yellow;border:6px solid green;')", textSettings);
		Thread.sleep(2000);
		textSettings.click();
		//<a href="https://keybooks.ro/account/orders/">recent orders</a>
		// //a[text()='recent orders']
		// contains()
		//  //a[contains(text(), 'rece')]
		
		WebElement recentOrderLink = driver.findElement(By.xpath("//a[contains(text(), 'rece')]"));	
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: yellow;border:6px solid green;')", recentOrderLink);
		Thread.sleep(2000);
		recentOrderLink.click();
		
		WebElement orderTableHead = driver.findElement
				(By.xpath("//th[contains(@class,'woocommerce-orders-table__header-order-number')]"));
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: pink;border:6px solid green;')", orderTableHead);
		Thread.sleep(2000);
		
		WebElement dateTableHead =  driver.findElement
(By.xpath("//th[contains(@class,'woocommerce-orders-table__header-order-date')]/span[contains(text(), 'Date')]"));
		
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: red;border:6px solid green;')", dateTableHead);
		Thread.sleep(2000);
		
		//identificare pe baza de index
		//(//span[@class='nobr'])[3]
		
		WebElement statusTableHead =  driver.findElement(By.xpath("(//span[@class='nobr'])[3]"));
		
		jse.executeScript("arguments[0].setAttribute"
				+ "('style', 'background: yellow;border:6px solid green;')", statusTableHead);
		Thread.sleep(2000);
		
		/*
		 * <a href="https://keybooks.ro/account/view-order/1720/">#1720</a>
		 * 
		 *   //a[@href='https://keybooks.ro/account/view-order/1720/']
		 *   //a[contains(@href, '1720')]
		 *   //a[contains(text(), '#1720')]
		 * 
		 */
		
		//NOT
		
		
		////td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[not(contains(text(), '#1720'))]
		//  /html/body/div[1]/div/p/div[4]/div/div/article/section/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/a
		
		
		List<WebElement> orders = driver.findElements
				(By.xpath("//td[contains(@class, 'woocommerce-orders-table__cell')][@data-title='Order']/a[not(contains(text(), '#1720'))]"));
		//int i=0;
		for(WebElement order : orders) {
			
			jse.executeScript("arguments[0].setAttribute"
					+ "('style', 'background: yellow;border:6px solid green;')", order);
			Thread.sleep(2000);
			
			
		}
		
	}
	
	

}