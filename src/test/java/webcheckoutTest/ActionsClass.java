package webcheckoutTest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

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

	@Test
	public void windowHandler() throws IOException {
		initializeBrowser();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[text()='Free Access to InterviewQues/ResumeAssistance/Material']")).click();
		Set<String> window = driver.getWindowHandles();
		Iterator<String> windowIterator = window.iterator();
		String parentId = windowIterator.next();
		String childId = windowIterator.next();
		driver.switchTo().window(childId);
		String userEmail = driver.findElement(By.cssSelector("p[class=\"im-para red\"] strong")).getText();
		driver.switchTo().window(parentId);
		driver.findElement(By.cssSelector("input[id=\"username\"]")).sendKeys(userEmail);
		
	}
}
