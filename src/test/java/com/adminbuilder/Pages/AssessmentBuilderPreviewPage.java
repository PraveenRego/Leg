package com.adminbuilder.Pages;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.baseutility.WebAction.FieldType;
import com.adminbuilder.configutility.ConfReader;

import cucumber.api.java.en.Then;

public class AssessmentBuilderPreviewPage extends WebAction {

	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("AssessmentBuilderaddQuestion.class");
	GlobalValues global = new GlobalValues();
	
	public AssessmentBuilderPreviewPage(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	
	
	
	public void clickonassessmentpreview() throws InterruptedException{
		Thread.sleep(2000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnpreviewofassessment", "assessmentBuilderaddQuestion"), driver);
		Log.info("Clicked on Preview button of Assessment that was created");
		
	}
	
	
	public void verifynavigationtopreview() throws InterruptedException{
		Thread.sleep(3000);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("hdrPreviewpage", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Clicking on Preview button navigated user to Preview page");
		Thread.sleep(3000);
		
	}
	
	
	public void verifyandexpandmainsection() throws InterruptedException{
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("hdrmainsectioninpreview", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Main Section exists in preview page");
		Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("accrdianmainsection", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Clicked on accordian to expand Main Section in preview page");
		Thread.sleep(2000);

	}
	
	
	
	public void verifyexpandallandcollapsealllinks() throws InterruptedException{
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lnkexpandallinpreview", "AssessmentBuilderPreviewPage"), driver));
		Log.info("Passed: CMDM-34437 :- Expand All link exists in Assessment Preview page");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lnkcollapseallinpreview", "AssessmentBuilderPreviewPage"), driver));
		Log.info("Passed: CMDM-34437 :- Collapse All link exists in Assessment Preview page");
		
	} 
	
	
	public void clickexpandallandvalidate() throws InterruptedException{
		
		ArrayList<String> allaccordians = getLists(ConfReader.getInstance().getConfData("accrdiansinpreview", "AssessmentBuilderPreviewPage"), driver);
		
		Log.info("Check the accordians before clicking on Expand All");
		
		for(int i=1;i<=allaccordians.size();i++) {
			String s = Integer.toString(i);
				
			String expndcolpse = validateaccordianexpandcollapse(ConfReader.getInstance().getConfData("txtreqdinaccordian", "AssessmentBuilderPreviewPage").replace("<num>", s), driver);
			Assert.assertTrue(expndcolpse.equalsIgnoreCase("false"));
				Log.info("Accordian for Main Section " + i +" is collapsed before clicking on Expand All");
			}
		
		Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("lnkexpandallinpreview", "AssessmentBuilderPreviewPage"), driver));
		Log.info("Check the accordians after clicking on Expand All");
		
		for(int i=1;i<=allaccordians.size();i++) {
			String s = Integer.toString(i);
			String expndcolpse = validateaccordianexpandcollapse(ConfReader.getInstance().getConfData("txtreqdinaccordian", "AssessmentBuilderPreviewPage").replace("<num>", s), driver);
			Assert.assertTrue(expndcolpse.equalsIgnoreCase("true"));
				Log.info("Accordian for Main Section " + i +" is expanded after clicking on Expand All");
			}
	}


	public void clickcollapseallandvalidate() throws InterruptedException{
		
		ArrayList<String> allaccordians = getLists(ConfReader.getInstance().getConfData("accrdiansinpreview", "AssessmentBuilderPreviewPage"), driver);
		Log.info("Check the accordians before clicking on Collapse All");
		
		for(int i=1;i<=allaccordians.size();i++) {
			String s = Integer.toString(i);
			String expndcolpse = validateaccordianexpandcollapse(ConfReader.getInstance().getConfData("txtreqdinaccordian", "AssessmentBuilderPreviewPage").replace("<num>", s), driver);
			Assert.assertTrue(expndcolpse.equalsIgnoreCase("true"));
				Log.info("Accordian for Main Section " + i +" is expanded before clicking on Collapse All");
			}
		
		Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("lnkcollapseallinpreview", "AssessmentBuilderPreviewPage"), driver));
		Log.info("Check the accordians after clicking on Collapse All");
		
		for(int i=1;i<=allaccordians.size();i++) {
			String s = Integer.toString(i);
			String expndcolpse = validateaccordianexpandcollapse(ConfReader.getInstance().getConfData("txtreqdinaccordian", "AssessmentBuilderPreviewPage").replace("<num>", s), driver);
			Assert.assertTrue(expndcolpse.equalsIgnoreCase("false"));
				Log.info("Accordian for Main Section " + i +" is collapsed after clicking on Collapse All");
			}
	}
	
	
	
	public void verifycountofreqdquest() throws InterruptedException{
		
		Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("lnkexpandallinpreview", "AssessmentBuilderPreviewPage"), driver));
		Thread.sleep(3000);
		ArrayList<String> allaccordians = getLists(ConfReader.getInstance().getConfData("accrdiansinpreview", "AssessmentBuilderPreviewPage"), driver);
		

