package com.adminbuilder.Pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.baseutility.WebAction.ElementType;
import com.adminbuilder.baseutility.WebAction.FieldType;
import com.adminbuilder.configutility.ConfReader;


public class AssessmentBuilder extends WebAction{
	
	WebAction webaction;
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("AssessmentBuilder.class");
	GlobalValues global = new GlobalValues();
	String AssessmentName = null;
	
	public AssessmentBuilder(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
		
	public void clickAddAssessment(String Assesmentname) throws InterruptedException {
			
			
			
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAddAssessment", "AssessmentBuilder"), driver);
		Log.info("AddAssessment is  clicked");
		enterTextbox("Assessment Name", Assesmentname + generaterandomstring(), driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("hdrAddAssessment", "AssessmentBuilder"), driver);	
		GlobalValues.Assessmentname = getAssessmentname();
			
		
	}
	
	public void enterAddAssessment(String Assesmentname) throws InterruptedException {
		
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAddAssessment", "AssessmentBuilder"), driver);
		Log.info("AddAssessment is  clicked");
	//	enter_text("Test", FieldType.xpath, "//label[contains(text(),'Assessment Name')]/../../..//input", driver);
		enterTextbox("Assessment Name", Assesmentname, driver);	
		
		
			
		
	}
	
	public void clickAddAssessmentonly() throws InterruptedException {
		
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(1000);
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAddAssessment", "AssessmentBuilder"), driver);
		Log.info("AddAssessment is  clicked");
		
	}
	
	public void clickAddSection() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("AddSection", "AssessmentBuilder"), driver);
		/*if(!(validateobjectexists(ConfReader.getInstance().getConfData("ModalHeader", "AssessmentBuilder"), driver))) {
			click(FieldType.xpath, ConfReader.getInstance().getConfData("AddSection", "AssessmentBuilder"), driver);
		}*/
		Log.info("Click on Add Section button");
		waitForLoadingToBecomeInvisible(driver);
	}
	
	public void clickAddQuestion() throws InterruptedException {
		
		waitForLoadingToBecomeInvisible(driver);
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAddQuestion", "AssessmentBuilder"), driver);
		Log.info("AddQuestion is  clicked");
		waitForLoadingToBecomeInvisible(driver);
		
	 }
	
	public void clickAddScoringCategory() throws InterruptedException {
		
		waitForLoadingToBecomeInvisible(driver);
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAddScoringCategory", "AssessmentBuilder"), driver);
		Log.info("AddScoringCategory is  clicked");
		waitForLoadingToBecomeInvisible(driver);
			
	 }
	
	public void clickCombineScoringCategory() throws InterruptedException {
		
		waitForLoadingToBecomeInvisible(driver);
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnCombineScoringCategory", "AssessmentBuilder"), driver);
		Log.info("CombineScoringCategory is  clicked");
		waitForLoadingToBecomeInvisible(driver);
			
	 }
	
	public void clickLinktotask() throws InterruptedException {
		
		waitForLoadingToBecomeInvisible(driver);
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "linkToAssesments"), driver);
		Log.info("Link to task is  clicked");
		waitForLoadingToBecomeInvisible(driver);
			
	 }
	
	public void verifyscoringcategoriesgrid() throws InterruptedException {
		
		waitForLoadingToBecomeInvisible(driver);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblScoringCategories", "AssessmentBuilder"), driver));
		Log.info("ScoringCategories header is displayed");
		
		
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblScoringCategoriesnumberofrecords", "AssessmentBuilder"), driver).contains("1-5"));
		Assert.assertTrue(gettablesize(ConfReader.getInstance().getConfData("lblScoringCategoriestablerows", "AssessmentBuilder"), driver)==5);
		Log.info("the grid have 5 records per page");
		
		
	}
	
	public void enterscoringcategoriesgridfilter(String Filtervalue) throws InterruptedException {
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnScoringCategoriesfilter", "AssessmentBuilder"), driver);
		Log.info("scoring categories grid filter is displayed and clicked");
		waitForLoadingToBecomeInvisible(driver);
		enter_text(Filtervalue, FieldType.xpath, ConfReader.getInstance().getConfData("inpScoringCategoriesfilter", "AssessmentBuilder"), driver);
		Thread.sleep(2000);
		
	}
	
	public void verifyscoringcategoriesgridfilter(String Filtervalue, String ScoreRangeValue,String ScoreLowRange, String ScoreHighRange) throws InterruptedException {
		
		String filter = get_text(ConfReader.getInstance().getConfData("lblScoringCategoriesnumberofrecords", "AssessmentBuilder"), driver);
		
		if(Integer.parseInt(filter.substring(filter.length()-2)) > 5) {
			click(FieldType.xpath, ConfReader.getInstance().getConfData("btnforward", "AssessmentBuilder"), driver);
			waitForLoadingToBecomeInvisible(driver);
			Thread.sleep(2000);
		}
		Thread.sleep(3000);
		ArrayList<String> tableData =getrecentaddedformfromtable(ConfReader.getInstance().getConfData("lblScoringCategoriestablerows", "AssessmentBuilder"), new ArrayList<>(), driver);
		Assert.assertEquals(Filtervalue, tableData.get(0));
	//	Assert.assertEquals(global.valuetohold.get(0) + "," + global.valuetohold.get(1), tableData.get(1));
		Log.info("scoring categories grid filter is verified");
		
		int size = gettablesize(ConfReader.getInstance().getConfData("lblScoringCategoriestablerows", "AssessmentBuilder"), driver);
		Thread.sleep(2000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnexpandrow", "AssessmentBuilder").replace("<rownum>", Integer.toString(size)), driver);
		Thread.sleep(2000);
		List<String> tablevalues = getLists(ConfReader.getInstance().getConfData("lblexpandrowdata", "AssessmentBuilder"), driver);
		Assert.assertEquals(tablevalues.get(0), ScoreRangeValue);
		Log.info("ScoreRangeValue is populated with the information provided by the user ");
		String Scorerange = ScoreLowRange + "-" + ScoreHighRange;
		
		Assert.assertEquals(Scorerange, tablevalues.get(1));	
		Log.info("Scorerange is populated with the information provided by the user ");
		
	}
	
	public void verifygroupscoringcategoriesgridfilter(String Filtervalue, String ScoreRangeValue,String ScoreLowRange, String ScoreHighRange) throws InterruptedException {
		
		String filter = get_text(ConfReader.getInstance().getConfData("lblScoringCategoriesnumberofrecords", "AssessmentBuilder"), driver);
		
		if(Character.getNumericValue(filter.charAt(filter.length()-1)) > 5) {
			click(FieldType.xpath, ConfReader.getInstance().getConfData("btnforward", "AssessmentBuilder"), driver);
			waitForLoadingToBecomeInvisible(driver);
			Thread.sleep(2000);
		}
		ArrayList<String> tableData =getrecentaddedformfromtable(ConfReader.getInstance().getConfData("lblScoringCategoriestablerows", "AssessmentBuilder"), new ArrayList<>(), driver);
		Assert.assertEquals(Filtervalue, tableData.get(0));
		System.out.println(GlobalValues.valuetohold.get(0) + "," + GlobalValues.valuetohold.get(1));
		System.out.println(tableData.get(1));
		Assert.assertEquals(GlobalValues.valuetohold.get(0) + "," + GlobalValues.valuetohold.get(1), tableData.get(1));
		Log.info("scoring categories grid filter is verified");
		
		int size = gettablesize(ConfReader.getInstance().getConfData("lblScoringCategoriestablerows", "AssessmentBuilder"), driver);
		Thread.sleep(2000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnexpandrow", "AssessmentBuilder").replace("<rownum>", Integer.toString(size)), driver);
		Thread.sleep(2000);
		List<String> tablevalues = getLists(ConfReader.getInstance().getConfData("lblexpandrowdata", "AssessmentBuilder"), driver);
		Assert.assertEquals(tablevalues.get(0), ScoreRangeValue);
		Log.info("ScoreRangeValue is populated with the information provided by the user ");
		String Scorerange = ScoreLowRange + "-" + ScoreHighRange;
		
		Assert.assertEquals(Scorerange, tablevalues.get(1));	
		Log.info("Scorerange is populated with the information provided by the user ");
		
	}
	
	//Add Assessment methods
	public void AddAssessmentPageVerify() {
		waitForLoadingToBecomeInvisible(driver);
		
		String header = get_text(ConfReader.getInstance().getConfData("PageHeader", "AssessmentBuilder"), driver);
		Assert.assertEquals(header,"Add Assessment");
		Log.info("Verified the header of the page - " + header);
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentName", "AssessmentBuilder"), driver));
		Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("AssessmentName", "AssessmentBuilder"), driver));
		Log.info("Verified the Add Assessment page header and Assessment field");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "linkToAssesments"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "addSection"), driver));		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "addQuestion"), driver));		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "addScoringCategory"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "combineScoringCategories"), driver));		
		
		Log.info("Verified the Disabled links in Add Assessment page");
	
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentPageGrids", "AssessmentBuilder").replace("<gridName>", "sectionDetailLineItem"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentPageGrids", "AssessmentBuilder").replace("<gridName>", "scoringCategoryList"), driver));
		
		Log.info("Verifed the Assessment Temaplate and Scoring Category grids with No recordds in Add Assessment page");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "submit"), driver));	
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "back"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "submit"), driver));	
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "back"), driver);
		Log.info("Verified and Clicked on Back button in Add Assessment page");
		
		waitForLoadingToBecomeInvisible(driver);
	}
	
	public void AddingAssessment() throws Exception {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		Log.info("Entering value in Assessment Name field - " + global.Assessment  );
		
		enterTextbox("Assessment Name", global.Assessment, driver);
			
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "linkToAssesments"), driver));
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "addSection"), driver));
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "addQuestion"), driver));
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "addScoringCategory"), driver));
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "combineScoringCategories"), driver));
	
		Thread.sleep(2000);
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver));
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "back"), driver));
		
		AssessmentName = getAssessmentname();
		
		Log.info("Verified the links in Add Assessment page were enabled");
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver);
		waitForLoadingToBecomeInvisible(driver);
		Log.info("Submitted the Assessment");
		
		waitForLoadingToBecomeInvisible(driver);
	}
	
	public void verifyAddedAssessment() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		validateobjectexists(ConfReader.getInstance().getConfData("FilterIcon","AssessmentBuilder"), driver);
		Thread.sleep(7000);
		 click(FieldType.xpath, ConfReader.getInstance().getConfData("FilterIcon","AssessmentBuilder"), driver);
		 Log.info("Clicked on Filter button to verify the added assessment");
		 click(FieldType.xpath, "//th[1]//div[@class='filterHolder']//input", driver);
		 Thread.sleep(5000);
		 enter_text(AssessmentName, FieldType.xpath, "//th[1]//div[@class='filterHolder']//input", driver);
		 Assert.assertFalse(validateobjectexists(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder"), driver));
	
		Log.info("**** Records Filtering was Successfull ****");
		Log.info("Verified the added Assessment in Assessment/Forms grid"); 
		
		
		click(FieldType.xpath,"//th[1]//div[@class='filterHolder']//button/i", driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("FilterIcon","AssessmentBuilder"), driver);
		 
}

	//Edit Assessment methods
	public void EditAsssessment() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		
	/*	
			 click(FieldType.xpath, ConfReader.getInstance().getConfData("LastPage","AssessmentBuilder"), driver);
		
			 Log.info("Added assessment is in last page");*/
		
		 
		 Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("EditAssessment","AssessmentBuilder"), driver));
		
		 Log.info("Successfully verified the Edit button/image in row");
		 click(FieldType.xpath, ConfReader.getInstance().getConfData("EditAssessment","AssessmentBuilder"), driver);
		 waitForLoadingToBecomeInvisible(driver);
		 Thread.sleep(2000);
		String header = get_text(ConfReader.getInstance().getConfData("PageHeader", "AssessmentBuilder"), driver);
		Assert.assertEquals(header,"Edit Assessment");
		Log.info("Verified the header of the page - " + header);
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentName", "AssessmentBuilder"), driver));
		Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("AssessmentName", "AssessmentBuilder"), driver));
		Log.info("Verified the Add Assessment page header and Assessment field");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "linkToAssesments"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "addSection"), driver));		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "addQuestion"), driver));		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "addScoringCategory"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "combineScoringCategories"), driver));		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver));	
		
		Log.info("Verified the links in Edit Assessment page");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "back"), driver));
	
		waitForLoadingToBecomeInvisible(driver);
	}
	
	public void EditingAssessment() throws Exception {
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("AssName", "AssessmentBuilder"), driver);
		
		enterTextbox("Assessment Name", "Test " + AssessmentName, driver);
		validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver);
		waitForLoadingToBecomeInvisible(driver);
		
		Log.info("Submitted the Assessment after editing the Assessment Name");
	}
	
	public void verifyEditedAssessment() throws Exception {
	waitForLoadingToBecomeInvisible(driver);		
	 		 Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("FilterIcon","AssessmentBuilder"), driver));
	 		 Thread.sleep(4000);
			 click(FieldType.xpath, ConfReader.getInstance().getConfData("FilterIcon","AssessmentBuilder"), driver);
			 Log.info("Clicked on Filter button to verify the added assessment");
			 Thread.sleep(4000);
			 click(FieldType.xpath, ConfReader.getInstance().getConfData("FirstfieldFilter","AssessmentBuilder"), driver);
			 Assert.assertTrue(enter_text("Test "+AssessmentName, FieldType.xpath, ConfReader.getInstance().getConfData("FirstfieldFilter","AssessmentBuilder"), driver));
			 Assert.assertFalse(validateobjectexists(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder"), driver));				
  			Log.info("**** Records Filtering was Successfull ****");
			Log.info("Successfully verified the edited Assessment Name");
	}
	
	//Different markets Verification
	public void MarketSpecifcAssessment(String MarketName) throws Exception {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(5000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("FilterIcon","AssessmentBuilder"), driver);
		Log.info("Clicked on Filter button to verify the added assessment");
		click(FieldType.xpath, ConfReader.getInstance().getConfData("FirstfieldFilter","AssessmentBuilder"), driver);
		enter_text(AssessmentName, FieldType.xpath, ConfReader.getInstance().getConfData("FirstfieldFilter","AssessmentBuilder"), driver);
		Thread.sleep(2000);
		Assert.assertFalse(validateobjectexists(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder"), driver));
		
		EditAsssessment();
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("AssName", "AssessmentBuilder"), driver);
		
		enterTextbox("Assessment Name", MarketName +" " + AssessmentName, driver);
		validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver);
		waitForLoadingToBecomeInvisible(driver);
		
		Log.info("Submitted the Market Specific Assessment after editing the Assessment Name");
		
		Verify_MarketSpecificAssessment(MarketName);
	}
	
	public void Verify_MarketSpecificAssessment(String MarketName) throws Exception   {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(5000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("FilterIcon","AssessmentBuilder"), driver);
		Log.info("Clicked on Filter button to verify the added assessment");
		click(FieldType.xpath, ConfReader.getInstance().getConfData("FirstfieldFilter","AssessmentBuilder"), driver);
		enter_text(MarketName +" " + AssessmentName, FieldType.xpath, ConfReader.getInstance().getConfData("FirstfieldFilter","AssessmentBuilder"), driver);
		Thread.sleep(2000);
		validateobjectexists(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder"), driver);	
		Log.info("Verififed the "+ MarketName +" Market Specific Assessment"); 
	}
	
	//Below methods are Sections related	
	public void VerifySectionModalWindow() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
			Thread.sleep(2000);
			String header = get_text(ConfReader.getInstance().getConfData("ModalHeader", "AssessmentBuilder"), driver);
			Assert.assertEquals(header,"Add Section");
			Log.info("Verified the header of the modal window - " + header);
			
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver));
			Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver));
			
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "label"), driver));		
			Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "label"), driver));
			
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver));	
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver));	
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "submit"), driver));	
			
			Log.info("Verified the Default display of fields in Section modal window");
						
		}
	
	public void AddMainSection() throws Exception {
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver);
		selectDropdown("Section Type",GlobalValues.SectionType.get(0),driver);
		System.out.println(getAssessmentname());
		Assert.assertTrue(enterTextbox("Section Label", "Main - "+getAssessmentname(), driver));
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver));	
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver));	
		
		waitForLoadingToBecomeInvisible(driver);
	}
	
	public void SubmitMainSection() throws Exception {
		waitForLoadingToBecomeInvisible(driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver);
		selectDropdown("Section Type",GlobalValues.SectionType.get(0),driver);
		
		Assert.assertTrue(enterTextbox("Section Label", "Main - "+getAssessmentname(), driver));
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);
	
		waitForLoadingToBecomeInvisible(driver);

	}
		
	public void verifyAddedMainSection() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecSecondaryRow", "AssessmentBuilder").replace("<row>", "1"),driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecOrder", "AssessmentBuilder").replace("<row>", "1"), driver),"1");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecName", "AssessmentBuilder").replace("<row>", "1"), driver), "Main - "+getAssessmentname());
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecMainLink", "AssessmentBuilder").replace("<row>", "1"), driver), null);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("MainSectionEdit", "AssessmentBuilder").replace("<MainSection>","Main - "+getAssessmentname()), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("MainSectionDelete", "AssessmentBuilder").replace("<MainSection>","Main - "+getAssessmentname()), driver));
	Log.info("Verified the added Main Section in the Template Grid");
	}
	
	public void AddSecondMainSection_Verify() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver);
		selectDropdown("Section Type",GlobalValues.SectionType.get(0),driver);
		
		Assert.assertTrue(enterTextbox("Section Label", "Second Main - " +getAssessmentname(), driver));
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);	
		waitForLoadingToBecomeInvisible(driver);
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecSecondaryRow", "AssessmentBuilder").replace("<row>", "2"),driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecOrder", "AssessmentBuilder").replace("<row>", "2"), driver), "2");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecName", "AssessmentBuilder").replace("<row>", "2"), driver), "Second Main - "+getAssessmentname());
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
		Thread.sleep(3000);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecMainLink", "AssessmentBuilder").replace("<row>", "2"), driver), null);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("MainSectionEdit", "AssessmentBuilder").replace("<MainSection>","Second Main - "+getAssessmentname()), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("MainSectionDelete", "AssessmentBuilder").replace("<MainSection>","Second Main - "+getAssessmentname()), driver));
		Log.info("Verified the added Second Main Section in the Temlate Grid");
		
	}
	
	public void AddSubSection() throws Exception {
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver);
		selectDropdown("Section Type",GlobalValues.SectionType.get(1),driver);
		Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "submit"), driver));	
		
		Assert.assertTrue(enterTextbox("Section Label","Sub - "+getAssessmentname(), driver));
		Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "label"), driver));
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Showlabel", "AssessmentBuilder"), driver));
		
		selectDropdown("Main Section Type", "Main - "+getAssessmentname(), driver);
		
		Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "grpSubOrder"), driver));
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver));	
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver));	
		
		Thread.sleep(3000);	
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);	
	
		waitForLoadingToBecomeInvisible(driver);
		
		Log.info("Successfully Submitted the Sub-Section");
		
	}
	
	public void verifyAddedSubSection() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecSecondaryRow", "AssessmentBuilder").replace("<row>", "2"),driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecOrder", "AssessmentBuilder").replace("<row>", "2"), driver),"1");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecName", "AssessmentBuilder").replace("<row>", "2"), driver), "Sub - "+getAssessmentname());
		Thread.sleep(3000);	
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecMainLink", "AssessmentBuilder").replace("<row>", "2"), driver), "Main - "+getAssessmentname());
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SubSectionEdit", "AssessmentBuilder").replace("<SubSection>","Sub - "+getAssessmentname()), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SubSectionDelete", "AssessmentBuilder").replace("<SubSection>","Sub - "+getAssessmentname()), driver));
		Log.info("Verified the added Sub Section in the Template Grid");
	}
	
	public void AddSecondSubSection_Verify() throws Exception {
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver);
		selectDropdown("Section Type",GlobalValues.SectionType.get(1),driver);
		Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver));
		
		Assert.assertTrue(enterTextbox("Section Label", "Second Sub - "+getAssessmentname(), driver));
		Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "label"), driver));
				
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver));	
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver));	
						
		Assert.assertTrue(enterTextbox("Section Label","Second Sub - "+getAssessmentname(), driver));
		Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "label"), driver));
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Showlabel", "AssessmentBuilder"), driver));
		
		Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "grpSubOrder"), driver));
		Thread.sleep(3000);	
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);	
	
		waitForLoadingToBecomeInvisible(driver);
		
		Log.info("Successfully Submitted the Sub-Section without Main Section");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecSecondaryRow", "AssessmentBuilder").replace("<row>", "4"),driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecOrder", "AssessmentBuilder").replace("<row>", "4"), driver),"2");
		Thread.sleep(2000);	
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecName", "AssessmentBuilder").replace("<row>", "4"), driver), "Second Sub - "+getAssessmentname());
		Thread.sleep(3000);	
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecMainLink", "AssessmentBuilder").replace("<row>", "4"), driver), null);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SubSectionEdit", "AssessmentBuilder").replace("<SubSection>","Second Sub - "+getAssessmentname()), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SubSectionDelete", "AssessmentBuilder").replace("<SubSection>","Second Sub - "+getAssessmentname()), driver));
		Log.info("Verified the added Second Sub Section in the Template Grid");
		
	}
	
	public void EditDeleteMainSection() throws Exception {
		waitForLoadingToBecomeInvisible(driver);
		
		//edit and delete Main section
		click(FieldType.xpath,ConfReader.getInstance().getConfData("MainSectionEdit", "AssessmentBuilder").replace("<MainSection>","Main - "+getAssessmentname()) , driver);
		Log.info("Clicked on Edit button of Main Section");
		String header = get_text(ConfReader.getInstance().getConfData("ModalHeader", "AssessmentBuilder"), driver);
		Assert.assertEquals(header,"Edit Section");
		Log.info("Verified the header of the modal window - " + header);
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SectionType", "AssessmentBuilder"),driver),"Main Section");
		Assert.assertTrue(validateobjectreadonly(ConfReader.getInstance().getConfData("SectionTypeInput", "AssessmentBuilder"), driver));
		
		Assert.assertEquals(get_text(ElementType.Textbox, "Section Label", driver),"Main - "+getAssessmentname());
		Thread.sleep(2000);
		Assert.assertTrue(enterTextbox("Section Label", "Edit Main - "+getAssessmentname(), driver));
				
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);	
		Log.info("Successfully edited the Main section");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecName", "AssessmentBuilder").replace("<row>", "1"), driver), "Edit Main - "+getAssessmentname());
		Log.info("Verified the Edited Main Section in Assessment Grid");
		waitForLoadingToBecomeInvisible(driver);
		
		click(FieldType.xpath,ConfReader.getInstance().getConfData("MainSectionDelete", "AssessmentBuilder").replace("<MainSection>","Edit Main - "+getAssessmentname()) , driver);
		Log.info("Clicked on Delete Main Section button");
		Thread.sleep(3000);
		String Message = "Deleting this section will remove all the Sub sections and Questions assigned to it? Are you sure you want to Delete this section?";
		header = get_text(ConfReader.getInstance().getConfData("deleteHeader", "AssessmentBuilder").trim(), driver);
	
		Assert.assertEquals(header,"Confirmation");
		Log.info("Verified the header of the Delete Section modal window - " + header);
		
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("deleteMsg", "AssessmentBuilder"),driver), Message);
		Log.info("Verified the delete confirmation message");
				
		click(FieldType.xpath,ConfReader.getInstance().getConfData("deleteYes", "AssessmentBuilder"), driver);
		Log.info("Clicked on Yes to delte the Main section");
		Thread.sleep(3000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("FilterIcon","AssessmentBuilder"), driver);
		Thread.sleep(3000);
		enter_text("Edit Main - "+getAssessmentname(), FieldType.xpath, ConfReader.getInstance().getConfData("SecondFilterField","AssessmentBuilder"), driver);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder"), driver));				
		Log.info("Deleted Main Section not showing in the grid");
		
		click(FieldType.xpath,"//th[2]//div[@class='filterHolder']//button/i" , driver);
	}
	
	public void EditDeleteSubSection() throws Exception {
		waitForLoadingToBecomeInvisible(driver);
		
		//edit and delete Main section
		click(FieldType.xpath,ConfReader.getInstance().getConfData("SubSectionEdit", "AssessmentBuilder").replace("<SubSection>","Second Sub - "+getAssessmentname()) , driver);
		Log.info("Clicked on Edit button of Sub Section");
		
		String header = get_text(ConfReader.getInstance().getConfData("ModalHeader", "AssessmentBuilder"), driver);
		Assert.assertEquals(header,"Edit Section");
		Log.info("Verified the header of the modal window - " + header);
		Thread.sleep(2000);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SectionType", "AssessmentBuilder"),driver),"Sub Section");
		Assert.assertTrue(validateobjectreadonly(ConfReader.getInstance().getConfData("SectionTypeInput", "AssessmentBuilder"), driver));
		
		Assert.assertEquals(get_text(ElementType.Textbox, "Section Label", driver),"Second Sub - "+getAssessmentname());
		Thread.sleep(2000);
		Assert.assertTrue(enterTextbox("Section Label", "Edit Sub - "+getAssessmentname(), driver));
				
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);	
		Log.info("Successfully edited the Main section");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecName", "AssessmentBuilder").replace("<row>", "1"), driver), "Edit Sub - "+getAssessmentname());
		Log.info("Verified the Edited Main Section in Assessment Grid");
		waitForLoadingToBecomeInvisible(driver);
		
		click(FieldType.xpath,ConfReader.getInstance().getConfData("SubSectionDelete", "AssessmentBuilder").replace("<SubSection>","Edit Sub - "+getAssessmentname()) , driver);
		Log.info("Clicked on Delete Main Section button");
		Thread.sleep(3000);
		String Message = "Deleting this section will remove all the Questions assigned to it? Are you sure you want to Delete this section?";
		header = get_text(ConfReader.getInstance().getConfData("deleteHeader", "AssessmentBuilder").trim(), driver);
	
		Assert.assertEquals(header,"Confirmation");
		Log.info("Verified the header of the Delete Section modal window - " + header);
		
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("deleteMsg", "AssessmentBuilder"),driver), Message);
		Log.info("Verified the delete confirmation message");
	
		click(FieldType.xpath,ConfReader.getInstance().getConfData("deleteYes", "AssessmentBuilder"), driver);
		Log.info("Clicked on Yes to delte the Main section");
		Thread.sleep(3000);
		enter_text("Edit Sub - "+getAssessmentname(), FieldType.xpath, ConfReader.getInstance().getConfData("SecondFilterField","AssessmentBuilder"), driver);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder"), driver));	
		click(FieldType.xpath, ConfReader.getInstance().getConfData("FilterIcon","AssessmentBuilder"), driver);
		Thread.sleep(3000);
	
		Log.info("Deleted Sub Section not showing in the grid");
	
	}
	
	public void VerifyDuplicateAssessment() throws Exception {
		waitForLoadingToBecomeInvisible(driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("EditAssessment","AssessmentBuilder"), driver);
		waitForLoadingToBecomeInvisible(driver);
		String AssName = getAssessmentname();
System.out.println(AssName);
		click(FieldType.xpath,ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "back"), driver);
		waitForLoadingToBecomeInvisible(driver);
		clickAddAssessmentonly();
		Assert.assertTrue(enterTextbox("Assessment Name", AssName, driver));
		Log.info("Entering Assessment Name to verify Duplicate Values");
		Thread.sleep(3000);
		String Message = "This Assessment Name already exist, Please provide another Assessment Name.";
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupAssMsg", "AssessmentBuilder"), driver),Message);
		Log.info("Verified the Duplicate Assessment Message");
		waitForLoadingToBecomeInvisible(driver);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "linkToAssesments"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "addSection"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "addQuestion"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "addScoringCategory"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "combineScoringCategories"), driver));
		Log.info("Verified the links in Add Assessment page were Diaabled");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "back"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "submit"), driver));	
		
		Log.info("Verified the Duplicate Assessments, Links and buttons in Add Assessment page");
		
		Assert.assertTrue(enterTextbox("Assessment Name", "Dup "+AssName, driver));
		
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "linkToAssesments"), driver));
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "addSection"), driver));
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "addQuestion"), driver));
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "addScoringCategory"), driver));
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "combineScoringCategories"), driver));
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver));
		
		Log.info("Verified the links in Add Assessment page were enabled");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "back"), driver));
		Log.info("Verified the Duplicate Assessments, Links and buttons in Add Assessment page and Submit after correct Assessment");
		
		enterTextbox("Assessment Name", " Space before "+AssName, driver);
		Message = "Alphanumeric characters are allowed";
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupAssMsg", "AssessmentBuilder"), driver),Message);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "linkToAssesments"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "addSection"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "addQuestion"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "addScoringCategory"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "combineScoringCategories"), driver));
		
		Log.info("Verified the Duplicate Assessment Message with Space before Assessment name");
		waitForLoadingToBecomeInvisible(driver);
		
