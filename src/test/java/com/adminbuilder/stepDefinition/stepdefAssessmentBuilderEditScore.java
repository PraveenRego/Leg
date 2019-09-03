package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;

import com.adminbuilder.Pages.AssessmentBuilderEditScore;
import com.adminbuilder.Pages.BranchingLogic;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Then;

public class stepdefAssessmentBuilderEditScore {
	TestContext testContext;
	Logger Log = Logger.getLogger("stepdefAssessmentBuilderEditScore.class");
	PageObjectManager pageObjectManager; 
	AssessmentBuilderEditScore editScore;

	public stepdefAssessmentBuilderEditScore(TestContext context) {
		 testContext = context;
		 editScore = testContext.getPageObjectManager().geteditScore();
		 
	}
	@Then ("^Verify score can be added as \\\"([^\\\"]*)\\\"$")
	public void EditScore(String Score) throws InterruptedException { 
		
		editScore.EditScore(Score);
	 }	
	
	@Then("^I click on Edit row again from answer grid and verify Duplicate error message for answer value as \"([^\"]*)\" and score as \"([^\"]*)\"$")
	public void duplicateError(String Answer, String Score) throws InterruptedException { 
		
		editScore.duplicateError(Answer,Score);
	 }
}