		for(int i=1;i<allaccordians.size();i++) {
		ArrayList<String> requiredlabels = null;
		ArrayList<String> requiredlegends = null;	
		String s = Integer.toString(i);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("txtrequrdinpreview", "AssessmentBuilderPreviewPage").replace("<num>", s), driver));
		Log.info("Count of Required questions is displayed for Main Section "+s);
		
		String reqdtxtdisplayed = get_text(ConfReader.getInstance().getConfData("txtrequrdinpreview", "AssessmentBuilderPreviewPage").replace("<num>", s), driver);
		
		String numofreqfieldsdisplayed = reqdtxtdisplayed.substring(15);
		
		int numreqd = Integer.parseInt(numofreqfieldsdisplayed);
		
		requiredlabels = getLists(ConfReader.getInstance().getConfData("requiredfieldineachsectionlabels", "AssessmentBuilderPreviewPage").replace("<num>", s), driver);
		Thread.sleep(3000);
		if(validateobjectexists(ConfReader.getInstance().getConfData("requiredfieldineachsectionlegends", "AssessmentBuilderPreviewPage").replace("<num>", s), driver)) {
		requiredlegends = getLists(ConfReader.getInstance().getConfData("requiredfieldineachsectionlegends", "AssessmentBuilderPreviewPage").replace("<num>", s), driver);
		Thread.sleep(2000);
		}
		
		
		int totalcountofrequiredfieldinonesection=requiredlabels.size()+requiredlegends.size();
		
		Assert.assertEquals(numreqd, totalcountofrequiredfieldinonesection);
		Log.info("Number of required fields is displayed as expected for section "+s);
		
		
		}	
	}
	
	
	public void verifysubmitbuttongrp() throws InterruptedException{
//		Log.info("Verify the presence of Submit button group");
//		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("btngrpsubmit", "AssessmentBuilderPreviewPage"), driver));
//		Log.info("CMDM-33394 :Passed - Submit button group exists in the preview page");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("btnsinsubmitbtngrp", "AssessmentBuilderPreviewPage").replace("<btnname>", "submit"), driver)
			&& validatebuttondisabled(ConfReader.getInstance().getConfData("btnsinsubmitbtngrp", "AssessmentBuilderPreviewPage").replace("<btnname>", "submit"), driver));
		Log.info("CMDM-33394 : Passed -  Submit button exists and is disabled on loading the preview page");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("btnvalidateforminpreview", "AssessmentBuilderPreviewPage"), driver)
				&& !validatebuttondisabled(ConfReader.getInstance().getConfData("btnvalidateforminpreview", "AssessmentBuilderPreviewPage"), driver));
		Log.info("CMDM-33394 : Passed -  Validate Form button exists and is enabled on loading the preview page");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("btnback", "AssessmentBuilderPreviewPage"), driver));
		Log.info("CMDM-33394 : Passed -  Back button exists in the preview page");
		
	}
	
	
	public void clickandverifybackbtn() throws InterruptedException{
		Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("btnback", "AssessmentBuilderPreviewPage"), driver));
		Thread.sleep(3000);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("hdrAssessmentBuilder", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Clicking on Back navigated user out of the Preview page");
	}
	
	
	public void clickandverifyvalidateformbtn() throws InterruptedException{
		Thread.sleep(2000);
		Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("btnvalidateforminpreview", "AssessmentBuilderPreviewPage"), driver));
		Log.info("Clicked on Validate Form button");
		Thread.sleep(2000);