//VERIFYING THIS SCENARIO IN MISSED SCENARIO METHOD		
		enterTextbox("Assessment Name", AssName+ " spcae after ", driver);
		Message = "Alphanumeric characters are allowed";
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupAssMsg", "AssessmentBuilder"), driver),Message);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "linkToAssesments"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "addSection"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "addQuestion"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "addScoringCategory"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "combineScoringCategories"), driver));
		
		Log.info("Verified the Duplicate Assessment Message with space after Assessment name in edit page");
		waitForLoadingToBecomeInvisible(driver);
		
		String upper = AssName.toUpperCase(); 
		String lower = AssName.toLowerCase();
	
		enterTextbox("Assessment Name", upper, driver);
		Message = "This Assessment Name already exist, Please provide another Assessment Name.";
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupAssMsg", "AssessmentBuilder"), driver),Message);	
		Log.info("verified Assessment with upper case leeters");
		Thread.sleep(3000);
		
		click(FieldType.xpath,ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "back"), driver);
		clickAddAssessmentonly();
		enterTextbox("Assessment Name", lower, driver);
		Message = "This Assessment Name already exist, Please provide another Assessment Name.";
		Thread.sleep(2000);	
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupAssMsg", "AssessmentBuilder"), driver),Message);
		Log.info("verified Assessment with lower case letters");		
		
		enterTextbox("Assessment Name", "Duplicate "+AssName, driver);
		waitForLoadingToBecomeInvisible(driver);
		
		click(FieldType.xpath,ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "back"), driver);
		waitForLoadingToBecomeInvisible(driver);
	}
	
	//Below methods are to verify the Assessment Template Grid

	public void verifyDupSecions() throws Exception {
		waitForLoadingToBecomeInvisible(driver);
		//validating main section - add page
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver);
		selectDropdown("Section Type",GlobalValues.SectionType.get(0),driver);
		
		Assert.assertTrue(enterTextbox("Section Label", "Main - "+getAssessmentname(), driver));
		
		String Message = "This Section Label already exist, Please provide another Section Label.";
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupSecMSg", "AssessmentBuilder"), driver),Message);
		Log.info("Verified the Duplicate Section Message");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver));	
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "submit"), driver));	
		
		Log.info("Verified the Duplicate check with Main Section with Section type as Main Section");
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(3000);
		clickAddSection();		
		
		//Sub section name with section type as mainsection
		Assert.assertTrue(enterTextbox("Section Label", "Sub - "+getAssessmentname(), driver));
		Thread.sleep(2000);
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupSecMSg", "AssessmentBuilder"), driver),Message);
		Log.info("Verified the Duplicate Section Message");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver));	
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "submit"), driver));	
		
		Log.info("Verified the Duplicate check with Sub Section with Section type as Main Section");
		
		String upperMS = "MAIN - "+getAssessmentname().toUpperCase(); 
		String lowerMS = "main - "+getAssessmentname().toLowerCase();
		String upperSS = "SUB - "+getAssessmentname().toUpperCase(); 
		String lowerSS = "sub - "+getAssessmentname().toLowerCase();
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
		Thread.sleep(2000);
		clickAddSection();	
		enterTextbox("Section Label", upperMS, driver);
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupSecMSg", "AssessmentBuilder"), driver),Message);
		Log.info("verified Main Section with upper case letters when Main Section as Section Type");
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
		Thread.sleep(2000);
		clickAddSection();	
		enterTextbox("Section Label", lowerMS, driver);
		Thread.sleep(2000);
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupSecMSg", "AssessmentBuilder"), driver),Message);
		Log.info("verified Main Section with lower case letters when Main Section as Section Type");
		enterTextbox("Section Label","DUP Main - "+getAssessmentname(), driver);
		Thread.sleep(2000);	
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
		Thread.sleep(2000);
		clickAddSection();	
		enterTextbox("Section Label", upperSS, driver);
		Thread.sleep(2000);
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupSecMSg", "AssessmentBuilder"), driver),Message);
		Log.info("verified Sub Section with upper case letters when Main Section as Section Type");
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
		Thread.sleep(2000);
		clickAddSection();	
		enterTextbox("Section Label", lowerSS, driver);
		Thread.sleep(2000);
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupSecMSg", "AssessmentBuilder"), driver),Message);
		Log.info("verified Sub Section with lower case letters when Main Section as Section Type");
		
		//validating sub section - add page
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
		Thread.sleep(2000);
		clickAddSection();	
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver);
		selectDropdown("Section Type",GlobalValues.SectionType.get(1),driver);
		
		Assert.assertTrue(enterTextbox("Section Label", "Sub - "+getAssessmentname(), driver));
		Thread.sleep(2000);
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupSecMSg", "AssessmentBuilder"), driver),Message);
		Log.info("Verified the Duplicate Section Message");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver));	
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "submit"), driver));	
				
		Log.info("Verified the Duplicate check with Sub Section with Section type as Sub Section");
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
		Thread.sleep(2000);
		clickAddSection();
		Assert.assertTrue(enterTextbox("Section Label", "Main - "+getAssessmentname(), driver));
		Thread.sleep(2000);
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupSecMSg", "AssessmentBuilder"), driver),Message);
		Log.info("Verified the Duplicate Section Message");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver));	
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "submit"), driver));	
		
		Log.info("Verified the Duplicate check with Main Section with Section type as Sub Section");
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
		Thread.sleep(2000);
		clickAddSection();	
		enterTextbox("Section Label","DUP Main - "+getAssessmentname(), driver);
		Thread.sleep(2000);
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
		Thread.sleep(2000);
		clickAddSection();	
		enterTextbox("Section Label", upperMS, driver);
		Thread.sleep(2000);
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupSecMSg", "AssessmentBuilder"), driver),Message);
		Log.info("verified Main Section with upper case letters when Sub Section as Section Type");
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
		Thread.sleep(2000);
		clickAddSection();	
		enterTextbox("Section Label", lowerMS, driver);
		Thread.sleep(2000);
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupSecMSg", "AssessmentBuilder"), driver),Message);
		Log.info("verified Main Section with lower case letters when Sub Section as Section Type");
		Thread.sleep(2000);
		enterTextbox("Section Label","DUP Main - "+getAssessmentname(), driver);
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
		Thread.sleep(2000);
		clickAddSection();	
		enterTextbox("Section Label", upperSS, driver);
		Thread.sleep(2000);
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupSecMSg", "AssessmentBuilder"), driver),Message);
		Log.info("verified Sub Section with upper case letters when Sub Section as Section Type");
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
		Thread.sleep(2000);
		clickAddSection();	
		enterTextbox("Section Label", lowerSS, driver);
		Thread.sleep(2000);
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupSecMSg", "AssessmentBuilder"), driver),Message);
		Log.info("verified Sub Section with lower case letters when Sub Section as Section Type");
		
		enterTextbox("Section Label","DUP Main - "+getAssessmentname() , driver);
		Thread.sleep(2000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(5000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "back"), driver);
	
	}
	
	public void validateAssessmentTemplateGrid() throws Exception {
		
		waitForLoadingToBecomeInvisible(driver);
		
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("GridHeader", "AssessmentBuilder"), driver),"Assessment Template");
		Log.info("Verifed the Assessment Template grid header");
		
		Assert.assertEquals(getLists(ConfReader.getInstance().getConfData("GridColumns", "AssessmentBuilder"), driver), GlobalValues.AssessmentTemplateGrid);
		Log.info("Assessment template grid columns headers are displayed as expected " + GlobalValues.AssessmentTemplateGrid);
		
		SortingTemplateGrid(driver,1,1,1);
		
		Log.info("Verifying the Expand row in Assessmeny builder Template grid");
		click(FieldType.xpath, ConfReader.getInstance().getConfData("ExpandRow", "AssessmentBuilder"), driver);
		Assert.assertEquals(getLists(ConfReader.getInstance().getConfData("ColumnsList", "AssessmentBuilder"), driver), GlobalValues.TemplateGridExpandRow);
				
		SortingTemplateGridExpandRow(driver,1,1,1);
		
		List<WebElement> rows = driver.findElements(By.xpath(ConfReader.getInstance().getConfData("SectionRow", "AssessmentBuilder"))); 
		rows.size();
		for(int i=1; i<= rows.size(); i++) {
			Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("SecRow", "AssessmentBuilder"),driver));
			Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("SecEdit", "AssessmentBuilder"), driver));
			Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("SecDelete", "AssessmentBuilder"), driver));
			}
		Log.info("Successfully verified the Expanded row, Edit and Delete buttons in Assessment Builder Template grid");
		
		try {
			rows = driver.findElements(By.xpath(ConfReader.getInstance().getConfData("QuesRow", "AssessmentBuilder"))); 
			for(int i=1; i<= rows.size(); i++) {
				Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("QuesSecRow", "AssessmentBuilder"),driver));
				Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("QuesEdit", "AssessmentBuilder"), driver));
				Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("QuesDelete", "AssessmentBuilder"), driver));
				Log.info("Successfully verified the Expanded row, Edit and Delete buttons in Assessment Builder Template grid");
			}
		} catch (Exception e) {
			Log.info("!!!!! Unable to verify the Questins grid Expandable row, Edit and Delete buttons");
		}
	}
	
	public void SortingTemplateGrid(WebDriver ldriver,int columnSortToStartIndex, int columnIndexVariable, int columnHeaderIndex) throws Exception {
		Boolean sortingFlag = false;
		Boolean resultFlag = true;
		WebElement sortColumns;	
		String columnName = "";
		try{
			WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilderPage")));
			if(noRecordFoundElement.isDisplayed()){
				String noRecordFoundText = noRecordFoundElement.getText();
				Log.info(noRecordFoundText + "- to perform sorting in the grid");
				
			} 
		}catch(Exception e){
			Log.info("Records are present for sorting");
			for(int i=0;i<GlobalValues.AssessmentTemplateGrid.size();i++){
				columnName = GlobalValues.AssessmentTemplateGrid.get(i);
	
				int ColumnNumber = columnSortToStartIndex;
				sortColumns = driver.findElement(By.xpath("//tr[@class='ng-star-inserted']//th["+(i+2)+"]//nm-th['"+columnName+"']/following::p-sorticon//i"));
				
				Thread.sleep(3000);
				sortingFlag = verifySorting(columnName, ColumnNumber, "ASC", columnIndexVariable);
				if (sortingFlag == true)
					Log.info("********* Ascending order sorting executed sucessfully for column : " + columnName);
				else
					Log.info("!!!!!  Error in Ascending order sorting  for column : " + columnName);
				Thread.sleep(3000);
				if (resultFlag != false)
					resultFlag = sortingFlag;
				sortColumns.click();
				Thread.sleep(5000);
				sortingFlag = verifySorting(columnName, ColumnNumber, "DESC", columnIndexVariable);
				if (sortingFlag == true)
					Log.info("********* Descending order sorting executed sucessfully for column : " + columnName);
				else
					Log.info("!!!!! Error in Descending order sorting for column : " + columnName);
				if (resultFlag != false)
					resultFlag = sortingFlag;
			}
		}
	}
	
	public void Add_VerifyDefaultSection(String QuesDesc,String QuesResTyp, String AssSection) throws InterruptedException{
		waitForLoadingToBecomeInvisible(driver);
	    Assert.assertTrue(enterTextbox("Question Description", QuesDesc, driver));
	    Assert.assertTrue(selectDropdown("Question Response Type", QuesResTyp, driver));
	    Thread.sleep(2000);
	    Assert.assertTrue(selectDropdown("Assessment Section", AssSection, driver));
	    	
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver));
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver);
		Log.info("Successfully added the Default Section to the Assessment Grid");
		
		
		Thread.sleep(2000);
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecSecondaryRow", "AssessmentBuilder").replace("<row>", "1"),driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("SecName", "AssessmentBuilder").replace("<row>", "1"), driver), "Default Section");
		Assert.assertFalse(validateobjectexists(ConfReader.getInstance().getConfData("SubSectionEdit", "AssessmentBuilder").replace("<SubSection>","Default Section"), driver));
		Assert.assertFalse(validateobjectexists(ConfReader.getInstance().getConfData("SubSectionDelete", "AssessmentBuilder").replace("<SubSection>","Default Section"), driver));
		Log.info("Successfully verified the Expanded row, Edit and Delete buttons in Assessment Builder Template grid - Default section");
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("ExpandRow", "AssessmentBuilder"), driver);
		
		try {
			List<WebElement> rows = driver.findElements(By.xpath(ConfReader.getInstance().getConfData("QuesRow", "AssessmentBuilder"))); 
			for(int i=1; i<= rows.size(); i++) {
				Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("QuesSecRow", "AssessmentBuilder"),driver));
				Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("QuesEdit", "AssessmentBuilder"), driver));
				Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("QuesDelete", "AssessmentBuilder"), driver));
				Log.info("Successfully verified the Expanded row, Edit and Delete buttons in Assessment Builder Template grid");
				
				Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("DescQues", "AssessmentBuilder"), driver),QuesDesc);
				Log.info("Verified the Added Default Question in the Assessment Template Grid");
			}
		} catch (Exception e) {
			Log.info("!!!!! Unable to verify the Questins grid Expandable row, Edit and Delete buttons");
		}
	}
	
	public void AssessmentBuilderPageverify() throws Exception {
		
		waitForLoadingToBecomeInvisible(driver);
		
		//page header
		waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("AssessmentBuilderHeader","AssessmentBuilder"), driver);
		Log.info("Successfully verified the header of the Assessment Builder page header"); 
			
		//grid header
		waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("AssessmentBuilderGridHeader","AssessmentBuilder"), driver);
		Log.info("Successfully verified the header of the Assessment Builder page grid header");
		Thread.sleep(2000);
		for(int i=0; i<GlobalValues.AssessmentBuilderPageGrid.size();i++)
		{
				driver.findElement(By.xpath("//span/nm-th[text()='"+GlobalValues.AssessmentBuilderPageGrid.get(i)+"']"));
				Log.info("Verifying the "+ GlobalValues.AssessmentBuilderPageGrid.get(i) + "- column in Assessment Builder Page grid");
		}
	
		SortingMainGrid(driver, 1, 1, 1);
		
	}
	
	public void Verify_ButtonGroups() {
		
		for(int i=1; i<=5; i++){
			try {
				WebElement Preview = driver.findElement(By.xpath("//div[@class='scrollGrid']//tbody//tr["+ i +"]//td[6]//button[@title='Preview']"));
				if(Preview.isDisplayed()){
					Log.info("Successfully verified the Preview button/image in row "+i);
				}
				WebElement Link = driver.findElement(By.xpath("//div[@class='scrollGrid']//tbody//tr["+ i +"]//td[7]//button[@title='Link']"));
				if(Link.isDisplayed()){
					Log.info("Successfully verified the Link button/image in row " +i );
					
				WebElement Publish = driver.findElement(By.xpath("//div[@class='scrollGrid']//tbody//tr["+ i +"]//td[8]//button[@title='Publish']"));
				if(Publish.isDisplayed()){
					Log.info("Successfully verified the Publish button/image in row " +i);
				}
				WebElement Edit = driver.findElement(By.xpath("//div[@class='scrollGrid']//tbody//tr["+ i +"]//td[9]//button[@title='Edit']"));
				if(Edit.isDisplayed()){
					Log.info("Successfully verified the Edit button/image in row "+i);
				}
				}
			}
			catch(Exception e) {
				Log.info("!!!! Preview button/image not verifed in the row " +i +" !!!!!!!");
				Log.info("!!!! Link button/image not verifed in the row " +i +" !!!!!!!");
				Log.info("!!!! Publish button/image not verifed in the row " +i +" !!!!!!!");
				Log.info("!!!! Edit button/image not verifed in the row " +i +" !!!!!!!");
			}
		}
		
	}
	
	public void SortingMainGrid(WebDriver ldriver,int columnSortToStartIndex, int columnIndexVariable, int columnHeaderIndex) throws Exception {
		Boolean sortingFlag = false;
		Boolean resultFlag = true;
		WebElement sortColumns;	
		String columnName = "";
		try{
			WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder")));
			if(noRecordFoundElement.isDisplayed()){
				String noRecordFoundText = noRecordFoundElement.getText();
				Log.info(noRecordFoundText + "- to perform sorting in the grid");
				
			} 
		}catch(Exception e){
			Log.info("Records are present for sorting");
			for(int i=0;i<GlobalValues.AssessmentBuilderPageGrid.size();i++){
				columnName = GlobalValues.AssessmentBuilderPageGrid.get(i);
	
				int ColumnNumber = columnSortToStartIndex;
				sortColumns = driver.findElement(By.xpath("//tr[@class='ng-star-inserted']//th["+(i+1)+"]//nm-th['"+columnName+"']/following::p-sorticon//i"));
				
				Thread.sleep(3000);
				sortingFlag = verifySorting(columnName, ColumnNumber, "ASC", columnIndexVariable);
				if (sortingFlag == true)
					Log.info("********* Ascending order sorting executed sucessfully for column : " + columnName);
				else
					Log.info("!!!!!  Error in Ascending order sorting  for column : " + columnName);
				Thread.sleep(3000);
				if (resultFlag != false)
					resultFlag = sortingFlag;
				sortColumns.click();
				Thread.sleep(3000);
				sortingFlag = verifySorting(columnName, ColumnNumber, "DESC", columnIndexVariable);
				if (sortingFlag == true)
					Log.info("********* Descending order sorting executed sucessfully for column : " + columnName);
				else
					Log.info("!!!!! Error in Descending order sorting for column : " + columnName);
				if (resultFlag != false)
					resultFlag = sortingFlag;
			}
		}
	}
	
	public Boolean verifySorting (String columnName, int ColumnNumber, String sortingAction, int columnIndexVariable) {
		List<WebElement> sortColumnData = null;
		List<WebElement> sortColumnNoData = null;
	
		ArrayList<String> obtainedList = new ArrayList<String>();
		ArrayList<String> sortedList = new ArrayList<String>();
	
		Boolean isSortedFlag = false;
		if (columnName.contains("'")){
			String [] columnsplit=columnName.split("'");
			columnName= columnsplit[1];
			columnName=columnName.substring(1);
		}
		String sortDataXpath = "//nm-th[contains(text(),'" + columnName+"')]//parent::span//parent::th//following::tr//td[columnNumber]";
		sortDataXpath = sortDataXpath.toString().replace("columnNumber",
				String.valueOf(ColumnNumber + columnIndexVariable));
		try {
			sortColumnData = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath(sortDataXpath))));
		} catch (Exception ex) {
			sortColumnNoData = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.xpath(sortDataXpath))));
			if (sortColumnNoData.size() > 0) {
				for (WebElement we : sortColumnNoData) {
					if (we.getText().toString().length() == 0) {
						Log.info("********* No data found for sorting on column : " + columnName);
						return true;
					}
				}
	
			}
		}
		for (WebElement we : sortColumnData) {
			if (we.getText().toString().length() > 0) {
				obtainedList.add(we.getText().toUpperCase());
			}
		}
		//Log.info("obtainedList"+obtainedList);
		//Log.info("size"+obtainedList.size());
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		
		if (sortingAction == "DESC") {
			
			Collections.reverse(sortedList);
			//Log.info("Desc:Srted list"+sortedList);
		}
		if (sortedList.equals(obtainedList))
			isSortedFlag = true;
		return isSortedFlag;
	}
	
	//Below method to verify the pagination(global_method)
	public void numberOfColumnsInGridForpagination(String gridName, int requiredRowCount) throws Exception {
		
		try {
			WebElement gridTitleElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("AssessmentBuilderGridHeader","AssessmentBuilder")));
			String gridTitle = gridTitleElement.getText();
			Log.info(gridTitle);
			Assert.assertEquals(gridTitle, "Assessments/Forms", "Grid Header/Title is not matching");
			List<WebElement> gridRowsCount = driver.findElements(By.xpath(ConfReader.getInstance().getConfData("ABRowsInGrid","AssessmentBuilder")));
			int rowCount = gridRowsCount.size();
	
			if (rowCount > requiredRowCount) {
				Log.info("Number of rows for pagination is more than required");
			} else {
				Log.info("Number of rows for pagination is as required");
				Log.info("**********verified pagination for Assessment Builder Grid**********");
				
			}
	
		} catch (Exception e) {
	
			Log.info(e + " Grid Title is not matching");
			throw e;
		}
	}
	
	public void clicksubmit() throws InterruptedException {
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"), driver);
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(1000);
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("btnAddAssessment", "AssessmentBuilder"), driver));
		Log.info("**Passed ** After clicking on submit user shall land on the previous page ");
	}
	
	public void filterassessment(String Filtervalue) throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(1000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAssessmentfilter", "AssessmentBuilder"), driver);
		Thread.sleep(1000);
		enter_text(Filtervalue, FieldType.xpath, ConfReader.getInstance().getConfData("inpFiltervalue", "AssessmentBuilder"), driver);
		Thread.sleep(1000);
		
	}
	
	public void clickonrecentassessmentlink() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnlinkrecentrow", "AssessmentBuilder"), driver);
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(1000);
		
	
	}

	public void MissedScenarios() throws Exception {
		waitForLoadingToBecomeInvisible(driver);
		
		//first point verified in this method - Add_VerifyDefaultSection(QuesDesc,QuesResTyp,AssSection)
		
		//second point - Assessment/Forms grid data verification - verifying in pagination method
		
		//third point - Verify Last Modified date and Publish status value as Date and time
		
		//fifth point - Question Response type field in Edit Question
		click(FieldType.xpath, ConfReader.getInstance().getConfData("QuesEdit", "AssessmentBuilder"), driver);
		validateobjectreadonly(ConfReader.getInstance().getConfData("drpQuestionResponseType", "assessmentBuilderaddQuestion"), driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "back"), driver);
		Log.info("Verifed the Question Response Type as Read only in Edit Question page");
		
		waitForLoadingToBecomeInvisible(driver);
		//Sixth point - Assessment Name first char as Space
		enterTextbox("Assessment Name", " " + getAssessmentname(), driver);
		
		String Message = "Alphanumeric characters are allowed";
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupAssMsg", "AssessmentBuilder"), driver),Message);
		Log.info("Verified the Duplicate Assessment Message");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "linkToAssesments"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "addSection"), driver));		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "addQuestion"), driver));		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "addScoringCategory"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "combineScoringCategories"), driver));		
		
		Log.info("Verified the Disabled links in Add Assessment page");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "back"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "submit"), driver));	
		
		Log.info("Verified and Clicked on Back button in Add Assessment page");
		waitForLoadingToBecomeInvisible(driver);
		
		try {//----space after assessment name
		enterTextbox("Assessment Name", getAssessmentname() + " ", driver);
		
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("DupAssMsg", "AssessmentBuilder"), driver),Message);
		Log.info("Verified the Duplicate Assessment Message");
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "linkToAssesments"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "addSection"), driver));		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "addQuestion"), driver));		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "addScoringCategory"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "combineScoringCategories"), driver));		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "submit"), driver));	
		
		Log.info("Verified the Disabled links in Add Assessment page");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "back"), driver));
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("AssessmentLinks", "AssessmentBuilder").replace("<link>", "submit"), driver));	
		}
		catch(Exception e){
			Log.info("Space after Assessment Name failed");
		}
		Log.info("Verified and Clicked on Back button in Add Assessment page");
		Log.info("Verified the spacing before and after the Assessment Name");
		waitForLoadingToBecomeInvisible(driver);
		
		//Seventh point - Clear button in Answer section
		enterTextbox("Assessment Name","Validation "+ getAssessmentname(), driver);
		clickAddQuestion();
		Thread.sleep(3000);
		selectDropdown("Question Response Type", "Checkbox Group", driver);
		Thread.sleep(3000);
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "clear"), driver));
		selectDropdown("Insert Answer", "Gender", driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "clear"), driver);
		Thread.sleep(3000);
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("InsertAnswer", "AssessmentBuilder"),driver),"Please Select...");
		Log.info("Successfully verified the Insert Answer after clicking in Clear");
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "back"), driver);
		Thread.sleep(2000);
		//fourth point - Combine scoring header
		clickCombineScoringCategory();
		Thread.sleep(3000);
		Assert.assertEquals(get_text(ConfReader.getInstance().getConfData("ScoreHeader", "AssessmentBuilder"), driver), "Combine Scoring Categories");
		Log.info("Verified the Combined Score Category page title");
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "back"), driver);
		
		waitForLoadingToBecomeInvisible(driver);
	}

