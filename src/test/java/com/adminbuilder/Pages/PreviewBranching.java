package com.adminbuilder.Pages;
import static org.junit.Assert.assertFalse;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.baseutility.WebAction.FieldType;
import com.adminbuilder.configutility.ConfReader;

public class PreviewBranching extends WebAction {
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("BranchingLogic.class");
	GlobalValues global = new GlobalValues();
	MenuNavigation leftnavigation;
	public PreviewBranching(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	

	public void clickeditfirstquestion() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		  waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("expandRow", "BranchingLogic"),driver);
		  click(FieldType.xpath, ConfReader.getInstance().getConfData("expandRow", "BranchingLogic"), driver);
		  click(FieldType.xpath, ConfReader.getInstance().getConfData("EditFirstQuestion", "PreviewBranching"), driver);
		  waitForLoadingToBecomeInvisible(driver);	  
	}
	
	public void clickSubmit() throws InterruptedException {
		Thread.sleep(3000);
		 waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("btnSubmitmodal", "PreviewBranching"),driver);
		 click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmitmodal", "PreviewBranching"), driver);
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(3000);
		 waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"),driver);
		 click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"), driver);
		 Thread.sleep(3000);
		 waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"),driver);
		 click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"), driver);
		
	
	  
}		 

	public void filterassessment() throws InterruptedException {
		  click(FieldType.xpath, ConfReader.getInstance().getConfData("btnassessmentgridFilter", "PreviewBranching"), driver);
		  click(FieldType.xpath, ConfReader.getInstance().getConfData("inputassessmentNamefilter", "PreviewBranching"), driver);
		  enter_text(GlobalValues.Assessmentname, FieldType.xpath, ConfReader.getInstance().getConfData("inputassessmentNamefilter", "PreviewBranching"), driver);
		Thread.sleep(2000);
					
	}
	
public void verifypreviewbranching(String questiondisplayedasBranched,String option,String branchquestion) throws InterruptedException {
	 click(FieldType.xpath, ConfReader.getInstance().getConfData("accrdiansinpreview", "AssessmentBuilderPreviewPage"), driver);
	 waitForLoadingToBecomeInvisible(driver);
	 Thread.sleep(2000);
	 Assert.assertTrue(validateobjectexists("//label[contains(text(),'"+branchquestion+"')]", driver));
	 Log.info("Question is present in Section");
	 selectDropdown(branchquestion,option,driver);
	 waitForLoadingToBecomeInvisible(driver);
	 Assert.assertTrue(validateobjectexists("//legend[contains(text(),'"+questiondisplayedasBranched+"')]", driver));
	 Log.info("Branched Question is present in assessment");	
	}	  	  
		  
		  
			 
}
