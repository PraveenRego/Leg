package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;

import com.adminbuilder.Pages.ExcludedFromAutomation;
import com.adminbuilder.Pages.ExcludedFromAutomation.Excludedstory;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Given;


public class StepdefExcludedFromAutomation {

	TestContext testContext;
	Logger Log = Logger.getLogger("StepdefExcludedfromAutomation.class");
	PageObjectManager pageObjectManager; 
	ExcludedFromAutomation excludedFromAutomation;
	
	 public StepdefExcludedFromAutomation(TestContext context) {
		 testContext = context;
		 excludedFromAutomation = testContext.getPageObjectManager().getExcludedfromAutomation();
	 }

	
	@Given("^this is a \"([^\"]*)\"$")
	public void Excludedstorystatus(Excludedstory storytype) throws Exception{
		excludedFromAutomation.excludedStoryStatus(storytype);
	}
	
 
	
}