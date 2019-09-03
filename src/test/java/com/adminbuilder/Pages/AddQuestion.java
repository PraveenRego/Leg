package com.adminbuilder.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.configutility.ConfReader;

public class AddQuestion extends WebAction{
	
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("AddQuestion.class");
	
	public AddQuestion(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}

	public void clickAddAssessmentwithoutsubmit(String assessmentname) throws InterruptedException {
	       
	       click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAddAssessment", "AssessmentBuilder"), driver);
	       Log.info("AddAssessment is  clicked");
	       enterTextbox("Assessment Name", assessmentname, driver);
	}


	public void validatebackbuttoninquestionsection() throws InterruptedException {
	       Assert.assertTrue(!validatebuttondisabled(ConfReader.getInstance().getConfData("btnBack", "AddQuestion"),driver));
	       Log.info("Passed: Back button is enabled before user inputs the required fields");
	       Thread.sleep(6000);
	       Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("btnBack", "AddQuestion"),driver));
	              Log.info("Back button is clicked");
	             
	       Thread.sleep(6000);
	       Assert.assertTrue(driver.findElement(By.xpath(ConfReader.getInstance().getConfData("hdrAddAssessment", "AddQuestion"))).getText().equalsIgnoreCase("Add Assessment"));
	       Log.info("Passed: User is navigated back to Add Assessment Page on clicking Back button");
	       
	}

	public void validatequestionsection() throws InterruptedException {
        Assert.assertTrue(validatebuttondisabled(ConfReader.getInstance().getConfData("btnSubmitandAddNew", "AddQuestion"),driver));
        Log.info("Passed: Submit & Add New button is disabled before user inputs the required fields");
        
 
        Assert.assertTrue(validatebuttondisabled(ConfReader.getInstance().getConfData("btnSubmit", "AddQuestion"),driver));
        Log.info("Passed: Submit button is disabled before user inputs the required fields");
 
 
 Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblQuestionSection", "AddQuestion"), driver));
 Log.info("Section label is Question as expected");
 Assert.assertTrue((validateobjectexists(ConfReader.getInstance().getConfData("lblQuestionOrder", "AddQuestion"), driver))
 && (validateobjectexists(ConfReader.getInstance().getConfData("inpQuestionOrder", "AddQuestion"), driver)));
 Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("lblQuestionOrder", "AddQuestion"), driver));
        Log.info("Passed: Question Order field is required");
 
 
               Assert.assertTrue(get_text(ElementType.Textbox, "Question Order", driver).equalsIgnoreCase("1"));
               Log.info("Passed: Question Order is auto-populated to 1 on form load");
        
        Assert.assertTrue(enterTextbox("Question Order", "Non-numeric", driver)) ;
        Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("wrngmsgQuestionOrder", "AddQuestion"), driver));
               Log.info("Passed: Expected warning message is displayed when non-numerical value is entered in Question Order field");
        
               
               Assert.assertTrue(enterTextbox("Question Order", "1", driver));
               Assert.assertFalse(validateobjectexists(ConfReader.getInstance().getConfData("wrngmsgQuestionOrder", "AddQuestion"), driver));
               Log.info("Passed: Warning message is not displayed when numerical value is entered in Question Order field");
        
 
 
               Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblQuestionDesc", "AddQuestion"), driver)
        &&     validateobjectexists(ConfReader.getInstance().getConfData("inpQuestionDesc", "AddQuestion"), driver));
        Log.info("Passed: Question Description field exists");
 
 
 
        Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("lblQuestionDesc", "AddQuestion"), driver));
        Log.info("Passed: Question Description field is required");
 
 
        Assert.assertTrue(enterTextbox("Question Description", "Test Question Description", driver));
        Log.info("Entered text in Question Description field");
 
 
        Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblQuestionID", "AddQuestion"), driver));
        Log.info("Question ID field exists");
        
 
        Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblQuestionResponseType", "AddQuestion"), driver));
        Log.info("Question Type field exists");
        Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("lblQuestionResponseType", "AddQuestion"), driver));
               Log.info("Passed: Question Response Type field is a required field");
 
 
               Assert.assertTrue(validateDropdown("Question Response Type",GlobalValues.QuestionResponseTypedropdownvalues,driver));
               Log.info("Passed: Question Response Type drop down contains the required values");
               Assert.assertTrue(GlobalValues.QuestionResponseTypedropdownvalues.contains("Signature"));
               Log.info("Passed: CMDM-31576 - Signature is included in the Question Response Type drop down");
               Log.info("CMDM-31576 - database validation is not included in automation");
               driver.findElement(By.xpath(ConfReader.getInstance().getConfData("drpQuestionResponseType", "AddQuestion"))).click();
               
               Assert.assertTrue(selectDropdown("Question Response Type",GlobalValues.QuestionResponseTypedropdownvalues.get(0),driver));
               Log.info("Selected value in Question Response Type field");
 
 
               Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblConceptCodeDesc", "AddQuestion"), driver)
               && validateobjectexists(ConfReader.getInstance().getConfData("inpConceptCodeDesc", "AddQuestion"), driver));
               Log.info("Passed: Concept Code Description field exists");
 
 
               Assert.assertTrue(enterTextbox("Concept Code Description", "Test Concept Code Description field", driver));
        Log.info("Entered text in Concept Code Description field");

 
        Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblConceptCode", "AddQuestion"), driver)
               && validateobjectexists(ConfReader.getInstance().getConfData("inpConceptCode", "AddQuestion"), driver));
        Log.info("Passed: Concept Code field exists");
 
 
        Assert.assertTrue(enter_text("Test Concept Code field",FieldType.xpath, ConfReader.getInstance().getConfData("inpConceptCode", "AddQuestion"), driver));
        Log.info("Entered text in Concept Code field");
 
 
 
        Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblConceptID", "AddQuestion"), driver)
               && validateobjectexists(ConfReader.getInstance().getConfData("inpConceptID", "AddQuestion"), driver));
        Log.info("Passed: Concept ID field exists");
 
 
        Assert.assertTrue(enterTextbox("Concept ID", "Test Concept ID field", driver));
        Log.info("Entered text in Concept ID field");
 
 
 
 
        Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblReqQuestforAssesmnt", "AddQuestion"), driver)
               && validateobjectexists(ConfReader.getInstance().getConfData("swtchReqQuestforAssesmnt", "AddQuestion"), driver));
               Log.info("Passed: Required Question for an Assessment field exists");
               Assert.assertTrue(!validateswitchchecked(ConfReader.getInstance().getConfData("swtchReqQuestforAssesmnt", "AddQuestion"),driver));
                     Log.info("Passed: Required Question for an assessment switch is disabled by default");
                      driver.findElement(By.xpath(ConfReader.getInstance().getConfData("swtchReqQuestforAssesmnt", "AddQuestion"))).click();
               
 
 
                      Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblInclinScoring", "AddQuestion"), driver)
               && validateobjectexists(ConfReader.getInstance().getConfData("swtchInclinScoring", "AddQuestion"), driver));
                     Log.info("Passed: Include in Scoring field exists");
                      Assert.assertTrue(!validateswitchchecked(ConfReader.getInstance().getConfData("swtchInclinScoring", "AddQuestion"),driver));
                     Log.info("Passed: Include in Scoring switch is disabled by default");
                      driver.findElement(By.xpath(ConfReader.getInstance().getConfData("swtchInclinScoring", "AddQuestion"))).click();
                     Thread.sleep(2000);
                      Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblScoringCategory", "AddQuestion"),driver));
                            Log.info("Passed: Scoring Category field is displayed when Include in Scoring switch is turned on");
                            Assert.assertTrue(enterTextbox("Scoring Category", "Test Scoring Category", driver));
                                   Log.info("Entered text in Scoring Category field");
                            
                                   Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblAssessmntSction", "AddQuestion"), driver));
                                   Log.info("Assessment Section field exists");
                                   Assert.assertTrue(!validateobjectmandatory(ConfReader.getInstance().getConfData("lblAssessmntSction", "AddQuestion"), driver));
                                   Log.info("Passed: Assessment Section field is not a required field");
        
 
                                   Assert.assertTrue(validateDropdown("Assessment Section",GlobalValues.AssessmentSectiondropdownvalues,driver));
                                   Log.info("Passed: Assessment Section drop down contains the required values");
                                   driver.findElement(By.xpath(ConfReader.getInstance().getConfData("drpAssessmntSction", "AddQuestion"))).click();
                                   Assert.assertTrue(selectDropdown("Assessment Section",GlobalValues.AssessmentSectiondropdownvalues.get(0),driver));
                                   Log.info("Value selected in Assessment section drop down");

 
                                   Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblToolTip", "AddQuestion"), driver)
                                                 && validateobjectexists(ConfReader.getInstance().getConfData("inpToolTip", "AddQuestion"), driver));
                                   Log.info("Passed: Tool Tip field exists");
 
 
                                   Assert.assertTrue(enterTextbox("Tool Tip", "Test Tool Tip field", driver)); 
                                   Log.info("Entered text in Tool Tip field");
 
}      



public void insertanswer(String answer) throws InterruptedException{
 
        Assert.assertTrue(selectDropdown("Insert Answer",answer, driver));
        Log.info("Answer inserted");
 
}




public void validateSubmitandAddNew() throws InterruptedException{
 Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmitandAddNew", "AddQuestion"), driver));
 Log.info("Clicked on Submit and Add New button");
 Thread.sleep(2000);
}



 public void validateSubmit() throws InterruptedException{
        Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmit", "AddQuestion"), driver));
        Log.info("Clicked on Submit button");
        Thread.sleep(2000);
        
 }
 
 
 public void validateformsubmit() throws InterruptedException{
        Assert.assertTrue(driver.findElement(By.xpath(ConfReader.getInstance().getConfData("hdrAddAssessment", "AddQuestion"))).getText().equalsIgnoreCase("Add Assessment"));
        Log.info("Passed: User is navigated back to Add Assessment Page");
 }
 


}