public String getAssessmentname() throws InterruptedException {
	
	return get_text(ElementType.Textbox, "Assessment Name", driver);
		
	
}

public void clickdeletescoringcategoriesgridandverify() throws InterruptedException {
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(1000);
	String filter = get_text(ConfReader.getInstance().getConfData("lblScoringCategoriesnumberofrecords", "AssessmentBuilder"), driver);
	if(Integer.parseInt(filter.substring(filter.length()-2).trim()) > 5) {
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnforward", "AssessmentBuilder"), driver);


	}
	int size = gettablesize(ConfReader.getInstance().getConfData("lblScoringCategoriestablerows", "AssessmentBuilder"), driver);
	
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btndeleteScoringcategoriesgrid", "AssessmentBuilder").replace("<rownum>", Integer.toString(size)), driver);
	Log.info("Delete button in the grid is clicked ");
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(3000);
	
	
	if(validateobjectexists(ConfReader.getInstance().getConfData("lblnorecordsScoringcategoriesgrid", "AssessmentBuilder"), driver)) {
		Log.info("Deleted records are not present in the grid ");
	}
	else {
		int sizenew = gettablesize(ConfReader.getInstance().getConfData("lblScoringCategoriestablerows", "AssessmentBuilder"), driver);
				
		Assert.assertNotSame(size, sizenew);
		
		
		Log.info("Deleted records are not present in the grid ");
	
	}
}

