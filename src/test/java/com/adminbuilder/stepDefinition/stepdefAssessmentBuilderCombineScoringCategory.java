package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;

import com.adminbuilder.Pages.AssessmentBuilderCombineScoringCategory;
import com.adminbuilder.Pages.AssessmentBuilderCombineScoringCategory.UpdateType;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Then;

public class stepdefAssessmentBuilderCombineScoringCategory {
	
	TestContext testContext;
	Logger Log = Logger.getLogger("stepdefAssessmentBuilderCombineScoringCategory.class");
	PageObjectManager pageObjectManager; 
	AssessmentBuilderCombineScoringCategory assessmentbuildercombinescoringcategory;

	public stepdefAssessmentBuilderCombineScoringCategory(TestContext context) {
		 testContext = context;
		 assessmentbuildercombinescoringcategory = testContext.getPageObjectManager().getassessmentbuildercombinescoringcategory();
	}
	
	@Then("^Enter Group Category Description as \"([^\"]*)\"$") 
	 public void addGroupCategoryDescriptionCategory(String GroupCategoryDescription) throws InterruptedException { 
		
		assessmentbuildercombinescoringcategory.addGroupCategoryDescriptionCategory(GroupCategoryDescription);
	 }
	
	@Then("^Select the first value from Scoring Category$") 
	 public void addScoringCategory() throws InterruptedException { 
		
		assessmentbuildercombinescoringcategory.addScoringCategory();
	 }
	
	@Then("^Enter in Combine Scoring Categories, ScoreRangeValue as \"([^\"]*)\" , ScoreLowRange as \"([^\"]*)\" and ScoreHighRange as \"([^\"]*)\" and submit$") 
	 public void addscoringcategory(String ScoreRangeValue,String ScoreLowRange, String ScoreHighRange) throws InterruptedException { 
		
		assessmentbuildercombinescoringcategory.addeditscoringcategory(ScoreRangeValue, ScoreLowRange, ScoreHighRange, UpdateType.Add);
	 }
	
	@Then("^Enter in Combine Scoring Categories, ScoreRangeValue as \"([^\"]*)\" , ScoreLowRange as \"([^\"]*)\" and ScoreHighRange as \"([^\"]*)\" and save$") 
	 public void editscoringcategory(String ScoreRangeValue,String ScoreLowRange, String ScoreHighRange) throws InterruptedException { 
		
		assessmentbuildercombinescoringcategory.addeditscoringcategory(ScoreRangeValue, ScoreLowRange, ScoreHighRange, UpdateType.Edit);
	 }
	
	@Then("^Validate Page title$") 
	 public void validatepageTitle() throws InterruptedException { 
		 
		 assessmentbuildercombinescoringcategory.validatepageTitle();
	 }
	
	 @Then("^Validate the fields present in Combined Scoring Page$") 
	 public void validatecombinepageAttributes() throws InterruptedException { 
		 
		 assessmentbuildercombinescoringcategory.validatecombinepageAttributes();
	 }
	
	 @Then("^validate Add button is enabled$") 
	 public void validateaddbutton() throws InterruptedException { 
		
		 assessmentbuildercombinescoringcategory.validateaddbutton();
	 }
	 
	 @Then("^When I select invalid ScoreLowRange as \"([^\"]*)\" and ScoreHighRange as \"([^\"]*)\" validate error message displayed in combine score category$") 
	 public void validateanswersection(String ScoreLowRange, String ScoreHighRange) throws InterruptedException { 
		
		 assessmentbuildercombinescoringcategory.validateinvalidscorerange(ScoreLowRange, ScoreHighRange);
	 }
	 
	 @Then("^When I select high ScoreLowRange as \"([^\"]*)\" and low ScoreHighRange as \"([^\"]*)\" validate error message displayed$") 
	 public void validatehighlowscorerange(String ScoreLowRange, String ScoreHighRange) throws InterruptedException { 
		
		 assessmentbuildercombinescoringcategory.validatehighlowscorerange(ScoreLowRange, ScoreHighRange);
	 }
	 
	 @Then("^When I select overlapped ScoreRangeValue as \"([^\"]*)\", ScoreLowRange as \"([^\"]*)\" and ScoreHighRange as \"([^\"]*)\" validate error message displayed$") 
	 public void validateoverlaperror(String ScoreRangeValue,String ScoreLowRange, String ScoreHighRange) throws InterruptedException { 
		
		 assessmentbuildercombinescoringcategory.validateoverlaperror(ScoreRangeValue,ScoreLowRange, ScoreHighRange,UpdateType.Add);
	 }
	 
	 @Then("^When I edit and select overlapped ScoreRangeValue as \"([^\"]*)\", ScoreLowRange as \"([^\"]*)\" and ScoreHighRange as \"([^\"]*)\" validate error message displayed$") 
	 public void validateoverlaperroredit(String ScoreRangeValue,String ScoreLowRange, String ScoreHighRange) throws InterruptedException { 
		
		 assessmentbuildercombinescoringcategory.validateoverlaperror(ScoreRangeValue,ScoreLowRange, ScoreHighRange,UpdateType.Edit);
	 }
	 
	 @Then("^set added scoring category value$") 
	 public void setaddedscoringcategoryvalue() throws InterruptedException { 
		 
		 assessmentbuildercombinescoringcategory.setaddedscoringcategoryvalue();
	 }
	 
}
