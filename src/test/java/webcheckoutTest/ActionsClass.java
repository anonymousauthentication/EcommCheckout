package webcheckoutTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import common.Base;

public class ActionsClass extends Base {
	@Test
	public void actionsExample() throws IOException {
		initializeBrowser();
		driver.get("https://www.amazon.in/");
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.cssSelector("span[id=\"nav-link-accountList-nav-line-1\"]"))).build()
				.perform();
		ac.moveToElement(driver.findElement(By.cssSelector("input[id=\"twotabsearchtextbox\"]"))).click()
				.keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().contextClick().build().perform();
	}
}
