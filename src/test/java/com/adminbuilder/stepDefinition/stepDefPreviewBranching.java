package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;

import com.adminbuilder.Pages.BranchingLogic;
import com.adminbuilder.Pages.PreviewBranching;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Then;

public class stepDefPreviewBranching {
	TestContext testContext;
	Logger Log = Logger.getLogger("stepdefPreviewBranching.class");
	PageObjectManager pageObjectManager; 
	PreviewBranching previewbranching;

	public stepDefPreviewBranching(TestContext context) {
		 testContext = context;
		 previewbranching = testContext.getPageObjectManager().getpreviewbranching();
		 
	}
	
	
	//@Then("^I click on Add Assessment with assessment name \"([^\"]*)\"$") 
	@Then("^I click Edit first question$") 
	 public void clickeditfirstquestion() throws InterruptedException { 
	
		 previewbranching.clickeditfirstquestion();
	 }
	
	
	@Then("^Click submit in branching modal and add question$")
	public void clicksubmit() throws InterruptedException { 
		 previewbranching.clickSubmit();
	 }
	
	@Then("^Filter Assessment for preview branching$") 
	 public void filterassessment() throws InterruptedException { 
		 previewbranching.filterassessment();
	 }

	 @Then("^Verify question as \\\"([^\\\"]*)\\\" in Preview for option as \\\"([^\\\"]*)\\\" and branching question as \\\"([^\\\"]*)\\\"$") 
	 public void verifypreviewbranching(String questiondisplayedasBranched,String option,String branchquestion) throws InterruptedException { 
		 previewbranching.verifypreviewbranching(questiondisplayedasBranched,option,branchquestion);
	 }
	 

}
