package com.adminbuilder.Pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.baseutility.WebAction.FieldType;
import com.adminbuilder.configutility.ConfReader;

public class MarketPlace extends WebAction{
	
	WebAction webaction;
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("MarketPlace.class");
	
	public MarketPlace(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	
	public void selectLTSSadmin() throws InterruptedException {

//		click(FieldType.xpath, ConfReader.getInstance().getConfData("drpLTSSadminapp", "MarketPlace"), driver);
//		Thread.sleep(1000);
//		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnviewltss", "MarketPlace"), driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("lnkLTSS", "MarketPlace"), driver);
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		switchnewwindow(driver);
	}
	
	public void selectCMProductAdmin() throws InterruptedException {
//		Thread.sleep(1000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnviewCMproduct", "MarketPlace"), driver);
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		switchnewwindow(driver);
	}
	
	
	public void click_markets(String MarketName) throws InterruptedException {
		
				
		//Click on Login Button 
		click(FieldType.xpath, ConfReader.getInstance().getConfData("lnkMarketname", "MarketPlace").replace("<Market>", MarketName), driver);
		Log.info("Selected the " +MarketName+ " Market");
		waitForLoadingToBecomeInvisible(driver);
		
	 }
	
	public void validate_MarketList() throws Exception {
		//page header
		waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("MarketHeader_image","MarketPlace"), driver);
		Log.info("Successfully verified the header of the Market page header");
		
		//grid header
		waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("MarketGridHeader","MarketPlace"), driver);
		Log.info("Successfully verified the header of the Market list grid");
		
		waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("MarketColumn","MarketPlace"), driver);
		Log.info("Successfully verified the Market Column of the Market list grid");
		
		Assert.assertEquals(getLists(ConfReader.getInstance().getConfData("MarketList", "MarketPlace"), driver), GlobalValues.MarketList);
		Log.info("Passed - Market grid values are displayed as expected " + GlobalValues.MarketList);
		
	}
	
	public void validate_MarketSpecificPage(String MarketName) throws Exception {
		// Anthem Logo
	
		  WebElement anthemLogo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ConfReader.getInstance().getConfData("AnthemLogo","MarketPlace"))));

		  String anthemLogoText=anthemLogo.getAttribute("class"); 
		  String anthemurl=anthemLogo.getAttribute("src");
		  Assert.assertEquals(anthemLogoText,GlobalValues.anthemText.toString());
	//	  Assert.assertEquals(anthemurl,GlobalValues.anthemUrl.toString());
		  Log.info("Anthem Logo is present");
		  
		  WebElement LTSSAdminTool = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("LTSSAdminTool","MarketPlace")));
		  Assert.assertEquals(LTSSAdminTool.getText(),"LTSS Administrative Tool");
		  Log.info("Verified the LTSS Administrative Tool text in the client admin page");
		
		  WebElement StateMarket =driver.findElement(By.xpath(ConfReader.getInstance().getConfData("StateMarket","MarketPlace")));
		  Assert.assertEquals(StateMarket.getText(), MarketName+" Market");
		  Log.info("Verified the specific "+MarketName+" Market text in the client admin page");
		  
		  
		WebElement Login_Verify = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("LoginVerify","MarketPlace")));
		
		Thread.sleep(3000);
		assertEquals(Login_Verify.getText().trim(), "Client Admin", "Login user is not Client Admin User");
		Assert.assertEquals(driver.findElement(By.xpath(ConfReader.getInstance().getConfData("LoginUserRole","MarketPlace"))).getText().trim(), "Pepper Minstix", "Login User - ");
		Log.info("Logged in as Client Admin");
		
		//Verifying drop downs options in client admin page
		Log.info("Verifying the dropdowns in Client Admin page");
		
		Assert.assertEquals(getLists(ConfReader.getInstance().getConfData("AdminDropdowns", "MarketPlace"), driver), GlobalValues.ClientAdmin_dropdowns);
		Log.info("Verifying the dropdown values in the Main Client Admin page are displayed as expected " + GlobalValues.ClientAdmin_dropdowns);
	
//		for(int i=0; i<GlobalValues.ClientAdmin_dropdowns.size();i++)
//		{
//				driver.findElement(By.xpath("//span[text()='"+GlobalValues.ClientAdmin_dropdowns.get(i)+"']"));
//				Log.info("Verifying the "+ GlobalValues.ClientAdmin_dropdowns.get(i) + "- drop down in Client Admin Page");
//		}
}
	
	public void ClickAnthem() throws Exception {
		click(FieldType.xpath, ConfReader.getInstance().getConfData("AnthemLogo","MarketPlace"), driver);
		Log.info("Navigated back to Market list page");
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(5000);
	}

}