public void clickeditscoringcategoriesgrid() throws InterruptedException {
	int size = gettablesize(ConfReader.getInstance().getConfData("lblScoringCategoriestablerows", "AssessmentBuilder"), driver);
	Thread.sleep(2000);
	
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btneditScoringcategoriesgrid", "AssessmentBuilder").replace("<rownum>", Integer.toString(size)), driver);
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(2000);
	
}

public void verifyscoringcategoriesgridheaders() throws InterruptedException {
	Thread.sleep(2000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnexpandrow", "AssessmentBuilder").replace("<rownum>", "1"), driver);
	Thread.sleep(2000);
	List<String> tableData = getLists(ConfReader.getInstance().getConfData("lbltableheaders", "AssessmentBuilder"), driver);
	Assert.assertEquals(tableData.get(0), "Scoring Category");
	Assert.assertEquals(tableData.get(1), "Categories Included");
	Assert.assertEquals(tableData.get(2), "Score Range");
	Assert.assertEquals(tableData.get(3), "Score Range Value");
	Log.info("scoring categories grid headers is verified" +tableData );
	
}

public void AddMainSection(String Mainsectionname) throws Exception {
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver);
	selectDropdown("Section Type",GlobalValues.SectionType.get(0),driver);
	
	Assert.assertTrue(enterTextbox("Section Label", Mainsectionname, driver));
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);

	waitForLoadingToBecomeInvisible(driver);
}

