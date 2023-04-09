package webcheckoutTest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.Base;

public class ActionsClass extends Base {
	@Test(testName = "capLetter")
	public void actionsExample() throws IOException {
		initializeBrowser();
		driver.get("https://www.amazon.in/");
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.cssSelector("span[id=\"nav-link-accountList-nav-line-1\"]"))).build()
				.perform();
		ac.moveToElement(driver.findElement(By.cssSelector("input[id=\"twotabsearchtextbox\"]"))).click()
				.keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().contextClick().build().perform();
	}

	@Test(testName = "WindowHandler")
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

	@Test(testName = "linkCount")
	public void getLinkCount() throws IOException {
		initializeBrowser();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		System.out.println("Footer Link");
		WebElement el = driver.findElement(By.xpath("//div[@id=\"gf-BIG\"]"));
		System.out.println(el.findElements(By.tagName("a")).size());
		WebElement footercolLink = el.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(footercolLink.findElements(By.tagName("a")).size());
		for (int i = 0; i < footercolLink.findElements(By.tagName("a")).size(); i++) {
			String keyClick = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footercolLink.findElements(By.tagName("a")).get(i).sendKeys(keyClick);
		}
		Set<String> windowCount = driver.getWindowHandles();
		Iterator<String> winIterate = windowCount.iterator();
		String parentWin = winIterate.next();
		while (winIterate.hasNext()) {
			driver.switchTo().window(winIterate.next());
			System.out.println(driver.getTitle());
		}
	}

	@Test(testName = "calenderHandle")
	public void calenderHandle() throws IOException, InterruptedException {
		initializeBrowser();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"form-field-travel_comp_date\"]")).click();
		while (!driver.findElement(By.cssSelector("div[class=\"flatpickr-current-month\"]")).getText()
				.contains("April")) {
			driver.findElement(By.cssSelector("span[class=\"flatpickr-next-month\"]")).click();
		}
		List<WebElement> days = driver.findElements(By.cssSelector("span[class*=\"flatpickr-day\"]"));
		int daySize = days.size();
		try {
			for (int j = 0; j <= daySize; j++) {
				if (days.get(j).getText().contains("27")) {
					String classAtt = days.get(j).getAttribute("class");
					if (!classAtt.contains("disabled")) {
						days.get(j).click();
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test(testName = "handleScroll")
	public void handloScroll() throws IOException {
		initializeBrowser();
		int sum = 0;
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
		List<WebElement> tableData = driver
				.findElements(By.xpath("//div[@class=\"tableFixHead\"]/table[@id=\"product\"]/tbody/tr/td[4]"));
		for (int i = 0; i < tableData.size(); i++) {
			sum = sum + Integer.parseInt(tableData.get(i).getText());
		}
		int totalAmt = Integer.parseInt(
				driver.findElement(By.cssSelector("div[class=\"totalAmount\"]")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, totalAmt);
		System.out.println(sum + " " + totalAmt);
	}

	@Test(testName = "sslCheck")
	public void sslCheck() throws IOException {
		initializeBrowser();
		// using ChromeOption and chromeOption_Class setAcceptInsecureCerts
		driver.get("https://expired.badssl.com/");
		takeScreenshot();
	}
}
