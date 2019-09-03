package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;

import com.adminbuilder.Pages.BranchingLogic;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Then;

public class stepdefBranchingLogic {
	TestContext testContext;
	Logger Log = Logger.getLogger("stepdefAssessmentBuilderCombineScoringCategory.class");
	PageObjectManager pageObjectManager; 
	BranchingLogic branchinglogic;

	public stepdefBranchingLogic(TestContext context) {
		 testContext = context;
		 branchinglogic = testContext.getPageObjectManager().getbranchinglogic();
		 
	}
	@Then ("^I click on Add Section with section name as \\\"([^\\\"]*)\\\"$")
	public void addSection(String SectionName) throws InterruptedException { 
		
		branchinglogic.addSection(SectionName);
	 }	
	
	@Then ("^I Add question description as \\\"([^\\\"]*)\\\"$")
	public void addQstnDesc(String Description) throws InterruptedException { 
		
		branchinglogic.addQstnDesc(Description);
	 }	
	
	@Then ("^I select Section as \\\"([^\\\"]*)\\\"$")
	public void selectAssessmentSection(String SectionName) throws InterruptedException { 
		branchinglogic.selectAssessmentSection(SectionName);
	}
	@Then("^Verify no child grid is present when no branch section is added$") 
	public void validatenochildGrid() throws InterruptedException { 
		branchinglogic.validatenochildGrid();
	}
	@Then("^Verify no child grid is present when no branch section is added in Question grid as \\\"([^\\\"]*)\\\"$") 
	public void validatenochildGridinQuestionGird(String Question) throws InterruptedException { 
		branchinglogic.validatenochildGridinQuestionGird(Question);
	}
	@Then("^I click branching button$") 
	 public void clickbranchingButton() throws InterruptedException { 
		
		branchinglogic.clickbranchingButton();
	 }
	
	@Then ("^verify on load section as \\\"([^\\\"]*)\\\"$")
	public void verifyonLoadSection(String SectionName) throws InterruptedException {
		branchinglogic.verifyonLoadSection(SectionName);
	}
	
	@Then ("^verify all sections present in filter$")
	public void verifysectionlist() throws InterruptedException {
		branchinglogic.verifysectionlist();
	}
	
	@Then ("^verify picklist in modal$")
	public void verifypicklist() throws InterruptedException {
		branchinglogic.verifypicklist();
	}
	
	@Then ("^verify Add button enable and disable$")
	public void verifyAddbutton() throws InterruptedException {
		branchinglogic.verifyAddbutton();
	}
	
	@Then ("^Add question$")
	public void clickAddQuestions() throws InterruptedException {
		branchinglogic.clickAddQuestions();
	}
	
	@Then ("^verify Branched Questions grid$")
	public void verifybranchedquestionsgrid() throws InterruptedException {
		branchinglogic.verifybranchedquestionsgrid();
	}
	
	@Then("^verify Submit and Close buttons in modal$")
	public void verifySubmitandClosebuttons()  throws InterruptedException{	
		branchinglogic.verifySubmitandClosebuttons();
	}
	
	@Then("^Click on Close button in modal$")
	public void clickClosebutton()  throws InterruptedException{	
		branchinglogic.clickClosebutton();
	}
	
	
	
	@Then("^When I click Submit verify question is added as a branched question is \\\"([^\\\"]*)\\\" and question description is \\\"([^\\\"]*)\\\"$")
	public void verifySubmit(String SectionName,String QuestionDescription)  throws InterruptedException{	
		branchinglogic.verifySubmit(SectionName,QuestionDescription);
	}
	
	@Then("^I click Submit in Add question page$")
	public void clickSubmitinQstnpg()  throws InterruptedException{	
		branchinglogic.clickSubmitinQstnpg();
	}
	
	@Then("^I click Submit&AddNew in Add question page$")
	public void clickSubmitandAddnewinQstnpg()  throws InterruptedException{	
		branchinglogic.clickSubmitandAddnewinQstnpg();
	}
	
	@Then("^verify Branching in Question is \\\"([^\\\"]*)\\\" and question description is \\\"([^\\\"]*)\\\" and question branched is \\\"([^\\\"]*)\\\"$")
	public void verifybranchinginQuestion(String SectionName,String QuestionDescription,String Question)  throws InterruptedException{	
		branchinglogic.verifybranchinginQuestion(SectionName,QuestionDescription,Question);
	}

	@Then("^I click Back in Add question page$")
	public void clickBack()  throws InterruptedException{	
		branchinglogic.clickBack();
	}
	
	@Then("^When I click Close verify question is not added as a branched question$")
	public void verifyClose()  throws InterruptedException{	
		branchinglogic.verifyClose();
	}
	
	@Then("^When I click Delete button verify question is deleted from the branched question$")
	public void verifydelete()  throws InterruptedException{	
		branchinglogic.verifydelete();
	}
	
	@Then("^Edit the values in branch questions and verify$")
	public void editquestionsandverify()  throws InterruptedException{	
		branchinglogic.editquestionsandverify();
	}
	
	
}