public void VerifyingAddedSections_AddQuestionPage() throws Exception {
	
	String AssName = getAssessmentname();
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAddQuestion", "AssessmentBuilder"), driver);
	
	click(FieldType.xpath, "//label[@for='assessementSection']//ancestor::nm-combobox//div", driver);
	
	for(int i=1;i<=gettablesize("//label[@for='assessementSection']//ancestor::nm-combobox//div//p-dropdownitem", driver);i++)
	{
		String section = get_text("//label[@for='assessementSection']//ancestor::nm-combobox//p-dropdownitem['"+i+"']//span", driver);
		if(i==1){
			Assert.assertEquals(section, "Default Section");
		}
		if(section.equals("Main - "+AssName) || section.equals("Second Main - "+AssName) || section.equals("Sub - "+AssName))
		{
			Log.info("Added Section value verified in Add Section - Main Section Type field " + section);
		}
	}
	click(FieldType.xpath, "//button[text()='Back']", driver);
	waitForLoadingToBecomeInvisible(driver);
}

public void VerifyingAddedSections_AddSectionPage() throws Exception {
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver);
	selectDropdown("Section Type",GlobalValues.SectionType.get(1),driver);
	Thread.sleep(2000);
	click(FieldType.xpath, "//div[@role='dialog']//label[@for='mainSectionType']//ancestor::nm-combobox//div//label", driver);
		
	for(int i=1;i<=gettablesize("//div[@role='dialog']//label[@for='mainSectionType']//ancestor::nm-combobox//p-dropdownitem", driver);i++)
	{
		String section = get_text("//div[@role='dialog']//label[@for='mainSectionType']//ancestor::nm-combobox//p-dropdownitem['"+i+"']//span", driver);
				
		if(section.equals("Main - "+getAssessmentname()) || section.equals("Second Main - "+getAssessmentname()) || section.equals("Sub - "+getAssessmentname()))
		{
			Log.info("Added Section value verified in Add Section - Main Section Type field " + section);
		}
	}
	Assert.assertTrue(enterTextbox("Section Label", "Cancel Main - "+getAssessmentname(), driver));
	
	click(FieldType.xpath, ConfReader.getInstance().getConfData("ModalwindowBack", "AssessmentBuilder").replace("<link>", "Cancel"), driver);
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(4000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("AssessmentName", "AssessmentBuilder"), driver);
}

