package com.adminbuilder.Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.baseutility.WebAction.FieldType;
import com.adminbuilder.configutility.ConfReader;

public class Publish extends WebAction{
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("BranchingLogic.class");
	GlobalValues global = new GlobalValues();
	public Publish(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	
	
	public void clickSubmit ()throws InterruptedException {
		
		click(FieldType.xpath,ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"), driver);
		waitForLoadingToBecomeInvisible(driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("lnkAssessmentFormBuilder", "MenuNavigation"), driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("lnkAssessmentBuilder", "MenuNavigation"), driver);
		Log.info("Click on AssessmentBuilder button");
		waitForLoadingToBecomeInvisible(driver);
		}
	
	public void clickPublish ()throws InterruptedException {
		GlobalValues.AssesmentModifiedon=get_text(ConfReader.getInstance().getConfData("assessmentModifiedon", "Publish"),driver).trim();;
		 waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("btnPublishingrid", "Publish"),driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnPublishingrid", "Publish"), driver);
		waitForLoadingToBecomeInvisible(driver);
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("publishPageTilte", "Publish"), driver));
		Log.info("After clicking publish button page with Header Title: Publish Assessment opens");

	}
		
	public void verifyAttributes ()throws InterruptedException {
		System.out.println(GlobalValues.Assessmentname);
		String Assessmentreadonly=get_text(ElementType.Textbox,"Assessment Name",driver);
		System.out.println("Assessmentreadonly"+Assessmentreadonly);
		Assert.assertEquals(GlobalValues.Assessmentname, Assessmentreadonly);
		Log.info("Assessment Name value is auto populated" );
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("inpDropdown", "generic").replace("<fieldname>", "Environment"), driver));
		Log.info("Environment dropdown is displayed" );
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("inpTextbox", "generic").replace("<fieldname>", "Effective Date"), driver));
		Log.info("Effective Date field is displayed" );
		
		Assert.assertTrue(!(validatebuttondisabled(ConfReader.getInstance().getConfData("btnBack", "assessmentBuilderaddQuestion"), driver)));
		Log.info("Back is displayed" );
		
	}
	
	public void verifyMandatoryFields ()throws InterruptedException {
		Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("lblEnvironment", "Publish"), driver)
				&& validateobjectmandatory(ConfReader.getInstance().getConfData("lblEffectiveDate", "Publish"), driver));
		Assert.assertTrue((validatebuttondisabled(ConfReader.getInstance().getConfData("btnPublish", "Publish"), driver)));
		Log.info("When Mandatory fields are not entered, Publish button is disabled ");
	}
	
	public void selectEnvironment (String Environment)throws InterruptedException {
		selectDropdown("Environment", Environment, driver);
		Log.info("Environment is selected as "+Environment);
	}
	
	public void enterEffectiveDate (String EffectiveDate)throws InterruptedException {
		enterTextbox("Effective Date", EffectiveDate, driver);
		Log.info("Effective Date is selected as "+EffectiveDate);
		Assert.assertTrue(!(validatebuttondisabled(ConfReader.getInstance().getConfData("btnPublish", "Publish"), driver)));
		Log.info("Publish button is Enabled" );
		
	}
	
	public void verifyGrid(String Environment,String EffectiveDate)throws InterruptedException {
		
	
		 waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("btnPublish", "Publish"),driver);
			click(FieldType.xpath, ConfReader.getInstance().getConfData("btnPublish", "Publish"), driver);
			String currentDate=getcurrentdate("MM/dd/YYYY hh:mm a",driver);
			System.out.println("currentDate::"+currentDate);
			waitForLoadingToBecomeInvisible(driver);	
		String EnvText=get_text(ConfReader.getInstance().getConfData("gridEnv", "Publish"),driver).trim();
		Assert.assertEquals(Environment, EnvText); 
		
		String EffText=get_text(ConfReader.getInstance().getConfData("gridEffDate", "Publish"),driver).trim();
		Assert.assertTrue( EffText.contains(EffectiveDate));
		
		String PublishBy=get_text(ConfReader.getInstance().getConfData("gridPublishedBy", "Publish"),driver).trim();
		String userName=get_text(ConfReader.getInstance().getConfData("userName", "Publish"),driver).trim();
		Assert.assertEquals(userName, PublishBy);
		
		String updatedOn=get_text(ConfReader.getInstance().getConfData("gridLastUpdatedon", "Publish"),driver).trim();
		String assessmentModified=GlobalValues.AssesmentModifiedon;
		System.out.println("assessmentModified::"+assessmentModified);
		Assert.assertEquals(assessmentModified, updatedOn);
		
		String PublishOn=get_text(ConfReader.getInstance().getConfData("gridPublishon", "Publish"),driver).trim();
		Assert.assertEquals(currentDate, PublishOn);
		
		String PublishStatus=get_text(ConfReader.getInstance().getConfData("gridPublishStatus", "Publish"),driver).trim();
		Assert.assertEquals("New", PublishStatus);
		
		Log.info("All values are updated in publish grid as expected");
		
	}
	
	public void verifypublishGrid() throws InterruptedException {
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("lblPublish", "Publish"), driver));
		Assert.assertEquals(getLists(ConfReader.getInstance().getConfData("publishHeader", "Publish"), driver), GlobalValues.PublishGrid);
		Log.info("Publish Grid column headers are displayed as expected ");
		
	}
	
	public void clickBack() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnBack", "AssessmentBuilderAddScoringCategory"), driver);
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("AddAssessment", "AssessmentBuilder"), driver));
		waitForLoadingToBecomeInvisible(driver);
		
		Log.info(" After clicking on Back user shall land on the previous page ");
}
}