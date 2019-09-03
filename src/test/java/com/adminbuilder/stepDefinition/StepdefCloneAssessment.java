package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;

import com.adminbuilder.Pages.CloneAssessment;
import com.adminbuilder.Pages.CloneAssessment.CloneAss;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Then;

public class StepdefCloneAssessment {

	TestContext testContext;
	Logger Log = Logger.getLogger("StepdefCloneAssessment.class");
	PageObjectManager pageObjectManager; 
	CloneAssessment cloneassessment;
	
	 public StepdefCloneAssessment(TestContext context) {
		 testContext = context;
		 cloneassessment = testContext.getPageObjectManager().getcloneassessment();
	 }

	@Then("^Click on Clone Assessment$")
	public void ClickClone() throws Exception {
		cloneassessment.ClickCloneAssessment();
	}
 
	@Then("^Verifying the CloneAssessment modal window$")
	public void CloningAsssessment_verifywindow() throws Exception {
		cloneassessment.CloningAsssessment_verifywindow();
	}
	
	@Then("^Cloning the assessment into different market \"([^\"]*)\"$")
	public void CloningAssessment(String CloneMarket) throws Exception {
		cloneassessment.CloningAssessment(CloneMarket);
	}
	
	@Then("^Validating the Success message after cloning the assessment$")
	public void CloneValidation() throws Exception {
		cloneassessment.CloneValidation();
	}
	
	@Then("^Validating the Duplicate Clone Assessment \"([^\"]*)\", \"([^\"]*)\"$")
	public void CloneAss_validations(String Market1, String Market2) throws Exception {
		cloneassessment.CloneAss_DupCheck(Market1,Market2);
	}
	
	@Then("^Validate Concept ID of CLoned Assessment$")
	public void validateConceptID() throws Exception {
		cloneassessment.validateConceptID();
	}
	
	@Then("^When I validate Publish grid \"([^\"]*)\"$")
	public void ValidatePublishgrid(CloneAss validatePublishgrid) throws Exception{
		cloneassessment.ValidatePublishgrid(validatePublishgrid);
	}
	
	@Then("^When I validate Task grid \"([^\"]*)\"$")
	public void ValidateTaskgrid(CloneAss validateTaskgrid) throws Exception{
		cloneassessment.ValidateTaskgrid(validateTaskgrid);
	}
	
}
