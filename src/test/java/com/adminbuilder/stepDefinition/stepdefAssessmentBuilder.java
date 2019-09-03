
package com.adminbuilder.stepDefinition;


import org.apache.log4j.Logger;
import com.adminbuilder.Pages.AssessmentBuilder;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.cucumber.TestContext;
import com.adminbuilder.enums.Contextenum;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class stepdefAssessmentBuilder extends WebAction {
	TestContext testContext;
	Logger Log = Logger.getLogger("stepdefAssessmentBuilder.class");
	PageObjectManager pageObjectManager; 
	AssessmentBuilder assessmentbuilder;
	
	 public stepdefAssessmentBuilder(TestContext context) {
		 testContext = context;
		 assessmentbuilder = testContext.getPageObjectManager().getAssessmentBuilder();
	 }
		
	 @Then("^I click on Add Assessment with assessment name \"([^\"]*)\"$") 
	 public void clickAddAssessment(String Assesmentname) throws InterruptedException { 
	
		 assessmentbuilder.clickAddAssessment(Assesmentname);
		 
		
	 }
	 
	 @Then("^I click on Add Assessment with assessment name \"([^\"]*)\" and do not click$") 
	 public void enterAddAssessment(String Assesmentname) throws InterruptedException { 
	
		 assessmentbuilder.enterAddAssessment(Assesmentname);
		
	 }
	 
	 @Then("^I click on Add Assessment$") 
	 public void AddAssessmentonly() throws InterruptedException { 
	
		 assessmentbuilder.clickAddAssessmentonly();
		
	 }
	 
	 @And("^I click on Add Question$") 
	 public void clickAddQuestion() throws InterruptedException { 
	
		 assessmentbuilder.clickAddQuestion();
		
	 }
	 
	 @And("^I click on Add Scoring Category$") 
	 public void clickAddScoringCategory() throws InterruptedException { 
	
		 assessmentbuilder.clickAddScoringCategory();
		
	 }
	 
	 @And("^I click on Add Combine Scoring Category$") 
	 public void clickCombineScoringCategory() throws InterruptedException { 
	
		 assessmentbuilder.clickCombineScoringCategory();
		
	 }
	 
	 @And("^I click on Link to Tasks$") 
	 public void clickLinktotask() throws InterruptedException { 
	
		 assessmentbuilder.clickLinktotask();
		
	 }
	 
	 @Then("^verify scoring categories header and the grid displays only 5 records per page$") 
	 public void verifyscoringcategoriesgrid() throws InterruptedException { 
	
		 assessmentbuilder.verifyscoringcategoriesgrid();
		
	 }
	 
	 @Then("^Filter the scoring categories grid with Scoring Category name \"([^\"]*)\"$") 
	 public void enterscoringcategoriesgridfilter(String Filtervalue) throws InterruptedException { 
	
		 assessmentbuilder.enterscoringcategoriesgridfilter(Filtervalue);
		
	 }
	 
	 @Then("^Verify the Filter of scoring categories grid with Scoring Category name \"([^\"]*)\",ScoreRangeValue \"([^\"]*)\", ScoreLowRange \"([^\"]*)\" and ScoreHighRange \"([^\"]*)\"$") 
	 public void verifyscoringcategoriesgridfilter(String Filtervalue, String ScoreRangeValue,String ScoreLowRange, String ScoreHighRange) throws InterruptedException { 
	
		 assessmentbuilder.verifyscoringcategoriesgridfilter(Filtervalue, ScoreRangeValue,ScoreLowRange, ScoreHighRange);
		
	 }
	 
	 @Then("^Verify the Filter of Group scoring categories grid with Scoring Category name \"([^\"]*)\",ScoreRangeValue \"([^\"]*)\", ScoreLowRange \"([^\"]*)\" and ScoreHighRange \"([^\"]*)\"$") 
	 public void verifygroupscoringcategoriesgridfilter(String Filtervalue, String ScoreRangeValue,String ScoreLowRange, String ScoreHighRange) throws InterruptedException { 
	
		 assessmentbuilder.verifygroupscoringcategoriesgridfilter(Filtervalue, ScoreRangeValue,ScoreLowRange, ScoreHighRange);
		
	 }
	 
	 @And("^verify scoringcategories grid headers$") 
	 public void verifyscoringcategoriesgridheaders() throws InterruptedException { 
	
		 assessmentbuilder.verifyscoringcategoriesgridheaders();
		
	 }

	 
	 @And("^click scoringcategories grid edit$") 
	 public void clickeditscoringcategoriesgrid() throws InterruptedException { 
	
		 assessmentbuilder.clickeditscoringcategoriesgrid();
		
	 }
	 
	 @And("^click scoringcategories grid delete and verify$") 
	 public void clickdeletescoringcategoriesgridandverify() throws InterruptedException { 
	
		 assessmentbuilder.clickdeletescoringcategoriesgridandverify();
		
	 }

	 @Then("^Verify Add Assessment page$")
	 public void VerifyAddAssessment() {
		 assessmentbuilder.AddAssessmentPageVerify();
	 }
	 
	 @And("^Adding an Assessment$")
	 public void AddingAssessment() throws Exception {
		 assessmentbuilder.AddingAssessment();
	 }
	 
	 @And("^Verifying Added Assessment$")
		public void VerifyAssessment() throws InterruptedException {
		 assessmentbuilder.verifyAddedAssessment();
		}
	 
	 @Then("^Click on Edit Assessment$")
	 public void ClickEditAssessment() throws InterruptedException {
		 assessmentbuilder.EditAsssessment();
	 }
	 
	 @And("^Editing the added Assessment$")
		public void editAssessment() throws Exception {
		 assessmentbuilder.EditingAssessment();
		 assessmentbuilder.verifyEditedAssessment();
		}
	 
	 @Then("^Click on Add Section$")
		public void clickAddAssessment() throws InterruptedException {
		 assessmentbuilder.clickAddSection();
		}
	 
	 @Then("^Verifying the Section Modal window$")
		public void VerifySectionwindow() throws Exception {
		 assessmentbuilder.VerifySectionModalWindow();
		 assessmentbuilder.AddMainSection();
		}
	 
	 @And("^Adding and Verifying Main Section$")
		public void AddingMainsection() throws Exception {
		 assessmentbuilder.AddMainSection();
		 assessmentbuilder.SubmitMainSection();
		 assessmentbuilder.verifyAddedMainSection();
		}
//	 
//	 @And("^Adding and Verifying Main Section$")
//		public void AddingMainsection() throws Exception {
//		 assessmentbuilder.AddMainSection();
//		 
//		}
	 
	 @And("^Adding the Second Main Section$")
		public void SecondMainSection() throws Exception {
		 assessmentbuilder.AddSecondMainSection_Verify();
		}
	 
	 @And("^Adding and Verifying Sub Section$")
		public void AddingSubsection() throws Exception {
		 assessmentbuilder.AddSubSection();
		 assessmentbuilder.verifyAddedSubSection();
		}
	 
	 @And("^Adding the Second Sub Section$")
		public void SecondSubSection() throws Exception {
		 assessmentbuilder.AddSecondSubSection_Verify();
		}
	 
		@And("^Verifying the Added Sections in Assessment Section dropdown in Add Question page$")
		public void verifyingSectionsInDropdown_AddQuestion() throws Exception {
			assessmentbuilder.VerifyingAddedSections_AddQuestionPage();
		}
		
		@And("^Verifying the Added Sections in Assessment Section dropdown in Add Section page$")
		public void verifyingSectionsInDropdown_AddSection() throws Exception {
			assessmentbuilder.VerifyingAddedSections_AddSectionPage();
		}
		
		@Then("^Editing and Deleting the Main and Sub Section$")
		public void EditDeleteMainSection() throws Exception {
			assessmentbuilder.EditDeleteMainSection();
			assessmentbuilder.EditDeleteSubSection();
		}
		
		@Then("^Verifying the Duplicate Assessment$")
		public void VerifyDuplicateAssessment() throws Exception {
			assessmentbuilder.VerifyDuplicateAssessment();
		}
		
		@Then("^Verifying the Duplicate Sessions$")
		public void verifyDupSecions() throws Exception {
			assessmentbuilder.verifyDupSecions();
		}
		
		@Then("^Verify Assessment Template Grid$")
		public void VerifyTemplateGrid() throws Exception {
			assessmentbuilder.validateAssessmentTemplateGrid();
		}
		
		@And("^Filtering the Assessment Template Grid$")
		public void FilterTemplategrid() throws Exception {
			assessmentbuilder.filterAssessmentTemplateGrid();
		}
		
		@And("^Verify Default section in Template Grid - enters \"([^\"]*)\", \"([^\"]*)\"$")
		public void verifyDefaultSection(String QuesDesc,String QuesResTyp) throws Exception {
			assessmentbuilder.clickAddQuestion();
			assessmentbuilder.Add_VerifyDefaultSection(QuesDesc,QuesResTyp);
		}
		
		@Then ("^Verify Assessment Builder page$") 
		  public void VerifyAssessmentBuilder() throws Exception {
			assessmentbuilder.AssessmentBuilderPageverify();
			assessmentbuilder.numberOfColumnsInGridForpagination("Assessment/Form", 10);
			assessmentbuilder.filterAssessmentBuilderGrid();
			assessmentbuilder.Verify_ButtonGroups();
		}

		@Then ("^Verify Assessment Builder page headers$") 
		  public void VerifyAssessmentBuilderpageheaders() throws Exception {
			assessmentbuilder.AssessmentBuilderPageverify();
			
		}
		
		@Then ("^Verify Assessment Builder page buttons$") 
		  public void VerifyAssessmentBuilderbuttons() throws Exception {
						   assessmentbuilder.Verify_ButtonGroups();
		}
		
		 @Then("^When I click on submit in add assessment user shall land on the previous page$") 
		 public void clicksubmit() throws InterruptedException { 
			
			 assessmentbuilder.clicksubmit();
		 }
		 
		 @Then("^Filter the Assessment grid with the recently added$") 
		 public void filterassessment() throws InterruptedException { 
			
			 assessmentbuilder.filterassessment();
		 }
		 
		 @Then("^I click on Link button from Assessment Dashboard$") 
		 public void clickonrecentassessmentlink() throws InterruptedException { 
			
			 assessmentbuilder.clickonrecentassessmentlink();
		 }

		 @Then("^Edit Market Specific Assessment \"([^\"]*)\"$")
		 public void MarketSpecifcAssessment(String MarketName) throws Exception {
			 assessmentbuilder.MarketSpecifcAssessment(MarketName);
		 }
		 
		 @Then("^Verify Market Specific Assessment \"([^\"]*)\"$")
		 public void Verify_MarketSpecifcAssessment(String MarketName) throws Exception {
			 assessmentbuilder.Verify_MarketSpecificAssessment(MarketName);
		 }
		 
		@And("^Validating the missing scenarios$") 
		public void validatingScenarios() throws Exception {
			assessmentbuilder.MissedScenarios();
		}

       
}

