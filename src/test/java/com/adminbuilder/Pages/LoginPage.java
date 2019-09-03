package com.adminbuilder.Pages;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.configutility.ConfReader;



public class LoginPage extends WebAction{
	
//	WebAction webaction;
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("LoginPage.class");
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}


		 
	 public void Login_admin(String u_name,String pwd) throws InterruptedException {
				
			//Enter UserName
		 	enter_text(u_name, FieldType.xpath, ConfReader.getInstance().getConfData("txtusername", "Login"), driver);
		   	Log.info("Enter user name");
		   	Thread.sleep(3000);
			//Enter Password
		    enter_text(pwd, FieldType.xpath, ConfReader.getInstance().getConfData("txtpassword", "Login"), driver);
			Log.info("Enter password");
			
			//Click on Login Button 
			click(FieldType.xpath, ConfReader.getInstance().getConfData("btnlogin", "Login"), driver);
			Log.info("Click on login button");
			
			
		 }
	 
	 public void host_URL() {
	openURL(driver);
		
}
	 
	 public void validate_loginsuccessfull() {
		 
		 try {
			 waitforPageload(driver, ConfReader.getInstance().getConfData("hdrAdminbuilder", "Login"));
			 Log.info("Login is successful ");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Page not loaded ");
			
		}
		 
	}
	 
 public void logout() {
		 
		 try {
			click(FieldType.link, ConfReader.getInstance().getConfData("lnklogout", "Login"), driver);
		waitForLoadingToBecomeInvisible(driver);
			if( waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("btnlogin", "Login"), driver)) {
				Log.info("Logout successful");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Logout not successfull ");
			
		}
		 
	}
 
 public void validate_loginunsuccessfull() {
	 
	 try {
		if( waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("hdrErrorPage", "Login"), driver)) {
			Log.info("Login Unsuccessful, Please give the correct credentials");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		Log.info("Page not loaded ");
		
	}
	 
}
 
 public void closeDriver() {
	 //		 String title = driver.getTitle();
	 driver.quit();
//		Runtime.getRuntime().exec("TASKKILL /IM chrome.exe /F");
//		 Runtime.getRuntime().exec("taskkill /IM iexplore.exe /FI \"WINDOWTITLE eq" + title + "*\"");
 }
	
}

