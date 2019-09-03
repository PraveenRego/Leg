package com.adminbuilder.Pages;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adminbuilder.Pages.AssessmentBuilderaddQuestion.UpdateType;
import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.baseutility.WebAction.FieldType;
import com.adminbuilder.configutility.ConfReader;

import org.junit.Assert;

public class AssessmentBuilderAddScoringCategory extends WebAction {

	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("AssessmentBuilderAddScoringCategory.class");
	
	public AssessmentBuilderAddScoringCategory(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	
	public enum UpdateType {
		 Add,
		 Edit
	}
	

	public void validateinvalidscorerange(String ScoreLowRange, String ScoreHighRange) throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(1000);
		Log.info("Entering invalid values in ScoreLowRange and ScoreHighRange");
		enterTextbox("Low Score Range", ScoreLowRange, driver);
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("lblerrormsgScoreLowRange", "AssessmentBuilderAddScoringCategory"), driver));
		enterTextbox("High Score Range", ScoreHighRange, driver);
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("lblerrormsgScoreHighRange", "AssessmentBuilderAddScoringCategory"), driver));
		Log.info("Error message displayed successfully");
	}
	
	public void validateaddbutton(String CategoryName) throws InterruptedException {
		Log.info("Entering value in CategoryName");
		enterTextbox("Category Name", CategoryName, driver);
//		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("btnAdd", "assessmentBuilderaddQuestion"), driver));
		Log.info("When CategoryName field is entered Add button displayed successfully");
	}
	
	
	
	public void addeditscoringcategory(String ScoreRangeValue,String ScoreLowRange, String ScoreHighRange, UpdateType updatetype) throws InterruptedException {
	
		
		enterTextbox("Score Range Value", ScoreRangeValue, driver);
		enterTextbox("Low Score Range", ScoreLowRange, driver);
		enterTextbox("High Score Range", ScoreHighRange, driver);
		
		switch(updatetype) {
			case Add:
				Log.info("Adding scoring category");
		
				click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAdd", "assessmentBuilderaddQuestion"), driver);
				waitForLoadingToBecomeInvisible(driver);
				Log.info("Scoring Category added successfully");
				break;
		
		case Edit:
			click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSave", "assessmentBuilderaddQuestion"), driver);
			Log.info("Mandatory fields are entered, Save button is enabled and clicked");
			break;
			
		default:
			Log.info("Please select the correct update type ");
			break;
		}
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(3000);
		ArrayList<String> tableData = getrecentaddedformfromtable(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"), new ArrayList<>(), driver);
		
		Assert.assertEquals(ScoreRangeValue, tableData.get(0));
		Log.info("ScoreRangeValue is populated with the information provided by the user ");
		String Scorerange = ScoreLowRange + "-" + ScoreHighRange;
		
		Assert.assertEquals(Scorerange, tableData.get(1));	
		Log.info("Scorerange is populated with the information provided by the user ");
	
		waitForLoadingToBecomeInvisible(driver);
		tableData.clear();
	}
	
	
	public void validateScoringCategorygrid() throws InterruptedException {
		Log.info("Verifying Scoring Category grid");
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("lblScoringCategory", "AssessmentBuilderAddScoringCategory"), driver));
		Assert.assertEquals(getLists(ConfReader.getInstance().getConfData("tblhdranswergrid", "assessmentBuilderaddQuestion"), driver), GlobalValues.ScoringCategorygridheaders);
		
		Log.info("**Passed ** Scoring Category headers are displayed as expected " + GlobalValues.ScoringCategorygridheaders);
	}
	
	public void clicksubmit() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(3000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmit", "AssessmentBuilderAddScoringCategory"), driver);
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(1000);
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("btnAssessmentName", "AssessmentBuilder"), driver));
		
		
		Log.info("**Passed ** After clicking on submit user shall land on the previous page ");
	}

	
	public void clickBack() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnBack", "AssessmentBuilderAddScoringCategory"), driver);
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("btnAssessmentName", "AssessmentBuilder"), driver));
		waitForLoadingToBecomeInvisible(driver);
		
		Log.info("**Passed ** After clicking on Back user shall land on the previous page ");
	}
	
	
}
