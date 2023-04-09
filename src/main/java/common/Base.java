package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver;
	public Properties prop;
	public FileInputStream files;
	public String url;

	public void initializeBrowser() throws IOException {
		getGlobalData();
		ChromeOptions ch = new ChromeOptions();
		ch.setAcceptInsecureCerts(true);
		url = prop.getProperty("siteUrl");
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			System.out.println("chrome");
			driver = new ChromeDriver(ch);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Enter Correct Name");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void invokeBrowser() throws IOException {
		initializeBrowser();
		getUrl();
	}

	public void getUrl() {
		driver.get(url);
	}

	public void getGlobalData() throws IOException {
		prop = new Properties();
		files = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\global.properties");
		prop.load(files);
	}
	
	public void takeScreenshot() throws IOException {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File src = scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/Checkout/src/test/java/screenshots/image.png"));
	}
}
