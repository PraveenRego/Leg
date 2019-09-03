package com.adminbuilder.stepDefinition;

import org.apache.log4j.Logger;

import com.adminbuilder.Pages.AssessmentBuilderPreviewPage;
import com.adminbuilder.Pages.AssessmentBuilderaddQuestion;
import com.adminbuilder.baseutility.PageObjectManager;
import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.java.en.Then;

public class stepdefAssessmentBuilderPreviewPage extends WebAction{
	TestContext testContext;
	Logger Log = Logger.getLogger("stepdefAssessmentBuilderPreviewPage.class");
	PageObjectManager pageObjectManager; 
	AssessmentBuilderPreviewPage assessmentbuilderpreviewpage;

	public stepdefAssessmentBuilderPreviewPage(TestContext context) {
		 testContext = context;
		 assessmentbuilderpreviewpage = testContext.getPageObjectManager().getassessmentBuilderpreviewpage();
	}
	
    @Then("^Click on Preview of the created Assessment$")
	    public void clickonassessmentpreview() throws InterruptedException {
	           
    	assessmentbuilderpreviewpage.clickonassessmentpreview();
	    }
    
       
    
    @Then("^Verify navigation to Preview page$")
    public void verifynavigationtopreview() throws InterruptedException {
           
    	assessmentbuilderpreviewpage.verifynavigationtopreview();
    }
    
  
    
    @Then("^When I Click on Back in Preview button user is navigated to the previous page$")
    public void clickandverifynavigationtopreview() throws InterruptedException {
           
    	assessmentbuilderpreviewpage.verifynavigationtopreview();
    }
    
    
    
    @Then("^Verify Main Section exists and expand the accordian$")
    public void verifyandexpandmainsection() throws InterruptedException {
           
    	assessmentbuilderpreviewpage.verifyandexpandmainsection();
    }
    
    
    
    @Then("^Verify Expand All and Collape All links in the Preview page$")
    public void verifyexpandallandcollapsealllinks() throws InterruptedException {
           
    	assessmentbuilderpreviewpage.verifyexpandallandcollapsealllinks();
    }
    
    
    
    @Then("^Click on Expand All link and validate$")
    public void clickexpandallandvalidate() throws InterruptedException {
           
    	assessmentbuilderpreviewpage.clickexpandallandvalidate();
    }
    
    
    @Then("^Click on Collapse All link and validate$")
    public void clickcollapseallandvalidate() throws InterruptedException {
           
    	assessmentbuilderpreviewpage.clickcollapseallandvalidate();
    }
    
   
    
    @Then("^Verify Count of required questions is displayed for the Main Section and validate$")
    public void verifycountofreqdquest() throws InterruptedException {
           
    	assessmentbuilderpreviewpage.verifycountofreqdquest();
    }
    
    
    
    
    @Then("^Validate Submit Button group in Preview page$")
    public void verifysubmitbuttongrp() throws InterruptedException {
           
    	assessmentbuilderpreviewpage.verifysubmitbuttongrp();
    }
    
    
    @Then("^Verify clicking on Back button navigates user out of Preview Page$")
    public void clickandverifybackbtn() throws InterruptedException {
           
    	assessmentbuilderpreviewpage.clickandverifybackbtn();
    }
    
    
    @Then("^Click and verify Validate Form button$")
    public void clickandverifyvalidateformbtn() throws InterruptedException {
           
    	assessmentbuilderpreviewpage.clickandverifyvalidateformbtn();
    }
    
    
    @Then("^Verify Question Description content for Instructions Question Response Type$")
    public void verifyquestdescforinstructions() throws InterruptedException {
           
    	assessmentbuilderpreviewpage.verifyquestdescforinstructions();
    } 
    
    
}
