package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class ActionClassExample2 extends BaseTest{
	
	
	@Test
	public void copyPasteTest() throws InterruptedException {
		
		WebElement discoverText = driver.findElement(By.tagName("em"));
		WebElement loginButton = driver.findElement(By.cssSelector("li[class='menu_user_login']"));
		WebElement userField = driver.findElement(By.id("log"));
		
		Keys cmdCtrl = Platform.getCurrent().is(Platform.WINDOWS) ? Keys.CONTROL : Keys.COMMAND;
		
		Actions action = new Actions(driver);
		
		action
			.moveToElement(discoverText)
			.doubleClick()
			.keyDown(Keys.SHIFT)
			.sendKeys(Keys.ARROW_LEFT)
			.keyUp(Keys.SHIFT)
			.perform();
		
		
		Thread.sleep(5000);
		action
			.keyDown(cmdCtrl)
			.sendKeys("c")
			.keyUp(cmdCtrl)
		.perform();
		
		loginButton.click();
		userField.click();
		
		action
			.keyDown(cmdCtrl)
			.sendKeys("v")
			.keyUp(cmdCtrl)
		.perform();
		
		Thread.sleep(5000);
		
		
	}

}