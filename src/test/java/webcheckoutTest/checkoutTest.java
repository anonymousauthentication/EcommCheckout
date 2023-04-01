package webcheckoutTest;

import java.io.IOException;

import org.testng.annotations.Test;
import common.Base;
import webcheckoutPageObject.checkoutPageObject;

public class checkoutTest extends Base {
	@Test(dependsOnGroups="launchSite")
	public void checkoutProcess() throws InterruptedException, IOException {
		getGlobalData();
		String discountCoupon = prop.getProperty("discountCoupon");
		checkoutPageObject cp = new checkoutPageObject(driver);
		cp.checkout();
		cp.applyCouponCode(discountCoupon);
	}
}