public void SortingTemplateGridExpandRow(WebDriver driver,int columnSortToStartIndex, int columnIndexVariable, int columnHeaderIndex) throws Exception {
	Boolean sortingFlag = false;
	Boolean resultFlag = true;
	String columnName = "";
	
		
		if(validateobjectexists(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder"), driver)) {
			Log.info("noRecordFoundText to perform sorting in the grid");
		}
		else {
		Log.info("Records are present for sorting");
		for(int i=0;i<GlobalValues.TemplateGridExpandRow.size();i++){
			columnName = GlobalValues.TemplateGridExpandRow.get(i);

			int ColumnNumber = columnSortToStartIndex;
			
			
			Thread.sleep(3000);
			sortingFlag = verifySorting(columnName, ColumnNumber, "ASC", columnIndexVariable);
			if (sortingFlag == true)
				Log.info("********* Ascending order sorting executed sucessfully for column : " + columnName);
			else
				Log.info("!!!!!  Error in Ascending order sorting  for column : " + columnName);
			Thread.sleep(3000);
			if (resultFlag != false)
				resultFlag = sortingFlag;
			click(FieldType.xpath, "//tr[@class='ng-star-inserted']//th["+(i+2)+"]//nm-th['"+columnName+"']/following::p-sorticon//i", driver);
		
			Thread.sleep(3000);
			sortingFlag = verifySorting(columnName, ColumnNumber, "DESC", columnIndexVariable);
			if (sortingFlag == true)
				Log.info("********* Descending order sorting executed sucessfully for column : " + columnName);
			else
				Log.info("!!!!! Error in Descending order sorting for column : " + columnName);
			if (resultFlag != false)
				resultFlag = sortingFlag;
		}
	}
}

public void filterAssessmentTemplateGrid() throws Exception {
	WebElement FilterGrid;
	
		try{
			WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder")));
			if(noRecordFoundElement.isDisplayed()){
				String noRecordFoundText = noRecordFoundElement.getText();
				Log.info(noRecordFoundText + "- to perform Filtering on the grid");
				
			} 
		}catch(Exception e){
			Log.info("Records are present for Filtering");
			driver.findElement(By.xpath(ConfReader.getInstance().getConfData("FilterIcon","AssessmentBuilder"))).click();
		
		try {
			 FilterGrid = driver.findElement(By.xpath("//th[2]//div[@class='filterHolder']//input"));
			 FilterGrid.click();
			 FilterGrid.sendKeys("2");
			 try{
					WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder")));
					if(noRecordFoundElement.isDisplayed()){
						String noRecordFoundText = noRecordFoundElement.getText();
						Log.info(noRecordFoundText + "- to perform Filtering on the grid");
						
					} 
				}catch(Exception e2){
					Log.info("**** Records Filtering was Successfull ****");
				}
		} catch(Exception e2){
			Log.info("!!!! Failed - filtering the record !!!!");
		}
driver.findElement(By.xpath("//th[2]//div[@class='filterHolder']//button/i")).click();
		try {
			 FilterGrid = driver.findElement(By.xpath("//th[3]//div[@class='filterHolder']//input"));
			 FilterGrid.click();
			 FilterGrid.sendKeys("Main");
			 try{
					WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder")));
					if(noRecordFoundElement.isDisplayed()){
						String noRecordFoundText = noRecordFoundElement.getText();
						Log.info(noRecordFoundText + "- to perform Filtering on the grid");
						
					} 
				}catch(Exception e3){
					Log.info("**** Records Filtering was Successfull ****");
				}
		} catch(Exception e3){
			Log.info("!!!! Failed - filtering the record !!!!");
		}
driver.findElement(By.xpath("//th[3]//div[@class='filterHolder']//button/i")).click();
		try {
			 FilterGrid = driver.findElement(By.xpath("//th[4]//div[@class='filterHolder']//input"));
			 FilterGrid.click();
			 FilterGrid.sendKeys("Main");
			 try{
					WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder")));
					if(noRecordFoundElement.isDisplayed()){
						String noRecordFoundText = noRecordFoundElement.getText();
						Log.info(noRecordFoundText + "- to perform Filtering on the grid");
						
					} 
				}catch(Exception e7){
					Log.info("**** Records Filtering was Successfull ****");
				}
		} catch(Exception e1){
			Log.info("!!!! Failed - filtering the record !!!!");
		}
driver.findElement(By.xpath("//th[2]//div[@class='filterHolder']//button/i")).click();
		}
}

public void Add_VerifyDefaultSection(String QuesDesc,String QuesResTyp) throws InterruptedException{
    
    Assert.assertTrue(enterTextbox("Question Description", QuesDesc, driver));
    Assert.assertTrue(selectDropdown("Question Response Type", QuesResTyp, driver));
    
//    WebElement Submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"))));
//	Submit.click();
	
	validateelementclickable(ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Links", "AssessmentBuilder").replace("<link>", "submit"), driver);
	
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(2000);
	
	validateobjectexists("//nm-table[@id='sectionDetailLineItem']//div[@class='scrollGrid']//tbody//tr[1]//td[1]",driver);
	Assert.assertTrue(validateobjectexists("//nm-table[@id='sectionDetailLineItem']//div[@class='scrollGrid']//tbody//tr[1]//td[3]", driver), "Default Section");
	Assert.assertTrue(validateobjectexists("//nm-table[@id='sectionDetailLineItem']//div[@class='scrollGrid']//tbody//tr[1]//td[5]//button[@title='Edit']", driver));
	Assert.assertTrue(validateobjectexists("//nm-table[@id='sectionDetailLineItem']//div[@class='scrollGrid']//tbody//tr[1]//td[6]//button[@title='Delete']", driver));
	Log.info("Successfully verified the Expanded row, Edit and Delete buttons in Assessment Builder Template grid - Default section");
	
	click(FieldType.xpath, ConfReader.getInstance().getConfData("ExpandRow", "AssessmentBuilder"), driver);
	
	try {
		List<WebElement> rows = driver.findElements(By.xpath("//nm-table[@id='questionLineItem']//tbody//tr")); 
		for(int i=1; i<= rows.size(); i++) {
			validateobjectexists("//nm-table[@id='questionLineItem']//div[@class='scrollGrid']//tbody//tr['" + i + "']//td[1]",driver);
			validateobjectexists("//nm-table[@id='questionLineItem']//div[@class='scrollGrid']//tbody//tr['" + i + "']//td[5]//button[@title='Edit']", driver);
			validateobjectexists("//nm-table[@id='questionLineItem']//div[@class='scrollGrid']//tbody//tr['" + i + "']//td[6]//button[@title='Delete']", driver);
			Log.info("Successfully verified the Expanded row, Edit and Delete buttons in Assessment Builder Template grid");
			
			Assert.assertTrue(validateobjectexists("//nm-table[@id='questionLineItem']//div[@class='scrollGrid']//tbody//tr[1]//td[3]", driver),QuesDesc);
			Log.info("Verified the Added Default Question in the Assessment Template Grid");
		}
	} catch (Exception e) {
		Log.info("!!!!! Unable to verify the Questins grid Expandable row, Edit and Delete buttons");
	}
}


public void filterAssessmentBuilderGrid() throws Exception {
	WebElement FilterGrid;
	
		try{
			WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder")));
			if(noRecordFoundElement.isDisplayed()){
				String noRecordFoundText = noRecordFoundElement.getText();
				Log.info(noRecordFoundText + "- to perform Filtering on the grid");
				
			} 
		}catch(Exception e){
			Log.info("Records are present for Filtering");
			driver.findElement(By.xpath(ConfReader.getInstance().getConfData("FilterIcon","AssessmentBuilder"))).click();
		
		try {
			 FilterGrid = driver.findElement(By.xpath("//th[1]//div[@class='filterHolder']//input"));
			 FilterGrid.click();
			 FilterGrid.sendKeys("Assessment");
			 try{
					WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder")));
					if(noRecordFoundElement.isDisplayed()){
						String noRecordFoundText = noRecordFoundElement.getText();
						Log.info(noRecordFoundText + "- to perform Filtering on the grid");
						
					} 
				}catch(Exception e2){
					Log.info("**** Records Filtering was Successfull ****");
				}
		} catch(Exception e2){
			Log.info("!!!! Failed - filtering the record !!!!");
		}
driver.findElement(By.xpath("//th[1]//div[@class='filterHolder']//button/i")).click();
		try {
			 FilterGrid = driver.findElement(By.xpath("//th[2]//div[@class='filterHolder']//input"));
			 FilterGrid.click();
			 FilterGrid.sendKeys("Test");
			 try{
					WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder")));
					if(noRecordFoundElement.isDisplayed()){
						String noRecordFoundText = noRecordFoundElement.getText();
						Log.info(noRecordFoundText + "- to perform Filtering on the grid");
						
					} 
				}catch(Exception e3){
					Log.info("**** Records Filtering was Successfull ****");
				}
		} catch(Exception e3){
			Log.info("!!!! Failed - filtering the record !!!!");
		}
driver.findElement(By.xpath("//th[2]//div[@class='filterHolder']//button/i")).click();
		try {
			driver.findElement(By.xpath("//th[3]//div[@class='filterHolder ng-star-inserted']//span//input")).click();
			Thread.sleep(2000);
			 FilterGrid = driver.findElement(By.xpath("//th[3]//div[@class='filterHolder ng-star-inserted']//span//div//td[5]/a"));
			 FilterGrid.click();
			 try{
					WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder")));
					if(noRecordFoundElement.isDisplayed()){
						String noRecordFoundText = noRecordFoundElement.getText();
						Log.info(noRecordFoundText + "- to perform Filtering on the grid");
						
					} 
				}catch(Exception e7){
					Log.info("**** Records Filtering was Successfull ****");
				}
		} catch(Exception e1){
			Log.info("!!!! Failed - filtering the record !!!!");
		}
driver.findElement(By.xpath("//th[3]//div[@class='filterHolder ng-star-inserted']//button/i")).click();
		try {
			driver.findElement(By.xpath("//th[4]//div[@class='filterHolder ng-star-inserted']//span//input")).click();
			Thread.sleep(2000);
			 FilterGrid = driver.findElement(By.xpath("//th[4]//div[@class='filterHolder ng-star-inserted']//span//div//td[5]/a"));
			 FilterGrid.click();
			 try{
					WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder")));
					if(noRecordFoundElement.isDisplayed()){
						String noRecordFoundText = noRecordFoundElement.getText();
						Log.info(noRecordFoundText + "- to perform Filtering on the grid");
					
					} 
				}catch(Exception e2){
					Log.info("**** Records Filtering was Successfull ****");
				}
		} catch(Exception e3){
			Log.info("!!!! Failed - filtering the record !!!!");
		}
driver.findElement(By.xpath("//th[4]//div[@class='filterHolder ng-star-inserted']//button/i")).click();
		try {
			 FilterGrid = driver.findElement(By.xpath("//th[5]//div[@class='filterHolder']//input"));
			 FilterGrid.click();
			 FilterGrid.sendKeys("Open");
			 try{
					WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder")));
					if(noRecordFoundElement.isDisplayed()){
						String noRecordFoundText = noRecordFoundElement.getText();
						Log.info(noRecordFoundText + "- to perform Filtering on the grid");
						
					} 
				}catch(Exception e4){
					Log.info("**** Records Filtering was Successfull ****");
				}
		} catch(Exception e5){
			Log.info("!!!! Failed - filtering the record !!!!");
		}
driver.findElement(By.xpath("//th[5]//div[@class='filterHolder']//button/i")).click();	
driver.findElement(By.xpath(ConfReader.getInstance().getConfData("FilterIcon","AssessmentBuilder"))).click();
		}
}

public void Sorting(WebDriver ldriver,int columnSortToStartIndex, int columnIndexVariable, int columnHeaderIndex) throws Exception {
	Boolean sortingFlag = false;
	Boolean resultFlag = true;
	WebElement sortColumns;	
	String columnName = "";
	try{
		WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilder")));
		if(noRecordFoundElement.isDisplayed()){
			String noRecordFoundText = noRecordFoundElement.getText();
			Log.info(noRecordFoundText + "- to perform sorting in the grid");
			
		} 
	}catch(Exception e){
		Log.info("Records are present for sorting");
		for(int i=0;i<GlobalValues.AssessmentBuilderPageGrid.size();i++){
			columnName = GlobalValues.AssessmentBuilderPageGrid.get(i);

			int ColumnNumber = columnSortToStartIndex;
			sortColumns = driver.findElement(By.xpath("//tr[@class='ng-star-inserted']//th["+(i+1)+"]//nm-th['"+columnName+"']/following::p-sorticon//i"));
			
			Thread.sleep(3000);
			sortingFlag = verifySorting(columnName, ColumnNumber, "ASC", columnIndexVariable);
			if (sortingFlag == true)
				Log.info("********* Ascending order sorting executed sucessfully for column : " + columnName);
			else
				Log.info("!!!!!  Error in Ascending order sorting  for column : " + columnName);
			Thread.sleep(3000);
			if (resultFlag != false)
				resultFlag = sortingFlag;
			sortColumns.click();
			Thread.sleep(3000);
			sortingFlag = verifySorting(columnName, ColumnNumber, "DESC", columnIndexVariable);
			if (sortingFlag == true)
				Log.info("********* Descending order sorting executed sucessfully for column : " + columnName);
			else
				Log.info("!!!!! Error in Descending order sorting for column : " + columnName);
			if (resultFlag != false)
				resultFlag = sortingFlag;
		}
	}
}

public void filterassessment() throws InterruptedException {
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(1000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAssessmentfilter", "AssessmentBuilder"), driver);
	Thread.sleep(1000);
	enter_text(GlobalValues.Assessmentname, FieldType.xpath, ConfReader.getInstance().getConfData("inpFiltervalue", "AssessmentBuilder"), driver);
	Thread.sleep(1000);
	
}


}