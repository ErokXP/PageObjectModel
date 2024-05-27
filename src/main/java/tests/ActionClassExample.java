package tests;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.ContactsPage;
import pages.MenuPage;
import pages.ShopPage;
import utils.BaseTest;

public class ActionClassExample extends BaseTest{

	
	//@Test
	public void hoverExample() throws InterruptedException {
		
		MenuPage menu = new MenuPage(driver);
		
		menu.hoverElement(menu.aboutlink);
		Thread.sleep(3000);
		menu.hoverElement(menu.blogLink);	
	
	}
	
	//@Test
	public void dragAndDropExample() {
		
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.shopLink);
		
		ShopPage shop = new ShopPage(driver);
		shop.dragAndDrop(shop.sliderInitialPosition, 100, 0);
		shop.dragAndDrop(shop.sliderFinalPosition, -100, 0);	
	}
	
	@Test
	public void sendKeysExample() {
		
		MenuPage menu = new MenuPage(driver);
		menu.navigateTo(menu.contactsLink);
		
		ContactsPage contacs = new ContactsPage(driver);
		WebElement nameElement = driver.findElement(contacs.name);
		
		Actions action = new Actions(driver);
		
		action
			.moveToElement(nameElement)
			.click(nameElement)
			.keyDown(Keys.SHIFT)
			.sendKeys("nume")
			.keyUp(Keys.SHIFT)
			.sendKeys(Keys.TAB, "email@email.com")
			.pause(Duration.ofSeconds(2))
			.sendKeys(Keys.TAB, "My subject")
			.pause(Duration.ofSeconds(2))
			.sendKeys(Keys.TAB, "My message")
			.pause(Duration.ofSeconds(2))
			.sendKeys(Keys.TAB, Keys.ENTER)
			.pause(Duration.ofSeconds(2))
			.perform();
		
		
	}
	
	
	
	
}