//		ArrayList<String> requiredfieldschkbox = getLists(ConfReader.getInstance().getConfData("lblchkboxfieldsinpreview", "AssessmentBuilderPreviewPage"), driver);
//		ArrayList<String> requiredfieldsradiobtn = getLists(ConfReader.getInstance().getConfData("lblchkbxgrpradiobtninpreview", "AssessmentBuilderPreviewPage"), driver);
//		ArrayList<String> requiredfieldsothers = getLists(ConfReader.getInstance().getConfData("lblothrfieldsinpreview", "AssessmentBuilderPreviewPage"), driver);
//		
		
		ArrayList<String> allrequiredfields = getLists(ConfReader.getInstance().getConfData("errmsgallrequiredfields", "AssessmentBuilderPreviewPage"), driver);
		
		for(int i=1;i<=allrequiredfields.size();i++) {
			//int k=i-1;
			String s1 = Integer.toString(i);
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("errmsgeachrequiredfield", "AssessmentBuilderPreviewPage").replace("<num>", s1), driver));
			
//			if(validateobjectexists(ConfReader.getInstance().getConfData("lblchkboxinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>", GlobalValues.ConceptIDtohold.get(k)), driver)) {
//				String fieldname = get_text(ConfReader.getInstance().getConfData("lblchkboxinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>", GlobalValues.ConceptIDtohold.get(k)), driver);
//				Log.info("Passed: Error message for required field is displayed for field "+fieldname+ " in Preview page");
//			}else if(validateobjectexists(ConfReader.getInstance().getConfData("lblchkboxgrpinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>", GlobalValues.ConceptIDtohold.get(k)), driver)) {
//				String fieldname = get_text(ConfReader.getInstance().getConfData("lblchkboxgrpinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>", GlobalValues.ConceptIDtohold.get(k)), driver);
//				Log.info("Passed: Error message for required field is displayed for field "+fieldname+ " in Preview page");
//			}else if(validateobjectexists(ConfReader.getInstance().getConfData("lblcalendarinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>", GlobalValues.ConceptIDtohold.get(k)), driver)) {
//				String fieldname = get_text(ConfReader.getInstance().getConfData("lblcalendarinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>", GlobalValues.ConceptIDtohold.get(k)), driver);
//				Log.info("Passed: Error message for required field is displayed for field "+fieldname+ " in Preview page");
//			}else if(validateobjectexists(ConfReader.getInstance().getConfData("lbldrpdown", "AssessmentBuilderPreviewPage").replace("<conceptid>", GlobalValues.ConceptIDtohold.get(k)), driver)) {
//				String fieldname = get_text(ConfReader.getInstance().getConfData("lbldrpdown", "AssessmentBuilderPreviewPage").replace("<conceptid>", GlobalValues.ConceptIDtohold.get(k)), driver);
//				Log.info("Passed: Error message for required field is displayed for field "+fieldname+ " in Preview page");
//			}else if(validateobjectexists(ConfReader.getInstance().getConfData("lblradiobtninpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>", GlobalValues.ConceptIDtohold.get(k)), driver)) {
//				String fieldname = get_text(ConfReader.getInstance().getConfData("lblradiobtninpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>", GlobalValues.ConceptIDtohold.get(k)), driver);
//				Log.info("Passed: Error message for required field is displayed for field "+fieldname+ " in Preview page");
//			}else if(validateobjectexists(ConfReader.getInstance().getConfData("lbltextareainpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>", GlobalValues.ConceptIDtohold.get(k)), driver)) {
//				String fieldname = get_text(ConfReader.getInstance().getConfData("lbltextareainpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>", GlobalValues.ConceptIDtohold.get(k)), driver);
//				Log.info("Passed: Error message for required field is displayed for field "+fieldname+ " in Preview page");
//			}else if(validateobjectexists(ConfReader.getInstance().getConfData("lbltextfieldinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>", GlobalValues.ConceptIDtohold.get(k)), driver)) {
//				String fieldname = get_text(ConfReader.getInstance().getConfData("lbltextfieldinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>", GlobalValues.ConceptIDtohold.get(k)), driver);
//				Log.info("Passed: Error message for required field is displayed for field "+fieldname+ " in Preview page");
//			}
		}	

		Log.info("Error message is displayed for all the required fields in the preview page");
		//Commented since Validate Form button is disabled when there are required fields empty
		
