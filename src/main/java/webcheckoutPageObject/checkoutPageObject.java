package webcheckoutPageObject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class checkoutPageObject {
	WebDriver driver;

	public checkoutPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "span[class=\"redLogo\"]")
	WebElement pageTitle;

	@FindBy(css = "div[class=\"product\"]")
	List<WebElement> productList;

	@FindBy(css = "h4[class=\"product-name\"]")
	List<WebElement> productName;

	@FindBy(css = "div[class=\"product-action\"]")
	List<WebElement> addToCart;
	
	@FindBy(css="img[alt=\"Cart\"]")
	WebElement Cart;
	
	@FindBy(xpath="//button[text()=\"PROCEED TO CHECKOUT\"]")
	WebElement proceedToCheckout;
	
	@FindBy(xpath="//tr/td[5]/p[@class=\"amount\"]")
	List<WebElement> ProductFinalPrice;
	
	@FindBy(css="span[class=\"totAmt\"]")
	WebElement totalAmount;

	public void checkout() throws InterruptedException {
		System.out.println(pageTitle.getText());
		String[] vegitable = { "Brocolli", "Cauliflower","Cucumber" };
		for (int i = 0; i < productList.size(); i++) {
			for (int j = 0; j < vegitable.length; j++) {
				if (productName.get(i).getText().split("-")[0].trim().equalsIgnoreCase(vegitable[j])) {
					System.out.println(productName.get(i).getText().split("-")[0].trim());              
					addToCart.get(i).click();
					break;
				}
			}
		}
		Cart.click();
		proceedToCheckout.click();
		priceCalculation();
	}
	
	public void priceCalculation() {
		int  actualPrice=0;
		int expectedPrice=0;
		for(WebElement price : ProductFinalPrice ) {
			actualPrice = actualPrice+Integer.parseInt(price.getText());
		}
		expectedPrice = Integer.parseInt(totalAmount.getText()); 
		System.out.println(actualPrice);
		System.out.println(expectedPrice);
		Assert.assertEquals(actualPrice, expectedPrice);
	}
}
