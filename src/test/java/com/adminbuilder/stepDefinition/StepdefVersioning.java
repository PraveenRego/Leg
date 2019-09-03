package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;
import com.adminbuilder.Pages.Versioning;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepdefVersioning {

	TestContext testContext;
	Logger Log = Logger.getLogger("StepdefVersioning.class");
	PageObjectManager pageObjectManager; 
	Versioning versioning;
	
	 public StepdefVersioning(TestContext context) {
		 testContext = context;
		 versioning = testContext.getPageObjectManager().getversioning();
	 }
	 
	 @When ("^I click on Tempalte grid expand row$")
	 public void ClickExpandRow() throws Exception {
		 versioning.ClickExpandRow();
	 }
	 
	 @Then("^Verifying the previous versioning grid$")
	 public void VersioingGrid() throws Exception {
		 versioning.VersioningGrid();
		 versioning.ValidateVersioningButtonGroup();
	 }
	 
	 @Then("^I click on Edit Assessment Versioning button$")
	 public void ClickEditVersioning() throws Exception {
		 versioning.EditVersioningClick();
	 }
	 
	 @Then("^I Click on Re-Publish Versioning button$")
	 public void ClickRePublish() throws Exception {
		 versioning.RePublishClick();
	 }
	 
	 @Then("^Validating the Edit Assessment Versioning modal window$")
	 public void VersioningEditModalWindow() {
		 versioning.VersioningEditModalWindow();
	 }
	 
	 @Then("^Validating the Re-Publish Assessment modal window$")
	 public void VersioningRePublishModalWindow() {
		 versioning.VersioningRePublishModalWindow();
	 }
	 
	 @Then("^Validating the pagination of the Versioning grid$")
	 public void Versioning_pagination() throws Exception {
		 versioning.numberOfColumnsInGridForpagination("Previously Published Version", 10);
	 }
	 
	 @Then("^Validating the Assessment name after click on Edit versioning$")
	 public void ValidateAssessment_Versioning() throws Exception {
		 versioning.ValidateAssessment_EditVersioning();
	 }
	 
	 @Then("^Validaitng the Assesssment name after click on Republish Assessment$")
	 public void ValidateAssessment_RePublishVersioning() throws Exception {
		 versioning.ValidateAssessment_RePublishVersioning();
	 }
}
