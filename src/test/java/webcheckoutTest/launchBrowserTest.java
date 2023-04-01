package webcheckoutTest;

import java.io.IOException;

import org.testng.annotations.Test;

import common.Base;

public class launchBrowserTest extends Base{
	@Test(groups="launchSite")
	public void launchBrowser() throws IOException {
		invokeBrowser();
	}
}
