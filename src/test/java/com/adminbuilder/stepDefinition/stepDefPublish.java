package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;

import com.adminbuilder.Pages.BranchingLogic;
import com.adminbuilder.Pages.Publish;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Then;

public class stepDefPublish {
	TestContext testContext;
	Logger Log = Logger.getLogger("stepdefAssessmentBuilderCombineScoringCategory.class");
	PageObjectManager pageObjectManager; 
	Publish publish;

	public stepDefPublish(TestContext context) {
		 testContext = context;
		 publish = testContext.getPageObjectManager().getPublish();
		 
	}

	@Then("^When I click on submit after in add question page$") 
	public void clickSubmit() throws InterruptedException { 
		publish.clickSubmit();
	}
	
	@Then("^When I click Publish button in grid$") 
	public void clickPublish() throws InterruptedException { 
		publish.clickPublish();
	}
	
	@Then("^Verify attributes in publish assessment page$") 
	public void verifyAttributes() throws InterruptedException { 
		publish.verifyAttributes();
	}
	
	@Then("^Verify Environment and Effective Date are mandatory fields$") 
	public void verifyMandatoryFields() throws InterruptedException { 
		publish.verifyMandatoryFields();
	}
	
	@Then("^When I select Environment as \\\"([^\\\"]*)\\\"$")
	public void selectEnvironment(String Environment) throws InterruptedException { 
		publish.selectEnvironment(Environment);
	}
	
	@Then("^When I enter Effective Date as \\\"([^\\\"]*)\\\"$")
	public void enterEffectiveDate(String EffectiveDate) throws InterruptedException { 
		publish.enterEffectiveDate(EffectiveDate);
	}
	
	@Then("^Verify Publish Grid$") 
	public void verifypublishGrid() throws InterruptedException { 
		publish.verifypublishGrid();
	}
	
	@Then("^When I click Publish button verify Environment as \"([^\"]*)\" and Effective Date as \"([^\"]*)\"$") 
	public void verifyGrid(String Environment,String EffectiveDate) throws InterruptedException { 
		publish.verifyGrid(Environment,EffectiveDate);
	}
	
	@Then("^When I click on Back in Publish page user shall land on the previous page$") 
	public void clickBack() throws InterruptedException { 
		publish.clickBack();
	}
}
