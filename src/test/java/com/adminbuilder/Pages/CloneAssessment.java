package com.adminbuilder.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.configutility.ConfReader;

public class CloneAssessment extends WebAction{

	WebAction webaction;
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("CloneAssessment.class");
	GlobalValues global = new GlobalValues();
	String AssessmentName = global.Assessment;
	
	public CloneAssessment(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	


public void ClickCloneAssessment() throws Exception {
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(7000);
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("ButtonGroup", "AssessmentBuilder").replace("<AssName>", AssessmentName).replace("<button>", "Clone"), driver));
	Log.info("Successfully verified the Clone button/image to the added Assessment ");
	Thread.sleep(4000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("ButtonGroup", "AssessmentBuilder").replace("<AssName>", AssessmentName).replace("<button>", "Clone"), driver);
	Log.info("Clicked on Clone button");
}

public void CloningAsssessment_verifywindow() throws Exception {
	waitForLoadingToBecomeInvisible(driver);
	String header = get_text(ConfReader.getInstance().getConfData("ModalHeader", "AssessmentBuilder"), driver);
	Assert.assertEquals(header,"Clone Assessment");
	Log.info("Verified the header of the modal window - " + header);
	
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("CloneAssName", "CloneAssessment"), driver));
	Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("CloneAssNametext", "CloneAssessment"),driver),"Assessment Name");
	Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("CloneAssName", "CloneAssessment"), driver));

	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("LTSSMarketpicklist", "CloneAssessment"), driver));
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("CloneMarketpicklist", "CloneAssessment"), driver));
	Log.info("Verified the header of picklist grids in Clone Assessment");
	
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("picklistSearch1", "CloneAssessment"), driver));
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("picklistSearch2", "CloneAssessment"), driver));
	Log.info("Verified the search fields in picklist grids in Clone Assessment");
	
	Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("btnpicklistleft", "CloneAssessment"), driver));
	Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("btnpicklistright", "CloneAssessment"), driver));
	Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("btndoubleleft", "CloneAssessment"), driver));
	Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("btndoubleright", "CloneAssessment"), driver));
	Log.info("Verified the button group of picklist grid in Clone Assessment");
	
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver));
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "submit"), driver));
	Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver));
	Log.info("Verified the Submit and Cancel buttons in Clone Assessment");
	
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Marketpicklistvalue", "CloneAssessment").replace("<CloneMarket>", "Florida"), driver);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnpicklistright", "CloneAssessment"), driver);
	Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver));
	Log.info("Verified the Submit button enabling in Clone Assessment");
	
//	String AssName = get_text(ConfReader.getInstance().getConfData("CloneAssValue", "CloneAssessment"), driver);
//	Assert.assertEquals(AssName, AssessmentName);
//	Log.info("Verfied the Assessment Name field and its value in Clone Assessment");
	
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
	Log.info("Navigate back by clicking on cancel button in Clone Assessment");
	
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(5000);
}

public void CloningAssessment(String CloneMarket) throws Exception {
	waitForLoadingToBecomeInvisible(driver);
	
	String header = get_text(ConfReader.getInstance().getConfData("ModalHeader", "AssessmentBuilder"), driver);
	Assert.assertEquals(header,"Clone Assessment");
	Log.info("Verified the header of the modal window - " + header);
	
	WebElement Ass = driver.findElement(By.xpath("//*[@id='assessmentName']/pre"));
	System.out.println("123" +Ass.getText());
	
	enterTextbox("Assessment Name", "Validating with Spl char @ ", driver);
	Thread.sleep(3000);
	
	String DupMsg = get_text(ConfReader.getInstance().getConfData("CloneSplCharMsg", "CloneAssessment"), driver);
	String Message = "Only Alphanumeric characters are allowed";
	Assert.assertEquals(DupMsg, Message);
	Thread.sleep(3000);
	Log.info("Verified the Special Character error message in Assessment Name field");

	enterTextbox("Assessment Name",  AssessmentName, driver);
	Thread.sleep(3000);
	Log.info("Cloning the Assessment to a market");
	
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Marketpicklistvalue", "CloneAssessment").replace("<CloneMarket>", CloneMarket), driver);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnpicklistleft", "CloneAssessment"), driver);
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "submit"), driver));

	click(FieldType.xpath, ConfReader.getInstance().getConfData("Marketpicklistvalue", "CloneAssessment").replace("<CloneMarket>", CloneMarket), driver);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnpicklistright", "CloneAssessment"), driver);
	
	Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver));
	Log.info("Verified the Submit button enabling in Clone Assessment");
	
	click(FieldType.xpath,ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);
	Log.info("Clicked on Submit button to clone the assessment");
		
}

