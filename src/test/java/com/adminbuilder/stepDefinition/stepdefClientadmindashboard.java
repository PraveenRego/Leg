package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;

import com.adminbuilder.Pages.Clientadmindashboard;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Then;

public class stepdefClientadmindashboard {

	TestContext testContext;
	Logger Log = Logger.getLogger("stepdefClientadmindashboard.class");
	PageObjectManager pageObjectManager; 
	Clientadmindashboard clientadmindashboard;

	public stepdefClientadmindashboard(TestContext context) {
		 testContext = context;
		 clientadmindashboard = testContext.getPageObjectManager().getClientadmindashboard();
		 
	}
	
	@Then ("^Verify the programs present on dashboard$")
	public void verifyprograms() throws InterruptedException { 
		
		clientadmindashboard.verifyprograms();
	 }	
	
	@Then ("^Click the programs present on dashboard$")
	public void clickprograms() throws InterruptedException { 
		
		clientadmindashboard.clickprograms();
	 }	
	
}
