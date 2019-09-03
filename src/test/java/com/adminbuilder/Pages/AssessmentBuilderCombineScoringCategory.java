package com.adminbuilder.Pages;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adminbuilder.Pages.AssessmentBuilderAddScoringCategory.UpdateType;
import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.baseutility.WebAction.FieldType;
import com.adminbuilder.configutility.ConfReader;

public class AssessmentBuilderCombineScoringCategory extends WebAction {
	
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("AssessmentBuilderCombineScoringCategory.class");
	GlobalValues global = new GlobalValues();
	public AssessmentBuilderCombineScoringCategory(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	
	public enum UpdateType {
		 Add,
		 Edit
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

public void addGroupCategoryDescriptionCategory(String GroupCategoryDescription) throws InterruptedException {
	Log.info("Entering value in Group Category Description");
	enterTextbox("Group Category Description", GroupCategoryDescription, driver);
}

public void addScoringCategory() throws InterruptedException {
	Log.info("Adding Scoring Category");
	String ScoreCategory = get_text(ConfReader.getInstance().getConfData("tblScoreCategoryfirstvalue", "AssessmentBuilderCombineScoringCategory"), driver);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("tblScoreCategory", "AssessmentBuilderCombineScoringCategory"), driver);
	Thread.sleep(1000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnpicklistright", "AssessmentBuilderCombineScoringCategory"), driver);
	waitForLoadingToBecomeInvisible(driver);
	ArrayList<String> s = getrecentaddedfrommultiselect(ConfReader.getInstance().getConfData("tblScoreCategoryAddedrecentvalue", "AssessmentBuilderCombineScoringCategory"), new ArrayList<>(), driver);
	String ScoreCategoryAdded = s.get(s.size()-1);
	Assert.assertEquals(ScoreCategoryAdded, ScoreCategory);
	Log.info("Scoring Category added successfully and validated the added value");

}

public void setaddedscoringcategoryvalue() throws InterruptedException {
	ArrayList<String> s = getrecentaddedfrommultiselect(ConfReader.getInstance().getConfData("tblScoreCategoryAddedrecentvalue", "AssessmentBuilderCombineScoringCategory"), new ArrayList<>(), driver);
	Log.info("Scoring Category added successfully and validated the added value");

	//Get all the added scoring categories in combined scoring categories
	for(String a : s) {
		GlobalValues.valuetohold.add(a);
	}
	System.out.println(GlobalValues.valuetohold);
}

public void validatepageTitle() throws InterruptedException {
	Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("pagetilte", "AssessmentBuilderCombineScoringCategory"), driver));
	Log.info("Page title is verified");
}

public void validatecombinepageAttributes() throws InterruptedException {
	Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("groupDesc", "AssessmentBuilderCombineScoringCategory"), driver));
	Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("picklistScoreCategory", "AssessmentBuilderCombineScoringCategory"), driver));
	Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("picklistScoreCategoryAdded", "AssessmentBuilderCombineScoringCategory"), driver));
	Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("scoreRangeValue", "AssessmentBuilderCombineScoringCategory"), driver));
	Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("lowScoreRange", "AssessmentBuilderCombineScoringCategory"), driver));
	Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("highScoreRange", "AssessmentBuilderCombineScoringCategory"), driver));
	
	Log.info("Page attribute labels are verified");
}

public void validateaddbutton() throws InterruptedException {
	
	Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("btnAdd", "assessmentBuilderaddQuestion"), driver));
	Log.info("When GroupCategoryDescription field is entered and Score cateogries are added Add button enabled successfully");
}

public void validateinvalidscorerange(String ScoreLowRange, String ScoreHighRange) throws InterruptedException {
	Log.info("Entering invalid values in ScoreLowRange and ScoreHighRange");
	enterTextbox("Low Score Range", ScoreLowRange, driver);
	Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("lblerrormsgScoreLowRange", "AssessmentBuilderCombineScoringCategory"), driver));
	enterTextbox("High Score Range", ScoreHighRange, driver);
	Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("lblerrormsgScoreHighRange", "AssessmentBuilderCombineScoringCategory"), driver));
	Log.info("Error message displayed successfully");
}

public void validatehighlowscorerange(String ScoreLowRange, String ScoreHighRange) throws InterruptedException {
	Log.info("Entering invalid values in ScoreLowRange and ScoreHighRange");
	enterTextbox("Low Score Range", ScoreLowRange, driver);
	enterTextbox("High Score Range", ScoreHighRange, driver);
	Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("lblerrormsgScoreHighRange", "AssessmentBuilderCombineScoringCategory"), driver));
	Log.info("Error message displayed successfully");
}

public void validateoverlaperror(String ScoreRangeValue,String ScoreLowRange, String ScoreHighRange,UpdateType updatetype) throws InterruptedException {
	enterTextbox("Score Range Value", ScoreRangeValue, driver);
	Log.info("Entering invalid values in ScoreLowRange and ScoreHighRange");
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
	Thread.sleep(2000);
	Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("lblerrormsgoverlap", "AssessmentBuilderAddScoringCategory"), driver));
	Log.info("Error message displayed successfully");
}

}
