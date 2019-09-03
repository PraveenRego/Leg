package com.adminbuilder.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.baseutility.WebAction.FieldType;
import com.adminbuilder.configutility.ConfReader;

public class CMAdminNavigation extends WebAction{
	
	
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("CMAdminNavigation.class");
	
	public CMAdminNavigation(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	
	public void selectAdminBuilderTool() throws InterruptedException {
		
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("lnkTemplateManagement", "CMAdminNavigation"), driver);
		Log.info("Click on TemplateManagement button");
		if(waitForObjectToBecomeVisible( ConfReader.getInstance().getConfData("lnkAdminBuilderTool", "CMAdminNavigation"), driver)) {
			Log.info("AdminBuilderTool is displayed");
			click(FieldType.xpath, ConfReader.getInstance().getConfData("lnkAdminBuilderTool", "CMAdminNavigation"), driver);
			Log.info("Click on AdminBuilderTool button");
		}else {
			Log.info("AdminBuilderTool is not displayed");
		}
		waitForLoadingToBecomeInvisible(driver);
		
	 }
}
