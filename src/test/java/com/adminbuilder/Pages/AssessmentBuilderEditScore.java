package com.adminbuilder.Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.baseutility.WebAction.ElementType;
import com.adminbuilder.baseutility.WebAction.FieldType;
import com.adminbuilder.configutility.ConfReader;

public class AssessmentBuilderEditScore extends WebAction  {
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("AssessmentBuilderEditScore.class");
	GlobalValues global = new GlobalValues();
	public AssessmentBuilderEditScore(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	
	public void EditScore(String Score) throws InterruptedException {
		enterTextbox("Answer Score Value", Score, driver);
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("btnSave", "assessmentBuilderaddQuestion"), driver));
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("btnClear", "AssessmentBuilderEditScore"), driver));
		Log.info("Save and Clear buttons are present in Edit");
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSave", "assessmentBuilderaddQuestion"), driver);
		String scoreaddedingrid=get_text(ConfReader.getInstance().getConfData("scoreaddedingird", "AssessmentBuilderEditScore"),driver);
		Assert.assertEquals(Score, scoreaddedingrid);
		Log.info("Score Added to grid successfully");
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("btnAdd", "assessmentBuilderaddQuestion"), driver));
		Log.info("After clicking Save, button is changed to Add");
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnClear", "AssessmentBuilderEditScore"), driver);
		Assert.assertTrue(get_text(ElementType.Textbox,"Answer Score Value",driver).trim().isEmpty());
		Assert.assertTrue(get_text(ElementType.Textbox,"Answer Text",driver).trim().isEmpty());
		Log.info("Answer Text and Answer score textboxes are cleared after clicking Clear button");
		
	}
	
	public void duplicateError(String Answer, String Score) throws InterruptedException {
		//click(FieldType.xpath, ConfReader.getInstance().getConfData("btneditrecentrow", "assessmentBuilderaddQuestion"), driver);
		//Log.info("Edit button in the grid is clicked ");
		waitForLoadingToBecomeInvisible(driver);
		enterTextbox("Answer Text", Answer, driver);
		enterTextbox("Answer Score Value", Score, driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAdd", "assessmentBuilderaddQuestion"), driver);
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("errormessage", "AssessmentBuilderEditScore"), driver));
		Log.info("Duplicate error message is displayed");
		String scoreaddedingrid=get_text(ConfReader.getInstance().getConfData("scoreaddedingird", "AssessmentBuilderEditScore"),driver);
		Assert.assertNotEquals(Score, scoreaddedingrid);
		Log.info("Score is not updated when a duplicate answer is added");	
	}
}
