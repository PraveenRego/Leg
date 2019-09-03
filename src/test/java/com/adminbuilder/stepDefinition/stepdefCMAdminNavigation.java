package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;

import com.adminbuilder.Pages.BranchingLogic;
import com.adminbuilder.Pages.CMAdminNavigation;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Then;

public class stepdefCMAdminNavigation {
	TestContext testContext;
	Logger Log = Logger.getLogger("stepdefCMAdminNavigation.class");
	PageObjectManager pageObjectManager; 
	CMAdminNavigation cmadminnavigation;

	public stepdefCMAdminNavigation(TestContext context) {
		 testContext = context;
		 cmadminnavigation = testContext.getPageObjectManager().getCMAdminNavigation();
		 
	}
	
	@Then ("^Select the Admin builder tool from the menu$")
	public void selectAdminBuilderTool() throws InterruptedException { 
		
		cmadminnavigation.selectAdminBuilderTool();
	 }
}
