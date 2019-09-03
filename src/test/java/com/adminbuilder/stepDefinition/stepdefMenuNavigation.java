package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;
import com.adminbuilder.Pages.MenuNavigation;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Then;

public class stepdefMenuNavigation extends WebAction{

	TestContext testContext;
	Logger Log = Logger.getLogger("stepdefLeftNavigation.class");
	PageObjectManager pageObjectManager; 
	MenuNavigation leftnavigation;

	public stepdefMenuNavigation(TestContext context) {
		 testContext = context;
		 leftnavigation = testContext.getPageObjectManager().getLeftNavigation();
		 }
	 
	 @Then("^I click on Assessment builder$") 
	 public void selectAssessmentbuilder() throws InterruptedException { 
		 
		 leftnavigation.selectAssessmentbuilder();
			
		 }
	 
	 @Then("^Verify the Menu Bar in Selected Market Dashboard$")
		public void VerifyMenuBar() {
		 leftnavigation.ClickMarketSetup();
		 leftnavigation.ClickUser_UserRoleManagement();
		 leftnavigation.ClickDashboards();
		 leftnavigation.ClickWorkFlows_Tasks();
		 leftnavigation.ClickAssessment_Form_Builder();
	}
	   
	 }

