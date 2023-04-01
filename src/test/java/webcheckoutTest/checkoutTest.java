package webcheckoutTest;

import org.testng.annotations.Test;
import common.Base;
import webcheckoutPageObject.checkoutPageObject;

public class checkoutTest extends Base {
	@Test(dependsOnGroups="launchSite")
	public void checkoutProcess() throws InterruptedException {
		checkoutPageObject cp = new checkoutPageObject(driver);
		cp.checkout();
		
	}
}