public void CloneValidation() {
	waitForLoadingToBecomeInvisible(driver);
	
	String SuccessMsg = get_text(ConfReader.getInstance().getConfData("CloneSuccessMsg", "CloneAssessment"), driver);
	String SuccessAssessment = get_text(ConfReader.getInstance().getConfData("CloneSuccessAssessmentMsg", "CloneAssessment"), driver);
	System.out.println(SuccessAssessment);
	System.out.println(SuccessMsg);
	Log.info("Verified the Success message after cloning the assessement as " + SuccessAssessment + " and " +SuccessMsg);
}

public void CloneAss_DupCheck(String Market1, String Market2) throws Exception {
	waitForLoadingToBecomeInvisible(driver);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Marketpicklistvalue", "CloneAssessment").replace("<CloneMarket>", Market1), driver);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnpicklistright", "CloneAssessment"), driver);
	Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver));
	Log.info("Verified the Submit button enabling in Clone Assessment and clicking on it to validate dup check");
	
	click(FieldType.xpath, ConfReader.getInstance().getConfData("picklistSearch1", "CloneAssessment"), driver);
	Thread.sleep(2000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btndoubleleft", "CloneAssessment"), driver);
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(7000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Marketpicklistvalue", "CloneAssessment").replace("<CloneMarket>", Market1), driver);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnpicklistright", "CloneAssessment"), driver);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Marketpicklistvalue", "CloneAssessment").replace("<CloneMarket>", Market2), driver);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnpicklistright", "CloneAssessment"), driver);
	Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver));
	click(FieldType.xpath,ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);
	Thread.sleep(5000);
	String DupMsg = get_text(ConfReader.getInstance().getConfData("CloneDupCheckMsg", "CloneAssessment"), driver);
	String Message = "Similar Assessment Name already exists in "+Market1+ ", "+Market2+" Market(s), please provide another Assessment Name.";
	Assert.assertEquals(DupMsg, Message);
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "submit"), driver));
	
	Thread.sleep(3000);
	Log.info("Verified the Duplicate Check error message in Assessment Name field");
	
	click(FieldType.xpath,ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
	Thread.sleep(2000);
	Log.info("Clicked on Cancel button to close th eCLone modal window");
}

public void CaptureConceptID() {
	waitForLoadingToBecomeInvisible(driver);
	
	String ConceptID = get_text(ConfReader.getInstance().getConfData("conceptid", "AssessmentBuilder"), driver);
	System.out.println(ConceptID);
	Log.info("Capturing COncept ID");
}

public void validateConceptID() throws Exception {
	waitForLoadingToBecomeInvisible(driver);
	
	click(FieldType.xpath, ConfReader.getInstance().getConfData("ExpandRow", "AssessmentBuilder"), driver);
	Thread.sleep(2000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("QuesEdit", "AssessmentBuilder"), driver);
	
	String ConceptID = get_text(ConfReader.getInstance().getConfData("conceptid", "AssessmentBuilder"), driver);
	System.out.println(ConceptID);
	Log.info("Captured Concept ID after Cloning assessment");
	
	Assert.assertNotEquals(ConceptID, GlobalValues.ConceptID);
	Log.info("Passed - Concept ID of cloned assessment is not matching with original COncept ID");
	
}


public enum CloneAss {
	BeforeClone,
	AfterClone;
}
public void ValidatePublishgrid(CloneAss validatePublishgrid) throws Exception {
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(3000);
	switch (validatePublishgrid) {
	
	case BeforeClone :
		Assert.assertFalse(validateobjectexists(ConfReader.getInstance().getConfData("NoRecordsFound", "AssessmentBuilder"), driver));
		Log.info("Published details were present in Publish grid before cloning the assessment to different market");
		return;
	case AfterClone :
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("NoRecordsFound", "AssessmentBuilder"), driver));
		Log.info("Published details were removed in Publish grid after cloning the assessment to different market");
		return;
	}

}

public void ValidateTaskgrid(CloneAss validateTaskgrid) throws Exception {
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(3000);
	switch (validateTaskgrid) {
	
	case BeforeClone :
		Assert.assertFalse(validateobjectexists(ConfReader.getInstance().getConfData("NoRecordsFound", "AssessmentBuilder"), driver));
		Log.info("Added Task details were present in Task grid before cloning the assessment to different market");
		return;
	case AfterClone :
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("NoRecordsFound", "AssessmentBuilder"), driver));
		Log.info("Added Task details were removed in Task grid after cloning the assessment to different market");
		return;
	}

}

}



