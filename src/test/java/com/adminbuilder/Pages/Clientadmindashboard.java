package com.adminbuilder.Pages;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.configutility.ConfReader;

public class Clientadmindashboard extends WebAction{
	

	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("Clientadmindashboard.class");
	
	public Clientadmindashboard(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	
public void verifyprograms() throws InterruptedException {
		
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("hdrprograms", "Clientadmindashboard"), driver));
		Log.info("Programs is displayed as the header");
		Assert.assertNotNull(getLists(ConfReader.getInstance().getConfData("lnkprogramlist", "Clientadmindashboard"), driver));
		Log.info("Programs are displayed as links in the programs dashboard");
}

public void clickprograms() throws InterruptedException {
	
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(2000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("lnkprogramlist", "Clientadmindashboard") + "[1]", driver);
	Log.info("First Program is clicked");
}

}