//			Log.info("Enter the values for some of the required fields and check the Validate Form button");
//		
//		
//		for(int i=0;i<allrequiredfields.size();i=i+4) {
//			String conceptid = GlobalValues.ConceptIDtohold.get(i);
//			String dropdownfieldlabel = get_text(ConfReader.getInstance().getConfData("lbldrpdown", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid), driver);
//			if(click(FieldType.xpath, ConfReader.getInstance().getConfData("chkboxinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid ), driver)){
//				Log.info("Clicked on checkbox for Question with Concept ID "+conceptid);
//				
//			}else if(click(FieldType.xpath,ConfReader.getInstance().getConfData("chkboxgrpinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid),driver)){
//				Log.info("Clicked on checkbox group for Question with Concept ID "+conceptid);
//				
//			}else if(enter_text("06/18/2019", FieldType.xpath, ConfReader.getInstance().getConfData("calendarinpreview", "AssessmentBuilderPreviewPage"), driver)) {
//				Log.info("Entered date field for Question with Concept ID "+conceptid);
//				
//			}else if(selectDropdown(dropdownfieldlabel, "Yes", driver)) {
//				Log.info("Selected Value in drop down field with Concept ID "+conceptid);
//				
//			}else if(click(FieldType.xpath, ConfReader.getInstance().getConfData("radiobtn1inpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid), driver)) {
//				Log.info("Selected option in radio button group for Question with Concept ID "+conceptid);
//				
//			}else if(enter_text("Test Text Area", FieldType.xpath, ConfReader.getInstance().getConfData("txtareainpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid), driver)) {
//				Log.info("Entered text in Text Area for Question with Concept ID "+conceptid);
//				
//			}else if(enter_text("Test Text field", FieldType.xpath, ConfReader.getInstance().getConfData("txtfieldinpreview", "AssessmentBuilderPreviewPage"), driver)) {
//				Log.info("Entered text in Text Field for Question with Concept ID "+conceptid);
//				
//			}
//		}
//		
//		
//		Assert.assertTrue(!validatebuttondisabled(ConfReader.getInstance().getConfData("btnvalidateforminpreview", "AssessmentBuilderPreviewPage"), driver));
//		Log.info("Passed: After user inputs a few required fields, Validate Form button is still enabled");
//		
//		Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("btnvalidateforminpreview", "AssessmentBuilderPreviewPage"), driver));
//		Thread.sleep(2000);
//		
//		for(int i=0;i<allrequiredfields.size();i=i+4) {
//			String s = Integer.toString(i);
//			
//			Assert.assertTrue(!validateobjectexists(ConfReader.getInstance().getConfData("errmsgeachrequiredfield", "AssessmentBuilderPreviewPage").replace("<num>", s), driver));
//			Log.info("Passed: Error message for required field is not displayed for radio button field in Preview page");
//			
//		}
//		
//		Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("btnvalidateforminpreview", "AssessmentBuilderPreviewPage"), driver));
//		Thread.sleep(2000);
//
//		ArrayList<String> remrequiredfields = getLists(ConfReader.getInstance().getConfData("errmsgallrequiredfields", "AssessmentBuilderPreviewPage"), driver);
//		
//		int numofreqfields = remrequiredfields.size();
//		Assert.assertTrue(numofreqfields==allrequiredfields.size()-4);
//		Log.info("Passed: Error message is displayed for the fields which do not have user inputs");
		
		for(int i=0;i<allrequiredfields.size();i++) {
			String conceptid = GlobalValues.ConceptIDtohold.get(i);
			
			if(validateobjectexists(ConfReader.getInstance().getConfData("chkboxinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid ), driver)) {
				Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("chkboxinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid ), driver));
				Log.info("Clicked on checkbox for Question with Concept ID "+conceptid);
				
			}else if(validateobjectexists(ConfReader.getInstance().getConfData("chkboxgrpinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid ), driver)) {
				Assert.assertTrue(click(FieldType.xpath,ConfReader.getInstance().getConfData("chkboxgrpinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid),driver));
				Log.info("Clicked on checkbox group for Question with Concept ID "+conceptid);
				
			}else if(validateobjectexists(ConfReader.getInstance().getConfData("calendarinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid ), driver)) {
				Assert.assertTrue(enter_text("06/18/2019", FieldType.xpath, ConfReader.getInstance().getConfData("calendarinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid ), driver));
				Log.info("Entered date field for Question with Concept ID "+conceptid);
				
			}else if(validateobjectexists(ConfReader.getInstance().getConfData("lbldrpdown", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid ), driver)
					&& validateobjectexists(ConfReader.getInstance().getConfData("drpdownfieldinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid ), driver)) {
				String drpdownfieldname = get_text(ConfReader.getInstance().getConfData("lbldrpdown", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid),driver);
				Assert.assertTrue(selectDropdown(drpdownfieldname, "Yes", driver));
				Log.info("Selected Value in drop down field with Concept ID "+conceptid);
				
			}else if(validateobjectexists(ConfReader.getInstance().getConfData("radiobtn1inpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid ), driver)) {
				Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("radiobtn1inpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid), driver));
				Log.info("Selected option in radio button group for Question with Concept ID "+conceptid);
				
			}else if(validateobjectexists(ConfReader.getInstance().getConfData("txtareainpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid ), driver)) {
				Assert.assertTrue(enter_text("Test Text Area", FieldType.xpath, ConfReader.getInstance().getConfData("txtareainpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid), driver));
				Log.info("Entered text in Text Area for Question with Concept ID "+conceptid);
				
			}else if(validateobjectexists(ConfReader.getInstance().getConfData("txtfieldinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid ), driver)) {
				Assert.assertTrue(enter_text("Test Text field", FieldType.xpath, ConfReader.getInstance().getConfData("txtfieldinpreview", "AssessmentBuilderPreviewPage").replace("<conceptid>",conceptid ), driver));
				Log.info("Entered text in Text Field for Question with Concept ID "+conceptid);
			}
				
		}
		
		
		
		Assert.assertTrue(validatebuttondisabled(ConfReader.getInstance().getConfData("btnvalidateforminpreview", "AssessmentBuilderPreviewPage"), driver));
		Log.info("Validate Form button is disabled after user inputs all the required fields");
		
		
		Assert.assertTrue(!validatebuttondisabled(ConfReader.getInstance().getConfData("btnsinsubmitbtngrp", "AssessmentBuilderPreviewPage").replace("<btnname>", "submit"), driver));
		Log.info("Submit button is enabled after user inputs all the required fields");
		Assert.assertTrue(click(FieldType.xpath, (ConfReader.getInstance().getConfData("btnsinsubmitbtngrp", "AssessmentBuilderPreviewPage").replace("<btnname>", "submit")), driver));
		Log.info("Clicked on Submit button");
		Thread.sleep(3000);
	}
	
	public void verifyquestdescforinstructions() throws InterruptedException{
		waitForLoadingToBecomeInvisible(driver);
		
		ArrayList<String> questiondescinpreview = getLists(ConfReader.getInstance().getConfData("txtallquesdescinpreview", "assessmentBuilderaddQuestion"), driver);
		Thread.sleep(3000);
		assertTrue(GlobalValues.QuestDesctohold.containsAll(questiondescinpreview));
		Log.info("Passed: CMDM-34230 - Question descriptions added in the Default section, Main Section and Sub Sections ");
		
	}
	
}
