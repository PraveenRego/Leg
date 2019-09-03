package com.adminbuilder.Pages;
import static org.junit.Assert.assertFalse;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.baseutility.WebAction.FieldType;
import com.adminbuilder.configutility.ConfReader;

public class BranchingLogic extends WebAction {
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("BranchingLogic.class");
	GlobalValues global = new GlobalValues();
	public BranchingLogic(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	
	
	public void addSection(String SectionName) throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("addSection", "BranchingLogic"), driver);
		selectDropdown("Section Type","Main Section",driver);
		enterTextbox("Section Label", SectionName, driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("sectionType", "BranchingLogic"), driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("sectionType", "BranchingLogic"), driver);
		waitForLoadingToBecomeInvisible(driver);
		waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("btnSubmitAddSection", "BranchingLogic"),driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmitAddSection", "BranchingLogic"), driver);
	Log.info("Section "+SectionName+" added");
	Thread.sleep(5000);
	waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("btnAddQuestion", "AssessmentBuilder"),driver);
	}
	
	public void selectAssessmentSection(String SectionName) throws InterruptedException {
		click(FieldType.xpath, ConfReader.getInstance().getConfData("drpAssessmntSction", "assessmentBuilderaddQuestion"), driver);
		click(FieldType.xpath, "//label[contains(text(),'Assessment Section')]/../../..//div//li//span[contains(text(),'"+SectionName+"')]", driver);		
	}
	
	public void addQstnDesc(String Description) throws InterruptedException {
		enterTextbox("Question Description", Description, driver);
		}
	
	public void clickbranchingButton() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnBranching", "BranchingLogic"), driver);
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("branchingModalTilte", "BranchingLogic"), driver));
		Log.info("After clicking branching image modal with Header Title: Branching Questions opens");
	}
	
	public void verifyonLoadSection(String SectionName) throws InterruptedException  {
		
		String onLoadSection=get_text(ElementType.Dropdown,"Select Section",driver);
		//Assert.assertEquals(SectionName, onLoadSection);
		Log.info("Filter is defaulted to the section in which I am creating a branching logic question");
		
	}
	
	public void verifysectionlist() throws InterruptedException  {
	click(FieldType.xpath, ConfReader.getInstance().getConfData("selectSectioninmodal", "BranchingLogic"), driver);
	Thread.sleep(2000);
	Assert.assertTrue(getdropdownsize(ConfReader.getInstance().getConfData("selectSectionlist", "BranchingLogic"), driver)==2);	
	Log.info("Drop-down contains all the sections");
	click(FieldType.xpath, ConfReader.getInstance().getConfData("selectoneSection", "BranchingLogic"), driver);
	}
	
	
	public void verifypicklist()throws InterruptedException  {
		 Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("qstnpicklist", "BranchingLogic"), driver));
		 Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("qstnaddedpicklist", "BranchingLogic"), driver));
		Log.info("Picklists are present");
	}

	public void verifyAddbutton()throws InterruptedException  {
		click(FieldType.xpath, ConfReader.getInstance().getConfData("questionpicklistvalue", "BranchingLogic"), driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnpicklistright", "AssessmentBuilderCombineScoringCategory"), driver);
		Assert.assertFalse(validatebuttondisabled(ConfReader.getInstance().getConfData("btnAddbranching", "BranchingLogic"),driver));
		Log.info("Add button enabled after adding one or more Questions");
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("questionaddedpicklistvalue", "BranchingLogic"), driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnpicklistleft", "BranchingLogic"), driver);
		Assert.assertTrue(validatebuttondisabled(ConfReader.getInstance().getConfData("btnAddbranching", "BranchingLogic"),driver));
		Log.info("Add button disbaled after removingall Questions");
		
	}
	public void clickAddQuestions()throws InterruptedException  {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("questionpicklistvalue", "BranchingLogic"), driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnpicklistright", "AssessmentBuilderCombineScoringCategory"), driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAddbranching", "BranchingLogic"), driver);
		Log.info("Question added");
	}
	
	public void editquestionsandverify()throws InterruptedException  {
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btndoubleright", "BranchingLogic"), driver);
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAddbranching", "BranchingLogic"), driver);
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		int size = gettablesize(ConfReader.getInstance().getConfData("btnrowcountinbranchmodal", "BranchingLogic"), driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmitmodal", "BranchingLogic"), driver);
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
//		 waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("expandRow", "BranchingLogic"),driver);
		
		  int sizeafter = gettablesize(ConfReader.getInstance().getConfData("btnbranchingrows", "BranchingLogic"), driver);
		Assert.assertTrue(size == sizeafter);
		Log.info("Edited values are persists with branched question ");
		}
	
	public void verifybranchedquestionsgrid()throws InterruptedException  {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(1000);
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("lblBranchedQuestions", "BranchingLogic"), driver));
		Assert.assertEquals(getLists(ConfReader.getInstance().getConfData("branchedQuestionHeader", "BranchingLogic"), driver), GlobalValues.BranchedQuestionsGrid);
		Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("btndeleteBranchedQuestion", "BranchingLogic"), driver));
		Log.info("Branched Question headers are displayed as expected ");
		}
		
  public void verifySubmitandClosebuttons ()throws InterruptedException {
	  Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("btnSubmitmodal", "BranchingLogic"), driver));
	  Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("btnClosemodal", "BranchingLogic"), driver));
	  Log.info("Submit and Close buttons are present in modal");
	  
  }
  
  public void clickClosebutton ()throws InterruptedException {
	 waitForLoadingToBecomeInvisible(driver);
	 Thread.sleep(1000);
	  Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("btnClosemodal", "BranchingLogic"), driver));
	  waitForLoadingToBecomeInvisible(driver);
	 Thread.sleep(1000);
	  Log.info("Clicked the Close button present in modal");
	  
  }
  
  public void verifySubmit (String SectionName,String QuestionDescription)throws InterruptedException {
	  waitForLoadingToBecomeInvisible(driver);
	  Thread.sleep(1000);
	  waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("btnSubmitmodal", "BranchingLogic"),driver);
	   click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmitmodal", "BranchingLogic"), driver);		
	  waitForLoadingToBecomeInvisible(driver);
	  waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("hdrQuestion", "assessmentBuilderaddQuestion"),driver);
	  Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("hdrQuestion", "assessmentBuilderaddQuestion"), driver));
	  Log.info("Navigated back to Add question page");
	  Thread.sleep(2000);
	  waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("expandRow", "BranchingLogic"),driver);
	  click(FieldType.xpath, ConfReader.getInstance().getConfData("expandRow", "BranchingLogic"), driver);
	  Assert.assertEquals(getLists(ConfReader.getInstance().getConfData("childGridColhdranswersection", "BranchingLogic"), driver), GlobalValues.BranchedQuestionsChildGrid);
	  Log.info("Branched Question headers are displayed as expected in child Grid of Answer Section Grid");
	  String childrowtext=get_text(ConfReader.getInstance().getConfData("questionAdded", "BranchingLogic"),driver);
	  String childquestiontext=get_text(ConfReader.getInstance().getConfData("questiondescAdded", "BranchingLogic"),driver);
	  Assert.assertEquals(SectionName, childrowtext);
	  Assert.assertEquals(QuestionDescription, childquestiontext);
	  Log.info("Question is added in child grid after clicking Submit button");
	  
  }
 
  public void clickSubmitinQstnpg ()throws InterruptedException {
	  waitForLoadingToBecomeInvisible(driver);
		  click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"), driver);
 }
  
  public void verifydelete ()throws InterruptedException {
	  waitForLoadingToBecomeInvisible(driver);
	  int sizebefore = gettablesize(ConfReader.getInstance().getConfData("btnbranchingrows", "BranchingLogic"), driver);
	   click(FieldType.xpath, ConfReader.getInstance().getConfData("btndeletebranching", "BranchingLogic"), driver);
	   waitForLoadingToBecomeInvisible(driver);
	   Thread.sleep(1000);
	   int sizeafter = gettablesize(ConfReader.getInstance().getConfData("btnbranchingrows", "BranchingLogic"), driver); 
	   Assert.assertTrue(sizebefore > sizeafter);
	   Log.info("The question has been deleted after clicking Delete button");
 }
  
  public void clickSubmitandAddnewinQstnpg ()throws InterruptedException {
	  waitForLoadingToBecomeInvisible(driver);
		 click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmitandAddNew", "assessmentBuilderaddQuestion"), driver);
 }

  public void verifybranchinginQuestion (String SectionName,String QuestionDescription,String Question)throws InterruptedException {
	  waitForLoadingToBecomeInvisible(driver);
	  Thread.sleep(2000);
	  waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("expandRow", "BranchingLogic"),driver);
		  click(FieldType.xpath, ConfReader.getInstance().getConfData("expandRow", "BranchingLogic"), driver);
	  waitForObjectToBecomeVisible("//td//span[text()='"+Question+"']//parent::span/parent::p-celleditor/parent::td//preceding-sibling::td//a",driver);
		  click(FieldType.xpath, "//td//span[text()='"+Question+"']//parent::span/parent::p-celleditor/parent::td//preceding-sibling::td//a", driver);
	  waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("expandrowBranching", "BranchingLogic"),driver);
	  click(FieldType.xpath, ConfReader.getInstance().getConfData("expandrowBranching", "BranchingLogic"), driver);
	  Assert.assertEquals(getLists(ConfReader.getInstance().getConfData("childGridcolumnheader", "BranchingLogic"), driver), GlobalValues.BranchedQuestionsChildGrid);
	  Log.info("Branched Question headers are displayed as expected in child Grid of Question Grid");
	  String childrowtext=get_text(ConfReader.getInstance().getConfData("branchinginQuestion", "BranchingLogic"),driver);
	  String childquestiontext=get_text(ConfReader.getInstance().getConfData("questiondescAddedinQuestion", "BranchingLogic"),driver);
	   Assert.assertEquals(SectionName, childrowtext);
	  Assert.assertEquals(QuestionDescription, childquestiontext);
		 
	  Log.info("Branching is displayed along with Question");
	  	
  }
  
  public void clickBack  ()throws InterruptedException {
	  waitForLoadingToBecomeInvisible(driver);
	  waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("btnBack", "assessmentBuilderaddQuestion"),driver);
	  click(FieldType.xpath, ConfReader.getInstance().getConfData("btnBack", "assessmentBuilderaddQuestion"), driver);
  }
  
  public void verifyClose ()throws InterruptedException {
	  waitForLoadingToBecomeInvisible(driver);
	  Thread.sleep(2000);
	  click(FieldType.xpath, ConfReader.getInstance().getConfData("btnClosemodal", "BranchingLogic"), driver);		
	  waitForLoadingToBecomeInvisible(driver);
	  Thread.sleep(2000);
	  waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("hdrQuestion", "assessmentBuilderaddQuestion"),driver);
	  Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("hdrQuestion", "assessmentBuilderaddQuestion"), driver));
	  Log.info("Navigated back to Add question page");
	  waitForLoadingToBecomeInvisible(driver);
	  waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("expandRow", "BranchingLogic"),driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("expandRow", "BranchingLogic"), driver);
	  String childrowtext=get_text(ConfReader.getInstance().getConfData("norecordsrow", "BranchingLogic"),driver);
	  Assert.assertEquals("No records found", childrowtext);
	  Log.info("Question is not added in child grid after clicking Close button");
	  
	  
  }
  
  public void validatenochildGrid ()throws InterruptedException {
	  waitForLoadingToBecomeInvisible(driver);
	  	waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("expandRow", "BranchingLogic"),driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("expandRow", "BranchingLogic"), driver);
		 String childrowtext=get_text(ConfReader.getInstance().getConfData("norecordsrow", "BranchingLogic"),driver);
		  Assert.assertFalse(childrowtext.contains("No records found"));
		  Log.info("Child grid is hidden in answer grid");
		 
  }
  
  public void validatenochildGridinQuestionGird (String Question)throws InterruptedException {
	  waitForLoadingToBecomeInvisible(driver);
	  waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("expandRow", "BranchingLogic"),driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("expandRow", "BranchingLogic"), driver);
		 waitForObjectToBecomeVisible("//td//span[text()='"+Question+"']//parent::span/parent::p-celleditor/parent::td//preceding-sibling::td//a",driver);
		  click(FieldType.xpath, "//td//span[text()='"+Question+"']//parent::span/parent::p-celleditor/parent::td//preceding-sibling::td//a", driver);
		  waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("expandrowBranching", "BranchingLogic"),driver);
		  click(FieldType.xpath, ConfReader.getInstance().getConfData("expandrowBranching", "BranchingLogic"), driver);
		  String childrowtext=get_text(ConfReader.getInstance().getConfData("norecordshowonQuestionGrid", "BranchingLogic"),driver);
		  Assert.assertFalse(childrowtext.contains("No records found"));
		  Log.info("Child grid is hidden in answer grid");
		 
  }

}