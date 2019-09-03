package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;

import com.adminbuilder.Pages.AssessmentBuilderAddScoringCategory;
import com.adminbuilder.Pages.AssessmentBuilderAddScoringCategory.UpdateType;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Then;

public class stepdefAssessmentBuilderAddScoringCategory {
	
	TestContext testContext;
	Logger Log = Logger.getLogger("stepdefAssessmentBuilderAddScoringCategory.class");
	PageObjectManager pageObjectManager; 
	AssessmentBuilderAddScoringCategory assessmentbuilderaddscoringcategory;

	public stepdefAssessmentBuilderAddScoringCategory(TestContext context) {
		 testContext = context;
		 assessmentbuilderaddscoringcategory = testContext.getPageObjectManager().getassessmentbuilderaddscoringcategory();
	}
	
	@Then("^When I select invalid ScoreLowRange as \"([^\"]*)\" and ScoreHighRange as \"([^\"]*)\" validate error message displayed$") 
	 public void validateanswersection(String ScoreLowRange, String ScoreHighRange) throws InterruptedException { 
		
		assessmentbuilderaddscoringcategory.validateinvalidscorerange(ScoreLowRange, ScoreHighRange);
	 }

	@Then("^When I enter CategoryName as \"([^\"]*)\" validate Add button is enabled$") 
	 public void validateaddbutton(String CategoryName) throws InterruptedException { 
		
		assessmentbuilderaddscoringcategory.validateaddbutton(CategoryName);
	 }
	
	@Then("^Enter ScoreRangeValue as \"([^\"]*)\" , ScoreLowRange as \"([^\"]*)\" and ScoreHighRange as \"([^\"]*)\" and submit$") 
	 public void addscoringcategory(String ScoreRangeValue,String ScoreLowRange, String ScoreHighRange) throws InterruptedException { 
		
		assessmentbuilderaddscoringcategory.addeditscoringcategory(ScoreRangeValue, ScoreLowRange, ScoreHighRange, UpdateType.Add);
	 }
	
	@Then("^Enter ScoreRangeValue as \"([^\"]*)\" , ScoreLowRange as \"([^\"]*)\" and ScoreHighRange as \"([^\"]*)\" and Save$") 
	 public void editscoringcategory(String ScoreRangeValue,String ScoreLowRange, String ScoreHighRange) throws InterruptedException { 
		
		assessmentbuilderaddscoringcategory.addeditscoringcategory(ScoreRangeValue, ScoreLowRange, ScoreHighRange, UpdateType.Edit);
	 }
	
	@Then("^Validate the Scoring Category grid headers$") 
	 public void validateScoringCategorygrid() throws InterruptedException { 
		
		assessmentbuilderaddscoringcategory.validateScoringCategorygrid();
	 }
	
	@Then("^When I click on submit user shall land on the previous page$") 
	 public void clicksubmit() throws InterruptedException { 
		
		assessmentbuilderaddscoringcategory.clicksubmit();
	 }
	
	
	@Then("^When I click on Back user shall land on the previous page$") 
	 public void clickBack() throws InterruptedException { 
		
		assessmentbuilderaddscoringcategory.clickBack();
	 }
	
	
}
