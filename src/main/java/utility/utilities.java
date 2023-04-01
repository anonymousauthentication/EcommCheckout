package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utilities {
 WebDriver driver;
 WebDriverWait wait;
	public  utilities(WebDriver driver) {
	 this.driver=driver;
 }

	public void waitforElementToDisplay(WebElement el) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOf(el));
	}
}
