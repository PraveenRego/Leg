package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;

import com.adminbuilder.Pages.AssessmentBuilderLinktoTask;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Then;

public class stepdefAssessmentBuilderLinktoTask {
	TestContext testContext;
	Logger Log = Logger.getLogger("stepdefAssessmentBuilder.class");
	PageObjectManager pageObjectManager; 
	AssessmentBuilderLinktoTask assessmentbuilderlinktotask;
	
	public stepdefAssessmentBuilderLinktoTask(TestContext context) {
		 testContext = context;
		 assessmentbuilderlinktotask = testContext.getPageObjectManager().getassessmentbuilderlinktotask();
		 }
	
	@Then("^validate Assessmentname in Link to Task page$") 
	 public void validateLinktoTaskpage() throws InterruptedException { 
				assessmentbuilderlinktotask.validateLinktoTaskpage();
		
	 }
	
	@Then("^validate Add button enabled with Taskname \"([^\"]*)\"$") 
	 public void validateaddbuttonenabled(String Task) throws InterruptedException { 
	
		assessmentbuilderlinktotask.validateaddbuttonenabled(Task);
		
	 }
	
	@Then("^Click Add button$") 
	 public void clickadd() throws InterruptedException { 
	
		assessmentbuilderlinktotask.clickadd();
		
	 }
	
	@Then("^validate tasks table headers$") 
	 public void validatetaskstableheaders() throws InterruptedException { 
	
		assessmentbuilderlinktotask.validatetaskstableheaders();
		
	 }
	
	
	@Then("^validate delete button$") 
	 public void validatedeletebutton() throws InterruptedException { 
	
		assessmentbuilderlinktotask.validatedeletebutton();
		
	 }
	
	@Then("^validate table data in the link to task grid with Taskname \"([^\"]*)\" and Required field \"([^\"]*)\"$") 
	 public void validatetabledata(String Task, String Required) throws InterruptedException { 
	
		assessmentbuilderlinktotask.validatetabledata(Task, Required);
		
	 }
	
	@Then("^Set the Assessment form switch$") 
	 public void enabletogglebutton() throws InterruptedException { 
	
		assessmentbuilderlinktotask.enabletogglebutton();
		
	 }
	
	@Then("^Get the row number from grid$") 
	 public void getrownumberfromgrid() throws InterruptedException { 
	
		assessmentbuilderlinktotask.getrownumberfromgrid();
		
	 }
	
	@Then("^Validate that after Back button the added value is not present in grid$") 
	 public void validaterownumberfromgrid() throws InterruptedException { 
	
		assessmentbuilderlinktotask.validaterownumberfromgrid();
		
	 }
	
	@Then("^Validate the tasks dropdown has no duplicate values$") 
	 public void validateduplicateTaskdropdown() throws InterruptedException { 
	
		assessmentbuilderlinktotask.validateduplicateTaskdropdown();
		
	 }
}
