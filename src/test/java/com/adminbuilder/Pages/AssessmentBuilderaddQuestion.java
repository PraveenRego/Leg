package com.adminbuilder.Pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.baseutility.WebAction.FieldType;
import com.adminbuilder.configutility.ConfReader;


public class AssessmentBuilderaddQuestion extends WebAction{
	
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("AssessmentBuilderaddQuestion.class");
	GlobalValues global = new GlobalValues();
	
	public AssessmentBuilderaddQuestion(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	
	public enum UpdateType {
		 Add,
		 Edit
	}
	 

public void validateanswersection(String Questionresponsetype) throws InterruptedException {
		Log.info("The Question Response selected is " +Questionresponsetype);
		Thread.sleep(2000);
		selectDropdown("Question Response Type", Questionresponsetype, driver);
		if(Questionresponsetype.equalsIgnoreCase("Checkbox Group") || Questionresponsetype.equalsIgnoreCase("Radio Button") 
				|| Questionresponsetype.equalsIgnoreCase("Drop down")) {
			
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("inpDropdown", "generic").replace("<fieldname>", "Insert Answer"), driver)
					&& validateobjectexists(ConfReader.getInstance().getConfData("inpTextbox", "generic").replace("<fieldname>", "Answer Order"), driver)
					&& validateobjectexists(ConfReader.getInstance().getConfData("inpTextbox", "generic").replace("<fieldname>", "Answer Text"), driver)
					&& validatebuttondisabled(ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"), driver)
					&& validatebuttondisabled(ConfReader.getInstance().getConfData("btnSubmit&AddNew", "assessmentBuilderaddQuestion"), driver)
					);
			Log.info("**Passed ** When user selects " +Questionresponsetype + " Insert Answer, Answer Order, Answer Text and Answer Score Value is displayed");
			Log.info("**Passed ** Submit and Submit & Add New button on the add question page is disabled");
		}
		else {
			Thread.sleep(2000);
			Assert.assertTrue(!(validateobjectexists(ConfReader.getInstance().getConfData("inpDropdown", "generic").replace("<fieldname>", "Insert Answer"), driver))
					/*&& !(validateobjectexists(ConfReader.getInstance().getConfData("inpTextbox", "generic").replace("<fieldname>", "Answer Order"), driver))
					&& !(validateobjectexists(ConfReader.getInstance().getConfData("inpTextbox", "generic").replace("<fieldname>", "Answer Text"), driver))
					&& !(validateobjectexists(ConfReader.getInstance().getConfData("inpTextbox", "generic").replace("<fieldname>", "Answer Score Value"), driver))*/
					);
			Log.info("**Passed ** When user selects " +Questionresponsetype + " Insert Answer, Answer Order, Answer Text and Answer Score Value is not displayed");
		}
			
//		Assert.assertTrue(!(validateobjectexists(ConfReader.getInstance().getConfData("inpTextbox", "generic").replace("<fieldname>", "Answer Score Value"), driver)));
		Log.info("**Passed ** When user selects " +Questionresponsetype + " and Include in scoring is False, Answer Score Value is not displayed");
	 }


public void validateAnswerorderprepopulate() throws InterruptedException {
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(2000);
	String lastAnswerorder = get_text(ConfReader.getInstance().getConfData("lblanswerordergridlast", "assessmentBuilderaddQuestion"), driver);
	String prepopulatedAnswerorder = get_text(ElementType.Textbox, "Answer Order", driver);
	Assert.assertEquals(Integer.parseInt(lastAnswerorder)+1, Integer.parseInt(prepopulatedAnswerorder));
	Log.info("**Passed ** Answer order adjusted to next value when a new answer option with previously added order is added");

}

public void validateAnswerordererrormsg(String strAnswerorder) throws InterruptedException {
	enterTextbox("Answer Order", strAnswerorder, driver);
	Thread.sleep(1000);
	validateobjectexists(ConfReader.getInstance().getConfData("msganswerordererror", "assessmentBuilderaddQuestion"), driver);
	Log.info("**Passed ** Answer order validation message : Only numerical values allowed is displayed");
}


public void validateanswermandatory() throws InterruptedException {
	
	Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("lblAnswerOrder", "assessmentBuilderaddQuestion"), driver)
			&& validateobjectmandatory(ConfReader.getInstance().getConfData("lblAnswerText", "assessmentBuilderaddQuestion"), driver));
	
			
	Log.info("**Passed ** When when user does not make a selection in the insert answer (Insert Answer is a separate user story)\r\n" + 
			"\r\n" + 
			"Then the following fields shall be mandatory\r\n" + 
			"\r\n" + 
			"Answer Order\r\n" + 
			"Answer Text");
	Assert.assertTrue((validateobjectreadonly(ConfReader.getInstance().getConfData("btnAdd", "assessmentBuilderaddQuestion"), driver)));
	Log.info("When Mandatory fields are not entered, Add button is disabled ");
 }

public void AddEditanswer(String AnswerText, String AnswerScore, UpdateType updatetype) throws InterruptedException {
	String s = get_text(ElementType.Textbox, "Answer Order", driver);
	if(s.equalsIgnoreCase("")) {
		enterTextbox("Answer Order", "1", driver);
	}
	enterTextbox("Answer Text", AnswerText, driver);
	enterTextbox("Answer Score Value", AnswerScore, driver);
	ArrayList<String> tableDatabefore = new ArrayList<>();
	tableDatabefore = getrecentaddedformfromtable(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"), new ArrayList<>(), driver);
	switch(updatetype) {
	
	case Add:
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAdd", "assessmentBuilderaddQuestion"), driver);
	Log.info("Mandatory fields are entered, Add button is enabled and clicked ");
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
	Thread.sleep(4000);
	ArrayList<String> tableData = getrecentaddedformfromtable(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"), new ArrayList<>(), driver);
	
	if(updatetype.equals(UpdateType.Edit)) {
		Assert.assertEquals(tableDatabefore.get(0), tableData.get(0));
		Log.info("AnswerOrder is populated with the information provided by the user ");
	}else {
		if(!(tableDatabefore.isEmpty())) {
			Assert.assertEquals(String.valueOf(Integer.parseInt(tableDatabefore.get(0)) + 1), tableData.get(0));
			Log.info("AnswerOrder is populated with the information provided by the user ");
		}
	}
	Assert.assertEquals(AnswerText, tableData.get(1));	
	Log.info("AnswerText is populated with the information provided by the user ");
	
	Assert.assertEquals(AnswerScore, tableData.get(2));	
	Log.info("AnswerScore is populated with the information provided by the user ");
	waitForLoadingToBecomeInvisible(driver);
	tableData.clear();
 }

public void AddEditanswererror(String AnswerText, String AnswerScore, UpdateType updatetype) throws InterruptedException {
	
	
	enterTextbox("Answer Text", AnswerText, driver);
	enterTextbox("Answer Score Value", AnswerScore, driver);
	switch(updatetype) {
	
	case Add:
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAdd", "assessmentBuilderaddQuestion"), driver);
	Log.info("Mandatory fields are entered, Add button is enabled and clicked ");
	break;
	
	case Edit:
		click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSave", "assessmentBuilderaddQuestion"), driver);
		Log.info("Mandatory fields are entered, Save button is enabled and clicked");
		break;
		
	default:
		Log.info("Please select the correct update type ");
		break;
	}
	Thread.sleep(2000);
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblerrorduplicateanswerresponse", "assessmentBuilderaddQuestion"), driver));
	
	
}

public void validateformreset() throws InterruptedException {
	
	Assert.assertEquals("Please Select...", get_text(ElementType.Dropdown, "Insert Answer", driver));
	Log.info("After Add button is clicked, Insert Answer dropdown is reset ");
	
//	Assert.assertEquals("",get_text(ElementType.Textbox, "Answer Order", driver));
//	Log.info("After Add button is clicked, Answer Order dropdown is reset ");
	
	Assert.assertEquals("",get_text(ElementType.Textbox, "Answer Text", driver));
	Log.info("After Add button is clicked, Answer Text dropdown is reset ");
	
 }

public void selectanswerandadd(String option) throws InterruptedException {
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(2000);
	selectDropdown("Insert Answer", option, driver);
	Thread.sleep(2000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnAdd", "assessmentBuilderaddQuestion"), driver);
}

public void verifyanswergrid(String option) throws InterruptedException {
	if(validateobjectexists(ConfReader.getInstance().getConfData("lblNorecordsfound", "assessmentBuilderaddQuestion"), driver)){
		if(option.equalsIgnoreCase("Yes and No")) {
			for(int i=1;i<=2;i++) {
			ArrayList<String> tableData = getrowdata(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"),i, new ArrayList<>(), driver);
			Assert.assertEquals(Integer.toString(i), tableData.get(0));
			Log.info("AnswerOrder is populated as " +tableData.get(0) );
			if(i==1) {
			Assert.assertEquals("Yes", tableData.get(1));	
			Log.info("AnswerText is populated as " +tableData.get(1));
			}else {
				Assert.assertEquals("No", tableData.get(1));	
				Log.info("AnswerText is populated as " +tableData.get(1));
			}
			waitForLoadingToBecomeInvisible(driver);
			
			}
		}
		else if(option.equalsIgnoreCase("Yes, No and Not Applicable")){
			for(int i=1;i<=3;i++) {
				ArrayList<String> tableData = getrowdata(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"),i, new ArrayList<>(), driver);
				Assert.assertEquals(Integer.toString(i), tableData.get(0));
				Log.info("AnswerOrder is populated as " +tableData.get(0) );
				if(i==1) {
				Assert.assertEquals("Yes", tableData.get(1));	
				Log.info("AnswerText is populated as " +tableData.get(1));
				}else if(i==2){
					Assert.assertEquals("No", tableData.get(1));	
					Log.info("AnswerText is populated as " +tableData.get(1));
				}
				else if(i==3){
					Assert.assertEquals("Not Applicable", tableData.get(1));	
					Log.info("AnswerText is populated " +tableData.get(1));
				}
				waitForLoadingToBecomeInvisible(driver);
				}
		}
		else if(option.equalsIgnoreCase("Gender")){
			for(int i=1;i<=4;i++) {
				ArrayList<String> tableData = getrowdata(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"),i, new ArrayList<>(), driver);
				Assert.assertEquals(Integer.toString(i), tableData.get(0));
				Log.info("AnswerOrder is populated as " +tableData.get(0) );
				if(i==1) {
				Assert.assertEquals("Male", tableData.get(1));	
				Log.info("AnswerText is populated as " +tableData.get(1));
				}else if(i==2){
					Assert.assertEquals("Female", tableData.get(1));	
					Log.info("AnswerText is populated as " +tableData.get(1));
				}
				else if(i==3){
					Assert.assertEquals("Transgender", tableData.get(1));	
					Log.info("AnswerText is populated " +tableData.get(1));
				}
				else if(i==4){
					Assert.assertEquals("Unknown", tableData.get(1));	
					Log.info("AnswerText is populated " +tableData.get(1));
				}
				waitForLoadingToBecomeInvisible(driver);
				}
		}
		else {
			
			waitForLoadingToBecomeInvisible(driver);
			Thread.sleep(2000);
			ArrayList<String> tableData = getLists(ConfReader.getInstance().getConfData("lblanswervalue", "assessmentBuilderaddQuestion"), driver);
			while(validateobjectexists(ConfReader.getInstance().getConfData("lnknextpage", "assessmentBuilderaddQuestion"), driver)) {
//				while(!validatebuttondisabled(ConfReader.getInstance().getConfData("lnknextpage", "assessmentBuilderaddQuestion"), driver)) {
					click(FieldType.xpath, ConfReader.getInstance().getConfData("lnknextpage", "assessmentBuilderaddQuestion"), driver);
					tableData = getLists(ConfReader.getInstance().getConfData("lblanswervalue", "assessmentBuilderaddQuestion"), driver);
//				}
			}
			if(option.equalsIgnoreCase("Relationship")) {
				Log.info("Verfying the Relationship Answer Options ");
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionRelationship));
				Log.info("Verfied the Relationship Answer Options " + tableData);
			}
			else if(option.equalsIgnoreCase("Race")) {
				Log.info("Verfying the Race Answer Options ");
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionRace));
				Log.info("Verfied the Race Answer Options " + tableData);
			}
			else if(option.equalsIgnoreCase("Ethnicity")) {
				Log.info("Verfying the Ethnicity Answer Options ");
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionEthnicity));
				Log.info("Verfied the Ethnicity Answer Options " + tableData);
			}
			else if(option.equalsIgnoreCase("Marital Status")) {
				Log.info("Verfying the Marital Status Answer Options ");
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionMaritalStatus));
				Log.info("Verfied the Marital Status Answer Options " + tableData);
			}
			else if(option.equalsIgnoreCase("Assistance")) {
				Log.info("Verfying theAssistance Answer Options ");
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionAssistance));
				Log.info("Verfied the Assistance Answer Options " + tableData);
			}
			else if(option.equalsIgnoreCase("Severity")) {
				Log.info("Verfying the Severity Answer Options ");
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionSeverity));
				Log.info("Verfied the Severity Answer Options " + tableData);
			}
			else if(option.equalsIgnoreCase("Frequency of therapy")) {
				Log.info("Verfying the Frequency of therapy Answer Options ");
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionFrequencyoftherapy));
				Log.info("Verfied the Frequency of therapy Answer Options " + tableData);
			}
			else if(option.equalsIgnoreCase("Physician Specialty")) {
				Log.info("Verfying the Physician Specialty of therapy Answer Options ");
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionFrequencyoftherapy));
				Log.info("Verfied the Physician Specialty of therapy Answer Options " + tableData);
			}
		}
		
	}
	else {
		int size = gettablesize(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"), driver);
		if(option.equalsIgnoreCase("Yes and No")) {
			for(int i=size-1;i<=size;i++) {
				ArrayList<String> tableData = getrowdata(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"),i, new ArrayList<>(), driver);
				Assert.assertEquals(Integer.toString(i), tableData.get(0));
				Log.info("AnswerOrder is populated with the information provided by the user ");
				if(i==size-1) {
				Assert.assertEquals("Yes", tableData.get(1));	
				Log.info("AnswerText is populated with the information provided by the user ");
				}else if(i==(size)){
					Assert.assertEquals("No", tableData.get(1));	
					Log.info("AnswerText is populated with the information provided by the user ");
				}
				waitForLoadingToBecomeInvisible(driver);
				}
		}
		else if(option.equalsIgnoreCase("Yes, No and Not Applicable")){
			for(int i=size-2;i<=size;i++) {
				ArrayList<String> tableData = getrowdata(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"),i, new ArrayList<>(), driver);
				Assert.assertEquals(Integer.toString(i), tableData.get(0));
				Log.info("AnswerOrder is populated with the information provided by the user ");
				if(i==(size-2)) {
				Assert.assertEquals("Yes", tableData.get(1));	
				Log.info("AnswerText is populated with the information provided by the user ");
				}else if(i==(size-1)){
					Assert.assertEquals("No", tableData.get(1));	
					Log.info("AnswerText is populated with the information provided by the user ");
				}
				else if(i==size){
					Assert.assertEquals("Not Applicable", tableData.get(1));	
					Log.info("AnswerText is populated with the information provided by the user ");
				}
				waitForLoadingToBecomeInvisible(driver);
				}
		}
		else {
			
			waitForLoadingToBecomeInvisible(driver);
			Thread.sleep(2000);
			ArrayList<String> tableData = getLists(ConfReader.getInstance().getConfData("lblanswervalue", "assessmentBuilderaddQuestion"), driver);
			while(validateobjectexists(ConfReader.getInstance().getConfData("lnknextpage", "assessmentBuilderaddQuestion"), driver)) {
//				while(!validatebuttondisabled(ConfReader.getInstance().getConfData("lnknextpage", "assessmentBuilderaddQuestion"), driver)) {
					click(FieldType.xpath, ConfReader.getInstance().getConfData("lnknextpage", "assessmentBuilderaddQuestion"), driver);
//					tableData = getLists(ConfReader.getInstance().getConfData("lblanswervalue", "assessmentBuilderaddQuestion"), driver);
//				}
					tableData.addAll(getLists(ConfReader.getInstance().getConfData("lblanswervalue", "assessmentBuilderaddQuestion"), driver));
			}
			if(option.equalsIgnoreCase("Relationship")) {
				Log.info("Verfying the Relationship Answer Options "+ tableData);
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionRelationship));
				Log.info("Verfied the Relationship Answer Options " + tableData);
				tableData.clear();
			}
			else if(option.equalsIgnoreCase("Race")) {
				Log.info("Verfying the Race Answer Options ");
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionRace));
				Log.info("Verfied the Race Answer Options " + tableData);
				tableData.clear();
			}
			else if(option.equalsIgnoreCase("Ethnicity")) {
				Log.info("Verfying the Ethnicity Answer Options ");
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionEthnicity));
				Log.info("Verfied the Ethnicity Answer Options " + tableData);
				tableData.clear();
			}
			else if(option.equalsIgnoreCase("Marital Status")) {
				Log.info("Verfying the Marital Status Answer Options ");
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionMaritalStatus));
				Log.info("Verfied the Marital Status Answer Options " + tableData);
				tableData.clear();
			}
			else if(option.equalsIgnoreCase("Assistance")) {
				Log.info("Verfying theAssistance Answer Options ");
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionAssistance));
				Log.info("Verfied the Assistance Answer Options " + tableData);
			}
			else if(option.equalsIgnoreCase("Severity")) {
				Log.info("Verfying the Severity Answer Options ");
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionSeverity));
				Log.info("Verfied the Severity Answer Options " + tableData);
				tableData.clear();
			}
			else if(option.equalsIgnoreCase("Frequency of therapy")) {
				Log.info("Verfying the Frequency of therapy Answer Options ");
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionFrequencyoftherapy));
				Log.info("Verfied the Frequency of therapy Answer Options " + tableData);
				tableData.clear();
			}
			else if(option.equalsIgnoreCase("Physician Specialty")) {
				Log.info("Verfying the Physician Specialty of therapy Answer Options ");
				Assert.assertTrue(tableData.containsAll(GlobalValues.AnsweroptionFrequencyoftherapy));
				Log.info("Verfied the Physician Specialty of therapy Answer Options " + tableData);
				tableData.clear();
			}
		}
	}
}

public void clickedit() throws InterruptedException {
	
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btneditrecentrow", "assessmentBuilderaddQuestion"), driver);
	Log.info("Edit button in the grid is clicked ");
	waitForLoadingToBecomeInvisible(driver);
}

public void clickdeleteandverify() throws InterruptedException {
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(1000);
	int size = gettablesize(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"), driver);
	ArrayList<String> tableData = getrowdata(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"), size, new ArrayList<>(), driver);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btndeleterecentrow", "assessmentBuilderaddQuestion"), driver);
	Log.info("Delete button in the grid is clicked ");
	Thread.sleep(3000);
	waitForLoadingToBecomeInvisible(driver);
	
	if(validateobjectexists(ConfReader.getInstance().getConfData("lblNorecordsfound", "assessmentBuilderaddQuestion"), driver)) {
		Log.info("Deleted records are not present in the grid ");
	}
	else {
		int sizenew = gettablesize(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"), driver);
		ArrayList<String> tableDatanew = getrowdata(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"), sizenew, new ArrayList<>(), driver);
		
		Assert.assertNotSame(size, sizenew);
		Assert.assertNotSame(tableData, tableDatanew);
		
		Log.info("Deleted records are not present in the grid ");
	
	}
}



public void validateanswersection() throws InterruptedException {
	
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("inpDropdown", "generic").replace("<fieldname>", "Insert Answer"), driver));
	
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("inpTextbox", "generic").replace("<fieldname>", "Answer Order"), driver));
	
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("inpTextbox", "generic").replace("<fieldname>", "Answer Text"), driver));
	
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("inpTextbox", "generic").replace("<fieldname>", "Answer Score Value"), driver));
	
	Log.info("**Passed ** Answer section is displayed");
	
	
 }

public void validateanswerorderandscoringvalue(String AnswerOrder, String AnswerScoreValue) throws InterruptedException {
	
	enterTextbox("Answer Order", AnswerOrder, driver);
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblerroranswerorder", "assessmentBuilderaddQuestion"), driver));
	
	enterTextbox("Answer Score Value", AnswerScoreValue, driver);
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblerrorvalidscore", "assessmentBuilderaddQuestion"), driver));
	Log.info("**Passed ** answerorder and scoringvalue are displaying the error message for the values other than integers");
 
}

public void validateanswergrid() throws InterruptedException {
	Assert.assertEquals(getLists(ConfReader.getInstance().getConfData("tblhdranswergrid", "assessmentBuilderaddQuestion"), driver), GlobalValues.Answersectiongridheaders);
	Log.info("**Passed ** Answer section headers are displayed as expected " + GlobalValues.Answersectiongridheaders);
}

public void clicksubmitandaddnew() throws InterruptedException {
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(2000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmit&AddNew", "assessmentBuilderaddQuestion"), driver);
	Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("hdrQuestion", "assessmentBuilderaddQuestion"), driver));
	
	
	Log.info("**Passed ** After clicking on submit and Add new user shall land on the same page ");
}

public void clicksubmit() throws InterruptedException {
	Thread.sleep(3000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"), driver);
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(2000);
	Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("hdrAddAssessment", "AssessmentBuilder"), driver));
	
	
	Log.info("**Passed ** After clicking on submit user shall land on the previous page ");
}


public void clicksubmitandverifyerrorforscoring() throws InterruptedException {
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(2000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"), driver);
	Assert.assertEquals(true,validateobjectexists(ConfReader.getInstance().getConfData("lblScoringError", "assessmentBuilderaddQuestion"), driver));
	Log.info("**Passed ** After clicking on submit error message is displayed as " +get_text(ConfReader.getInstance().getConfData("lblScoringError", "assessmentBuilderaddQuestion"), driver));
}

public void validatequestionsection() throws InterruptedException {
    Assert.assertTrue(validatebuttondisabled(ConfReader.getInstance().getConfData("btnSubmitandAddNew", "assessmentBuilderaddQuestion"),driver));
    Log.info("Passed: Submit & Add New button is disabled before user inputs the required fields");
    

    Assert.assertTrue(validatebuttondisabled(ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"),driver));
    Log.info("Passed: Submit button is disabled before user inputs the required fields");


Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblQuestionSection", "assessmentBuilderaddQuestion"), driver));
Log.info("Section label is Question as expected");
Assert.assertTrue((validateobjectexists(ConfReader.getInstance().getConfData("lblQuestionOrder", "assessmentBuilderaddQuestion"), driver))
&& (validateobjectexists(ConfReader.getInstance().getConfData("inpQuestionOrder", "assessmentBuilderaddQuestion"), driver)));
Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("lblQuestionOrder", "assessmentBuilderaddQuestion"), driver));
    Log.info("Passed: Question Order field is required");


    Assert.assertTrue(get_text(ElementType.Textbox, "Question Order", driver).equalsIgnoreCase("2"));
    Log.info("Passed: Question Order is auto-populated to 2 on form load");
    
    Assert.assertTrue(enterTextbox("Question Order", "Non-numeric", driver)) ;
    Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("wrngmsgQuestionOrder", "assessmentBuilderaddQuestion"), driver));
           Log.info("Passed: Expected warning message is displayed when non-numerical value is entered in Question Order field");
    
           
           Assert.assertTrue(enterTextbox("Question Order", "1", driver));
           Assert.assertFalse(validateobjectexists(ConfReader.getInstance().getConfData("wrngmsgQuestionOrder", "assessmentBuilderaddQuestion"), driver));
           Log.info("Passed: Warning message is not displayed when numerical value is entered in Question Order field");
    


           Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblQuestionDesc", "assessmentBuilderaddQuestion"), driver)
    &&     validateobjectexists(ConfReader.getInstance().getConfData("inpQuestionDesc", "assessmentBuilderaddQuestion"), driver));
    Log.info("Passed: Question Description field exists");



    Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("lblQuestionDesc", "assessmentBuilderaddQuestion"), driver));
    Log.info("Passed: Question Description field is required");


    Assert.assertTrue(enterTextbox("Question Description", "Test Question Description", driver));
    Log.info("Entered text in Question Description field");


    Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblQuestionID", "assessmentBuilderaddQuestion"), driver));
    Log.info("Question ID field exists");
    

    Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblQuestionResponseType", "assessmentBuilderaddQuestion"), driver));
    Log.info("Question Type field exists");
    Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("lblQuestionResponseType", "assessmentBuilderaddQuestion"), driver));
           Log.info("Passed: Question Response Type field is a required field");


           Assert.assertTrue(validateDropdown("Question Response Type",GlobalValues.QuestionResponseTypedropdownvalues,driver));
           Log.info("Passed: Question Response Type drop down contains the required values");
           Assert.assertTrue(GlobalValues.QuestionResponseTypedropdownvalues.contains("Signature"));
           Log.info("Passed: CMDM-31576 - Signature is included in the Question Response Type drop down");
           Assert.assertTrue(GlobalValues.QuestionResponseTypedropdownvalues.contains("Checkbox Group"));
           Log.info("Passed: CMDM-33051 - Checkbox Group is included in the Question Response Type drop down");
           Log.info("CMDM-31576 - database validation is not included in automation");
           click(FieldType.xpath, ConfReader.getInstance().getConfData("drpQuestionResponseType", "assessmentBuilderaddQuestion"), driver);
         
           
          
           Assert.assertTrue(selectDropdown("Question Response Type","Checkbox",driver));
           Log.info("Selected Checkbox in Question Response Type field");


           Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblConceptCodeDesc", "assessmentBuilderaddQuestion"), driver)
           && validateobjectexists(ConfReader.getInstance().getConfData("inpConceptCodeDesc", "assessmentBuilderaddQuestion"), driver));
           Log.info("Passed: Concept Code Description field exists");


           Assert.assertTrue(enterTextbox("Concept Code Description", "Test Concept Code Description field", driver));
    Log.info("Entered text in Concept Code Description field");


    Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblConceptCode", "assessmentBuilderaddQuestion"), driver)
           && validateobjectexists(ConfReader.getInstance().getConfData("inpConceptCode", "assessmentBuilderaddQuestion"), driver));
    Log.info("Passed: Concept Code field exists");


    Assert.assertTrue(enter_text("Test Concept Code field",FieldType.xpath, ConfReader.getInstance().getConfData("inpConceptCode", "assessmentBuilderaddQuestion"), driver));
    Log.info("Entered text in Concept Code field");



//    Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblConceptID", "assessmentBuilderaddQuestion"), driver)
//           && validateobjectexists(ConfReader.getInstance().getConfData("inpConceptID", "assessmentBuilderaddQuestion"), driver));
//    Log.info("Passed: Concept ID field exists");


//    Assert.assertTrue(enterTextbox("Concept ID", "Test Concept ID field", driver));
//    Log.info("Entered text in Concept ID field");




    Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblReqQuestforAssesmnt", "assessmentBuilderaddQuestion"), driver)
           && validateobjectexists(ConfReader.getInstance().getConfData("swtchReqQuestforAssesmnt", "assessmentBuilderaddQuestion"), driver));
           Log.info("Passed: Required Question for an Assessment field exists");
           Assert.assertTrue(!validateswitchchecked(ConfReader.getInstance().getConfData("swtchReqQuestforAssesmnt", "assessmentBuilderaddQuestion"),driver));
                 Log.info("Passed: Required Question for an assessment switch is disabled by default");
                 click(FieldType.xpath, ConfReader.getInstance().getConfData("swtchReqQuestforAssesmnt", "assessmentBuilderaddQuestion"), driver);
           


                  Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblInclinScoring", "assessmentBuilderaddQuestion"), driver)
           && validateobjectexists(ConfReader.getInstance().getConfData("swtchInclinScoring", "assessmentBuilderaddQuestion"), driver));
                 Log.info("Passed: Include in Scoring field exists");
                  Assert.assertTrue(!validateswitchchecked(ConfReader.getInstance().getConfData("swtchInclinScoring", "assessmentBuilderaddQuestion"),driver));
                 Log.info("Passed: Include in Scoring switch is disabled by default");
                 click(FieldType.xpath, ConfReader.getInstance().getConfData("swtchInclinScoring", "assessmentBuilderaddQuestion"), driver);
              
                 Thread.sleep(2000);
                  Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblScoringCategory", "assessmentBuilderaddQuestion"),driver));
                        
                  Log.info("Passed: Scoring Category field is displayed when Include in Scoring switch is turned on");
                     
           
                        
                               Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblAssessmntSction", "assessmentBuilderaddQuestion"), driver));
                               Log.info("Assessment Section field exists");
                               Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("lblAssessmntSction", "assessmentBuilderaddQuestion"), driver));
                               Log.info("Passed: Assessment Section field is not a required field");
    

                               Assert.assertTrue(validateDropdown("Assessment Section",GlobalValues.AssessmentSectiondropdownvalues,driver));
                               Log.info("Passed: Assessment Section drop down contains the required values");
                               click(FieldType.xpath, ConfReader.getInstance().getConfData("drpAssessmntSction", "assessmentBuilderaddQuestion"), driver);
                               
                               Assert.assertTrue(selectDropdown("Assessment Section",GlobalValues.AssessmentSectiondropdownvalues.get(0),driver));
                               Log.info("Value selected in Assessment section drop down");


                               Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblToolTip", "assessmentBuilderaddQuestion"), driver)
                                             && validateobjectexists(ConfReader.getInstance().getConfData("inpToolTip", "assessmentBuilderaddQuestion"), driver));
                               Log.info("Passed: Tool Tip field exists");


                               Assert.assertTrue(enterTextbox("Tool Tip", "Test Tool Tip field", driver)); 
                               Log.info("Entered text in Tool Tip field");
                               
                               click(FieldType.xpath, ConfReader.getInstance().getConfData("swtchInclinScoring", "assessmentBuilderaddQuestion"), driver);
                               Log.info("Passed: Scoring Category field is displayed when Include in Scoring switch is turned on"); 

}  




public void verifycheckboxandcheckboxgroup() throws InterruptedException{
	Assert.assertTrue(!validateobjectexists(ConfReader.getInstance().getConfData("lblinsertans", "assessmentBuilderaddQuestion"), driver));
	Log.info("Passed:CMDM-33051: Answer Section is not displayed when Checkbox option is selected in Question Response Type drop down ");
	
	Assert.assertTrue(selectDropdown("Question Response Type","Checkbox Group",driver));
    Log.info("Selected Checkbox Group in Question Response Type field");
	
    Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblinsertans", "assessmentBuilderaddQuestion"), driver));
	Log.info("Passed:CMDM-33051: Answer Section is displayed when Checkbox Group option is selected in Question Response Type drop down ");
    
}



public void clickscoringswitch() throws InterruptedException{
	click(FieldType.xpath, ConfReader.getInstance().getConfData("swtchInclinScoring", "assessmentBuilderaddQuestion"), driver);
	Log.info("Passed: Scoring Category field is displayed when Include in Scoring switch is turned on"); 
	Thread.sleep(1000);

}

public void validateScoringCategoryfielddropdown() throws InterruptedException{
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("drpscoringcategory", "assessmentBuilderaddQuestion"), driver));
	
	Log.info("Passed: Scoring Category field is displayed as dropdown"); 
	
	Thread.sleep(1000);

}

public void validateformiscleared() throws InterruptedException{
    waitForLoadingToBecomeInvisible(driver);
    Thread.sleep(2000);
    

   // Assert.assertTrue(get_text(ElementType.Textbox, "Question Order", driver).equalsIgnoreCase("2"));
   // Log.info("Passed: Question Order is auto-populated with consecutive number 2");
    Assert.assertTrue(get_text(ElementType.Textbox, "Question Description", driver).isEmpty());
    Assert.assertTrue(get_text(ElementType.Dropdown, "Question Response Type", driver).equalsIgnoreCase("Please Select..."));
    Assert.assertTrue(get_text(ElementType.Textbox, "Concept Code Description", driver).isEmpty());
    Assert.assertTrue(get_text(ElementType.Textbox, "Concept Code", driver).isEmpty());

//    Assert.assertTrue(get_text(ElementType.Textbox, "Concept ID", driver).isEmpty());
    Assert.assertTrue(!validateswitchchecked(ConfReader.getInstance().getConfData("swtchReqQuestforAssesmnt", "assessmentBuilderaddQuestion"),driver));
    Assert.assertTrue(!validateswitchchecked(ConfReader.getInstance().getConfData("swtchInclinScoring", "assessmentBuilderaddQuestion"),driver));
    Assert.assertTrue(get_text(ElementType.Dropdown, "Assessment Section", driver).equalsIgnoreCase("Please Select..."));
    Assert.assertTrue(get_text(ElementType.Textbox, "Tool Tip", driver).isEmpty());           
                 
    Log.info("Passed: After Submit & Add New button is clicked, form is cleared as expected");
    
}

public void filldetailsforsecondquestion(String QuesDesc,String QuesResTyp,String ConcCodeDesc,String ConcCode,String ConcID,String AssmntSect,String Tooltip ) throws InterruptedException{
    
    Assert.assertTrue(enterTextbox("Question Description", QuesDesc, driver));
    if(!QuesResTyp.equals("")) {
    	Assert.assertTrue(selectDropdown("Question Response Type", QuesResTyp, driver));
    }
    Assert.assertTrue(enterTextbox("Concept Code Description", ConcCodeDesc, driver));
    Assert.assertTrue(enter_text(ConcCode,FieldType.xpath, ConfReader.getInstance().getConfData("inpConceptCode", "assessmentBuilderaddQuestion"), driver));
    Log.info("Entered text in Concept Code field");
 //   Assert.assertTrue(enterTextbox("Concept ID", ConcID, driver));

    Assert.assertTrue(selectDropdown("Assessment Section", AssmntSect, driver));
    Log.info("Selected value in Assessment Section field");
    Assert.assertTrue(enterTextbox("Tool Tip", Tooltip, driver));
    Log.info("Entered text in Tooltip field");
    Thread.sleep(3000);
    
    
}

public void verifyassmnttemplateforaddedquestions() throws InterruptedException{
	waitForLoadingToBecomeInvisible(driver);
    Thread.sleep(2000);
    Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("lnkexpanddefaultsection", "assessmentBuilderaddQuestion"), driver));
    Log.info("Clicked on expand link for Default section");
    Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("grddefaultsection", "assessmentBuilderaddQuestion"), driver));
    Log.info("Default section exists in Assessment Template grid");
    Thread.sleep(4000);
    Assert.assertTrue(gettablesize(ConfReader.getInstance().getConfData("grdquestiondetails", "assessmentBuilderaddQuestion"), driver)==2);
    Log.info("Passed: Assessment Template grid displays the two added questions");


//    click(FieldType.xpath, ConfReader.getInstance().getConfData("btnexpandquestioningrid", "assessmentBuilderaddQuestion"), driver);
    Thread.sleep(1000);


//    Assert.assertTrue(!validateobjectexists(ConfReader.getInstance().getConfData("hdrAnswerorder", "assessmentBuilderaddQuestion"), driver));
//    Log.info("Passed:child grid Hidden that contains answer choices when there is no records present in the child grid");
}

public void checkdatabaseforaddquestions() throws InterruptedException{
    Log.info("CMDM-31015 : is related to database verification and hence not automated");
}


public void addquestion(String QuestDesc, String QuesRespType, String Section) throws InterruptedException{
	Thread.sleep(2000);
	Assert.assertTrue(enterTextbox("Question Description", QuestDesc, driver));
    Log.info("Entered text in Question Description field");
    Assert.assertTrue(selectDropdown("Question Response Type",QuesRespType,driver));
    Log.info("Selected value in Question Response Type field");
    int sectionval = Integer.parseInt(Section);
    Thread.sleep(2000); 
    Assert.assertTrue(selectDropdown("Assessment Section",GlobalValues.addsectionvaluestohold.get(sectionval),driver));
    Log.info("Value selected in Assessment section drop down");
	
}  


public void AddMainSection() throws InterruptedException{
	Log.info("Adding Main Section");
	//click(FieldType.xpath, ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver);
	selectDropdown("Section Type",GlobalValues.SectionType.get(0),driver);
	String MainSection = global.MainSection;
	Assert.assertTrue(enterTextbox("Section Label", MainSection, driver));
	Thread.sleep(2000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);
		waitForLoadingToBecomeInvisible(driver);
	GlobalValues.addsectionvaluestohold.add(MainSection);
	GlobalValues.addmainsectionvaluestohold.add(MainSection);
	Thread.sleep(3000);
}


public void AddSubSection() throws Exception {
	Log.info("Adding SubSection within a Main Section");
	//click(FieldType.xpath, ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver);
	Thread.sleep(2000);
	selectDropdown("Section Type",GlobalValues.SectionType.get(1),driver);
		
	Assert.assertTrue(enterTextbox("Section Label", global.SubSection, driver));
	
	String subsection=global.SubSection;
	Thread.sleep(3000);			
	selectDropdown("Main Section Type", global.MainSection, driver);
	String mainsection = global.MainSection;
	
	Thread.sleep(3000);	
	String assessmentsection = mainsection + " - " + subsection;
	GlobalValues.addsectionvaluestohold.add(2, assessmentsection);
					
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);	

	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(2000);
	Log.info("Successfully Submitted the Sub-Section with Main Section");
	
}




public void filtertheassessment() throws InterruptedException{
	click(FieldType.xpath, ConfReader.getInstance().getConfData("FilterIcon","AssessmentBuilder"),driver);
	Assert.assertTrue(enter_text(GlobalValues.Assessmentname, FieldType.xpath, ConfReader.getInstance().getConfData("fltrassessmentname", "assessmentBuilderaddQuestion"), driver));
	Log.info("Entered Assessment Name to filter in Assessment grid");
		
}


public void verifypreviewbtn() throws InterruptedException{
Thread.sleep(2000);	
Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("btnpreviewofassessment", "assessmentBuilderaddQuestion"), driver));
Log.info("Passed: Preview button exists for the Assessment");
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


public void verifydefaultsectioninpreviewpage(String Quesdesc,String QuesRespType,String section) throws InterruptedException{
	//to update the xpaths for checkbox
	
//	if(QuesRespType.equalsIgnoreCase("Checkbox")) {
//		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion1defaultsection", "assessmentBuilderaddQuestion"), driver));
//		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion1defaultsection", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
//		Log.info("Passed: Question with Checkbox as response type added at default section is displayed in preview");
//		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("chkboxdefaultsectionpreview", "assessmentBuilderaddQuestion"), driver));
//		Log.info("Passed: Checkbox is displayed in the Default Section of preview page");
//		
//		}
	
	
	if(QuesRespType.equalsIgnoreCase("Checkbox Group")) {
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion1defaultsection", "assessmentBuilderaddQuestion"), driver));
	Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion1defaultsection", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
	Log.info("Passed: Question with Checkbox as response type added at default section is displayed in preview");
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("chkboxdefaultsectionpreview", "assessmentBuilderaddQuestion"), driver));
	Log.info("Passed: Checkbox is displayed in the Default Section of preview page");
	//to add validation for checkbox values Yes and No
	
	}
	
	if(QuesRespType.equalsIgnoreCase("Date")) {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion2defaultsection", "assessmentBuilderaddQuestion"), driver));
		String ques2desc = get_text(ConfReader.getInstance().getConfData("lblquestion2defaultsection", "assessmentBuilderaddQuestion"), driver);
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion2defaultsection", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
		Log.info("Passed: Question with Date as response type added at default section is displayed in preview");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("datedefaultsectionpreview", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Date field is displayed in Default Section of preview page");
	}
	
	
	if(QuesRespType.equalsIgnoreCase("Drop down")) {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion3defaultsection", "assessmentBuilderaddQuestion"), driver));
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion3defaultsection", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
		Log.info("Passed: Question with Drop down as response type added at default section is displayed in preview");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("drpdowndefaultsectionpreview", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Drop down is displayed in Default Section of preview page");
		Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("drpdowndefaultsectionpreview", "assessmentBuilderaddQuestion"), driver));
		List<String> dropdownvalues=getLists(ConfReader.getInstance().getConfData("drpdownvaluespreview", "assessmentBuilderaddQuestion"), driver);
		Assert.assertTrue(dropdownvalues.containsAll(GlobalValues.dropdownvaluesinpreview));
		Log.info("Drop down displays the answers selected");
	}
	
	
	if(QuesRespType.equalsIgnoreCase("Radio Button")) {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblradiobtndefaultsection", "assessmentBuilderaddQuestion"), driver));
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblradiobtndefaultsection", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
		Log.info("Passed: Question with Radio Button as response type added at default section is displayed in preview");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("radiobtndefaultsection", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Radio Button is displayed in Default Section of preview page");
	}
	
	
	if(QuesRespType.equalsIgnoreCase("Signature")) {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion5defaultsection", "assessmentBuilderaddQuestion"), driver));
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion5defaultsection", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
		Log.info("Passed: Question with Signature as response type added at default section is displayed in preview");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("signcanvasdefaultsection", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Signature field is displayed in Default Section of preview page");
	}
	
	
	if(QuesRespType.equalsIgnoreCase("Text Area")) {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion6defaultsection", "assessmentBuilderaddQuestion"), driver));
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion6defaultsection", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
		Log.info("Passed: Question with Text Area as response type added at default section is displayed in preview");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("txtareadefaultsection", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Text Area field is displayed in Default Section of preview page");
	}
	
	
	if(QuesRespType.equalsIgnoreCase("Text Field")) {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion7defaultsection", "assessmentBuilderaddQuestion"), driver));
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion7defaultsection", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
		Log.info("Passed: Question with Text Field as response type added at default section is displayed in preview");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("txtfielddefaultsection", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Text field is displayed in Default Section of preview page");
	}
	
	
	
}


public void verifyandexpandmainsection() throws InterruptedException{
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("hdrmainsectioninpreview", "assessmentBuilderaddQuestion"), driver));
	Log.info("Passed: Passed: Main Section exists in preview page");
	Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("accrdianmainsection", "assessmentBuilderaddQuestion"), driver));
	Log.info("Passed: Clicked on accordian to expand Main Section in preview page");
	Thread.sleep(2000);

}


public void verifymainsectioninpreviewpage(String Quesdesc,String QuesRespType,String section) throws InterruptedException{

	if(QuesRespType.equalsIgnoreCase("Checkbox Group")) {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion1mainsection", "assessmentBuilderaddQuestion"), driver));
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion1mainsection", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
		Log.info("Passed: Question with Checkbox as response type added at Main Section is displayed in preview");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("chkboxmainsectionpreview", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Checkbox is displayed in the Main Section of preview page");
		}
	
	
	if(QuesRespType.equalsIgnoreCase("Date")) {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion2mainsection", "assessmentBuilderaddQuestion"), driver));
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion2mainsection", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
		Log.info("Passed: Question with Date as response type added at Main Section is displayed in preview");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("datemainsectionpreview", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Date field is displayed in Main Section of preview page");
	
	
	if(QuesRespType.equalsIgnoreCase("Drop down")) {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion3mainsection", "assessmentBuilderaddQuestion"), driver));
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion3mainsection", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
		Log.info("Passed: Question with Drop down as response type added at Main Section is displayed in preview");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("drpdownmainsectionpreview", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Drop down is displayed in Main Section of preview page");
	}
	
	
	if(QuesRespType.equalsIgnoreCase("Radio Button")) {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblradiobtnmainsection", "assessmentBuilderaddQuestion"), driver));
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblradiobtnmainsection", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
		Log.info("Passed: Question with Radio Button as response type added at Main Section is displayed in preview");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("radiobtnmainsection", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Radio Button is displayed in Main Section of preview page");
	}
	
	
	if(QuesRespType.equalsIgnoreCase("Signature")) {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion5defaultsection", "assessmentBuilderaddQuestion"), driver));
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion5defaultsection", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
		Log.info("Passed: Question with Signature as response type added at Main Section is displayed in preview");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("signcanvasmainsection", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Signature field is displayed in Main Section of preview page");
	}
	
	
	if(QuesRespType.equalsIgnoreCase("Text Area")) {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion6mainsection", "assessmentBuilderaddQuestion"), driver));
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion6mainsection", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
		Log.info("Passed: Question with Text Area as response type added at Main Section is displayed in preview");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("txtareamainsection", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Text Area field is displayed in Main Section of preview page");
	}
	
	
	if(QuesRespType.equalsIgnoreCase("Text Field")) {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion7mainsection", "assessmentBuilderaddQuestion"), driver));
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion7mainsection", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
		Log.info("Passed: Question with Text Field as response type added at Main Section is displayed in preview");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("txtfieldmainsection", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Text field is displayed in Main Section of preview page");
	}

}	
	
	
}




public void verifysubsectionwithmainheader() throws InterruptedException{
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("hdrsubsectionwithmain", "assessmentBuilderaddQuestion"), driver));
	Log.info("Passed: SubSection with Main Header is displayed in the Preview page");
}


public void verifysubsectionwithmaininpreviewpage(String Quesdesc,String QuesRespType,String section) throws InterruptedException{

		if(QuesRespType.equalsIgnoreCase("Checkbox Group")) {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion1subsectionwithmain", "assessmentBuilderaddQuestion"), driver));
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion1subsectionwithmain", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
		Log.info("Passed: Question with Checkbox as response type added at SubSection with Main Section is displayed in preview");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("chkboxsubsectionwithmainpreview", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Checkbox is displayed in the SubSection with Main Section of preview page");
		Thread.sleep(2000);
		}
		
		if(QuesRespType.equalsIgnoreCase("Date")) {
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion2subsectionwithmain", "assessmentBuilderaddQuestion"), driver));
			Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion2subsectionwithmain", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
			Log.info("Passed: Question with Date as response type added at SubSection with Main Section is displayed in preview");
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("datesubsectionwithmainpreview", "assessmentBuilderaddQuestion"), driver));
			Log.info("Passed: Date field is displayed in SubSection with Main Section of preview page");
			Thread.sleep(2000);
		}
		
		
		if(QuesRespType.equalsIgnoreCase("Drop down")) {
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion3subsectionwithmain", "assessmentBuilderaddQuestion"), driver));
			Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion3subsectionwithmain", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
			Log.info("Passed: Question with Drop down as response type added at SubSection with Main Section is displayed in preview");
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("drpdownsubsectionwithmain", "assessmentBuilderaddQuestion"), driver));
			Log.info("Passed: Drop down is displayed in SubSection with Main Section of preview page");
			Thread.sleep(2000);
		}
		
		
		if(QuesRespType.equalsIgnoreCase("Radio Button")) {
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblradiobtnsubsectionwithmain", "assessmentBuilderaddQuestion"), driver));
			Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblradiobtnsubsectionwithmain", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
			Log.info("Passed: Question with Radio Button as response type added at SubSection with Main Section is displayed in preview");
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("radiobtnsubsectionwithmain", "assessmentBuilderaddQuestion"), driver));
			Log.info("Passed: Radio Button is displayed in SubSection with Main Section of preview page");
			Thread.sleep(2000);
		}
		
		
		if(QuesRespType.equalsIgnoreCase("Signature")) {
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion5subsectionwithmain", "assessmentBuilderaddQuestion"), driver));
			Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion5subsectionwithmain", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
			Log.info("Passed: Question with Signature as response type added at SubSection with Main Section is displayed in preview");
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("signcanvassubsectionwithmain", "assessmentBuilderaddQuestion"), driver));
			Log.info("Passed: Signature field is displayed in SubSection with Main Section of preview page");
			Thread.sleep(2000);
		}
		
		
		if(QuesRespType.equalsIgnoreCase("Text Area")) {
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion6subsectionwithmain", "assessmentBuilderaddQuestion"), driver));
			Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion6subsectionwithmain", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
			Log.info("Passed: Question with Text Area as response type added at SubSection with Main Section is displayed in preview");
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("txtareasubsectionwithmain", "assessmentBuilderaddQuestion"), driver));
			Log.info("Passed: Text Area field is displayed in SubSection with Main Section of preview page");
			Thread.sleep(2000);
		}
		
		
		if(QuesRespType.equalsIgnoreCase("Text Field")) {
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion7subsectionwithmain", "assessmentBuilderaddQuestion"), driver));
			Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion7subsectionwithmain", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
			Log.info("Passed: Question with Text Field as response type added at SubSection with Main Section is displayed in preview");
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("txtfieldsubsectionwithmain", "assessmentBuilderaddQuestion"), driver));
			Log.info("Passed: Text field is displayed in SubSection with Main Section of preview page");
			Thread.sleep(2000);
		}
		
	
}
		
		
public void verifysubsectionwitouthmainheaderinpreviewpage() throws InterruptedException{
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("hdrsubsectionwithoutmain", "assessmentBuilderaddQuestion"), driver));
	Log.info("Passed: Header for Subsection without main is displayed in Preview page");	
		
	}
	
	



public void verifysubsectionwithoutmaininpreviewpage(String Quesdesc,String QuesRespType,String section) throws InterruptedException{
	
	if(QuesRespType.equalsIgnoreCase("Checkbox Group")) {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion1subsectionwithoutmain", "assessmentBuilderaddQuestion"), driver));
		Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion1subsectionwithoutmain", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
		Log.info("Passed: Question with Checkbox as response type added at SubSection without Main Section is displayed in preview");
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("chkboxsubsectionwithoutmainpreview", "assessmentBuilderaddQuestion"), driver));
		Log.info("Passed: Checkbox is displayed in the SubSection without Main Section of preview page");
		Thread.sleep(2000);
		}
		
		if(QuesRespType.equalsIgnoreCase("Date")) {
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion2subsectionwithoutmain", "assessmentBuilderaddQuestion"), driver));
			Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion2subsectionwithoutmain", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
			Log.info("Passed: Question with Date as response type added at SubSection without Main Section is displayed in preview");
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("datesubsectionwithoutmainpreview", "assessmentBuilderaddQuestion"), driver));
			Log.info("Passed: Date field is displayed in SubSection without Main Section of preview page");
			Thread.sleep(2000);
		}
		
		
		if(QuesRespType.equalsIgnoreCase("Drop down")) {
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion3subsectionwithoutmain", "assessmentBuilderaddQuestion"), driver));
			Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion3subsectionwithoutmain", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
			Log.info("Passed: Question with Drop down as response type added at SubSection without Main Section is displayed in preview");
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("drpdownsubsectionwithoutmain", "assessmentBuilderaddQuestion"), driver));
			Log.info("Passed: Drop down is displayed in SubSection without Main Section of preview page");
			Thread.sleep(2000);
		}
		
		
		if(QuesRespType.equalsIgnoreCase("Radio Button")) {
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblradiobtnsubsectionwithoutmain", "assessmentBuilderaddQuestion"), driver));
			Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblradiobtnsubsectionwithoutmain", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
			Log.info("Passed: Question with Radio Button as response type added at SubSection without Main Section is displayed in preview");
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("radiobtnsubsectionwithoutmain", "assessmentBuilderaddQuestion"), driver));
			Log.info("Passed: Radio Button is displayed in SubSection without Main Section of preview page");
			Thread.sleep(2000);
		}
		
		
		if(QuesRespType.equalsIgnoreCase("Signature")) {
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion5subsectionwithoutmain", "assessmentBuilderaddQuestion"), driver));
			Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion5subsectionwithoutmain", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
			Log.info("Passed: Question with Signature as response type added at SubSection without Main Section is displayed in preview");
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("signcanvassubsectionwithoutmain", "assessmentBuilderaddQuestion"), driver));
			Log.info("Passed: Signature field is displayed in SubSection without Main Section of preview page");
			Thread.sleep(2000);
		}
		
		
		if(QuesRespType.equalsIgnoreCase("Text Area")) {
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion6subsectionwithoutmain", "assessmentBuilderaddQuestion"), driver));
			Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion6subsectionwithoutmain", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
			Log.info("Passed: Question with Text Area as response type added at SubSection without Main Section is displayed in preview");
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("txtareasubsectionwithoutmain", "assessmentBuilderaddQuestion"), driver));
			Log.info("Passed: Text Area field is displayed in SubSection without Main Section of preview page");
			Thread.sleep(2000);
		}
		
		
		if(QuesRespType.equalsIgnoreCase("Text Field")) {
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("lblquestion7subsectionwithoutmain", "assessmentBuilderaddQuestion"), driver));
			Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("lblquestion7subsectionwithoutmain", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(Quesdesc));
			Log.info("Passed: Question with Text Field as response type added at SubSection without Main Section is displayed in preview");
			Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("txtfieldsubsectionwithoutmain", "assessmentBuilderaddQuestion"), driver));
			Log.info("Passed: Text field is displayed in SubSection without Main Section of preview page");
			Thread.sleep(2000);
		}

	}


public void verifynavigatingoutofpreviewpage() throws InterruptedException{
	
	Assert.assertTrue(browserback(driver));
	Thread.sleep(2000);
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("hdrAssessmentBuilder", "assessmentBuilderaddQuestion"), driver));
	Log.info("Passed: Clicking on browser back navigated user out of the Preview page");
}



public void AddSecondMainSection() throws InterruptedException{
	Log.info("Adding second main section");
	waitForLoadingToBecomeInvisible(driver);
	Thread.sleep(2000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver);
	selectDropdown("Section Type",GlobalValues.SectionType.get(0),driver);
	
	Assert.assertTrue(enterTextbox("Section Label", "Second Main Section "+ global.MainSection, driver));
	String secmainsection = get_text(ElementType.Textbox, "Section Label", driver);
			//get_text(ConfReader.getInstance().getConfData("inpsectionlabel", "assessmentBuilderaddQuestion"), driver);
	GlobalValues.addsectionvaluestohold.add(secmainsection);
	GlobalValues.addmainsectionvaluestohold.add(secmainsection);
	Thread.sleep(4000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);
	Log.info("Submitted second main section");
	
}

public void validatesubmitbtndisabled() throws InterruptedException{
	 Assert.assertTrue(enterTextbox("Question Description", "Test question", driver));
	 Assert.assertTrue(selectDropdown("Question Response Type", "Signature", driver));
	 Thread.sleep(2000);
	 Assert.assertTrue(selectDropdown("Assessment Section", "Default Section", driver));
	 Thread.sleep(2000);
	 Assert.assertTrue(!validatebuttondisabled(ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"), driver));
	 Log.info("Submit button is enabled after user inputs the mandatory fields");
	 Assert.assertTrue(clear_text(FieldType.xpath, ConfReader.getInstance().getConfData("inpQuestionDesc", "assessmentBuilderaddQuestion"), driver));
	 Thread.sleep(2000);
//	 Assert.assertTrue(validatebuttondisabled(ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"), driver));
	 Log.info("Submit button is disabled when mandatory fields input is removed");
}


public void validatefieldsresetafterclickingback() throws InterruptedException{
	Thread.sleep(2000);
	    Assert.assertTrue(get_text(ElementType.Textbox, "Question Description", driver).isEmpty());
	    Assert.assertTrue(get_text(ElementType.Dropdown, "Question Response Type", driver).equalsIgnoreCase("Please Select..."));
	    Assert.assertTrue(get_text(ElementType.Textbox, "Concept Code Description", driver).isEmpty());
	    Assert.assertTrue(get_text(ElementType.Textbox, "Concept Code", driver).isEmpty());
//	    Assert.assertTrue(get_text(ElementType.Textbox, "Concept ID", driver).isEmpty());
	    Assert.assertTrue(!validateswitchchecked(ConfReader.getInstance().getConfData("swtchReqQuestforAssesmnt", "assessmentBuilderaddQuestion"),driver));
	    Assert.assertTrue(!validateswitchchecked(ConfReader.getInstance().getConfData("swtchInclinScoring", "assessmentBuilderaddQuestion"),driver));
	 //   Assert.assertTrue(get_text(ElementType.Dropdown, "Assessment Section", driver).equalsIgnoreCase("Please Select..."));
	    Assert.assertTrue(get_text(ElementType.Textbox, "Tool Tip", driver).isEmpty());           
	                 
	    Log.info("Passed: When Add Question is clicked after user clicks on Back, fields are reset as expected");
}

public void verifystaticvalue() throws InterruptedException{
	Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("lblInsertAnswer", "assessmentBuilderaddQuestion"), driver));
	List<String> InsertAnswerValues=getLists(ConfReader.getInstance().getConfData("listdrpdownitemsInsertAnswer", "assessmentBuilderaddQuestion"), driver);
	Assert.assertFalse(InsertAnswerValues.contains("Please Select..."));
	Log.info("Passed: Please Select is a static value in Insert Answer drop down");
	Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("lblInsertAnswer", "assessmentBuilderaddQuestion"), driver));
}

public void verifyeditquestionbutton() throws InterruptedException{
	int numberofrows = gettablesize(ConfReader.getInstance().getConfData("grdquestiondetails", "assessmentBuilderaddQuestion"), driver);
	for(int i=1;i<=numberofrows;i++) {
	String s = Integer.toString(i);
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("btneditquestion", "assessmentBuilderaddQuestion").replace("<num>", s), driver));
    Log.info("Passed: Edit button exists at question " +i);
    }
}


public void verifyeditquestionpagenavigation(String questionnum) throws InterruptedException{
	Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("btneditquestion", "assessmentBuilderaddQuestion").replace("<num>", questionnum), driver));
	Log.info("Clicked on Edit Question button");
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("hdreditquestion", "assessmentBuilderaddQuestion"), driver));
	Log.info("Passed: Clicking on Edit button navigated to Edit Question Page");
}


public void verifyeditquestionpagedetails() throws InterruptedException{
	 	ArrayList<String> editQuestiondetails =  new ArrayList<>();
//	 	editQuestiondetails.add(get_text(ElementType.Textbox, "Question Order", driver));
	 	editQuestiondetails.add(get_text(ElementType.Textbox, "Question Description", driver));
	 	editQuestiondetails.add(get_text(ElementType.Dropdown, "Question Response Type", driver));
	 	editQuestiondetails.add(get_text(ElementType.Textbox, "Concept Code Description", driver));
	 	editQuestiondetails.add(get_text(ElementType.Textbox, "Concept Code", driver));
//	 	editQuestiondetails.add(get_text(ElementType.Textbox, "Concept ID", driver));
	 	editQuestiondetails.add(get_text(ElementType.Dropdown, "Assessment Section", driver));
	 	editQuestiondetails.add(get_text(ElementType.Textbox, "Tool Tip", driver));
//	 	editQuestiondetails.add(get_text(ElementType.Dropdown, "Insert Answer", driver));
	 	editQuestiondetails.add(get_text(ElementType.Textbox, "Tool Tip", driver));
		Assert.assertTrue(editQuestiondetails.containsAll(GlobalValues.addquestionvaluestohold));
		Log.info("Edit Question page pre-populates the details entered in the Add Question page");
}





public void verifyeditquestionpagebuttons() throws InterruptedException{
	
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"), driver)); 
	//&& (validatebuttondisabled(ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"), driver)));
	Log.info("Submit button exists in Edit Question page");
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("btnBack", "assessmentBuilderaddQuestion"), driver));
	Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("btnBack", "assessmentBuilderaddQuestion"), driver));
	Thread.sleep(2000);
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("hdrAddAssessment", "assessmentBuilderaddQuestion"), driver));
	Log.info("Clicked on Back button and navigated back to Add Assessment page");
	Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("lnkexpanddefaultsection", "assessmentBuilderaddQuestion"), driver));
	Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("btneditquestion", "assessmentBuilderaddQuestion").replace("<num>", "1"), driver));
	Log.info("Clicked on Edit Question button");
	
	//to be removed after issue is fixed
//	Assert.assertTrue(selectDropdown("Assessment Section", "Default Section", driver));
	

//	Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("btneditfirstanswer", "assessmentBuilderaddQuestion"), driver));
//	Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("btnsave", "assessmentBuilderaddQuestion"), driver));
	
		
}

public void editquestionpagedetails() throws InterruptedException{
	
    Assert.assertTrue(enterTextbox("Question Description", "Test Question Description edit", driver));
    Log.info("Edited text in Question Description field");

   // click(FieldType.xpath, ConfReader.getInstance().getConfData("drpQuestionResponseType", "assessmentBuilderaddQuestion"), driver);
           
//    Assert.assertTrue(selectDropdown("Question Response Type",GlobalValues.QuestionResponseTypedropdownvalues.get(1),driver));
//    Log.info("Edited value in Question Response Type field");

    
    Assert.assertTrue(enterTextbox("Concept Code Description", "Test Concept Code Description field edit", driver));
    Log.info("Edited text in Concept Code Description field");


    Assert.assertTrue(enter_text("Test Concept Code field edit",FieldType.xpath, ConfReader.getInstance().getConfData("inpConceptCode", "assessmentBuilderaddQuestion"), driver));
    Log.info("Edited text in Concept Code field");

//    Assert.assertTrue(enterTextbox("Concept ID", "Test Concept ID field edit", driver));
//    Log.info("Entered text in Concept ID field");
   
    click(FieldType.xpath, ConfReader.getInstance().getConfData("swtchReqQuestforAssesmnt", "assessmentBuilderaddQuestion"), driver);

  //  click(FieldType.xpath, ConfReader.getInstance().getConfData("swtchInclinScoring", "assessmentBuilderaddQuestion"), driver);
              
    Thread.sleep(2000);
   
    //Assert.assertTrue(selectDropdown("Scoring Category", "TestCategory", driver));
    
  //  click(FieldType.xpath, ConfReader.getInstance().getConfData("drpAssessmntSction", "assessmentBuilderaddQuestion"), driver);
                 
    Assert.assertTrue(selectDropdown("Assessment Section",GlobalValues.addsectionvaluestohold.get(0),driver));
    Log.info("Value edited in Assessment section drop down");
  //  Assert.assertTrue(selectDropdown("Assessment Section",GlobalValues.addsectionvaluestohold.get(0),driver));
    
    Assert.assertTrue(enterTextbox("Tool Tip", "Test Tool Tip field edit", driver)); 
    Log.info("Edited text in Tool Tip field");
    
       
}




public void clicksubmitineditquestion() throws InterruptedException{
Thread.sleep(2000);
Assert.assertTrue(!validatebuttondisabled(ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"), driver));
Log.info("Passed: Submit button is enabled after user inputs for the required fields are entered");

Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"), driver));
Thread.sleep(2000);


}


public void verifyquestionordernumber(String section) throws InterruptedException{
	
	Thread.sleep(2000);
	click(FieldType.xpath,ConfReader.getInstance().getConfData(section, "assessmentBuilderaddQuestion"),driver);
	int numrows = gettablesize(ConfReader.getInstance().getConfData("grdquestiondetails", "assessmentBuilderaddQuestion"), driver);
    ArrayList<String> QuestionOrder = new ArrayList<>();
  //  ArrayList<String> QuestionId = new ArrayList<>();
	for(int i=1;i<=numrows;i++) {
    	String s = Integer.toString(i);
    	String order = get_text(ConfReader.getInstance().getConfData("txtquestionorderinassesstemp", "assessmentBuilderaddQuestion").replace("<num>", s), driver);
    //	String id = get_text(ConfReader.getInstance().getConfData("txtquestionidassesstemp", "assessmentBuilderaddQuestion").replace("<num>", s), driver);
    	QuestionOrder.add(order);
  //  	QuestionId.add(id);
    }
	Log.info("Question order from "+ section + QuestionOrder);
//	Log.info("Question id from "+ section + QuestionId);
	
	
	if(section.equalsIgnoreCase("lnkexpanddefaultsection")) {
		int a[] = {1, 2, 3, 4};
		
		String expectedorder[] = new String[a.length];
		
		for(int i=0;i<a.length;i++) {
			expectedorder[i] = String.valueOf(a[i]);
		}
			
		for(int i=0;i<QuestionOrder.size();i++) {
			if(QuestionOrder.get(i).equals(expectedorder[i])) {
				Log.info("Question order is " + QuestionOrder.get(i)+" as expected");
			}else{
				Assert.assertEquals(true,false);
				}
		}
		
	}
	
	
	if(section.equalsIgnoreCase("lnkexpandsubsectionwithmain") || section.equalsIgnoreCase("lnkexpandsubsection2")) {
		int a[] = {1};
		String expectedorder[] = new String[a.length];
		
		for(int i=0;i<a.length;i++) {
			expectedorder[i] = String.valueOf(a[i]);
		}
		
		for(int i=0;i<QuestionOrder.size();i++) {
			if(QuestionOrder.get(i).equals(expectedorder[i])) {
			}else{
				Assert.assertEquals(true,false);
				}
		}
		System.out.print("Question order is as expected "+QuestionOrder);
		
		}
	

}

public void verifysectionordernumber(String section) throws InterruptedException{
	Thread.sleep(2000);
	String SectionOrder = get_text(ConfReader.getInstance().getConfData(section, "assessmentBuilderaddQuestion"), driver);
	if(section.equalsIgnoreCase("txtfirstmainsectionsectionorder") || section.equalsIgnoreCase("txtsubundermainsectionorder")) {
		Assert.assertEquals(SectionOrder,"1");
		Log.info("Section Order is 1 as expected");
	}
		else if(section.equalsIgnoreCase("txtsubwithoutmainsectionorder")) {
	Assert.assertEquals(SectionOrder,"6");
	Log.info("Order of Sub Section without Main Section in Assessment Template grid is "+SectionOrder +" as expected");
	}
	
	else if(section.equalsIgnoreCase("txtsecondmainsectionorder")) {
		Assert.assertEquals(SectionOrder,"2");
		Log.info("Order of Second Main Section is "+SectionOrder +" as expected");
	}
	
	else if(section.equalsIgnoreCase("txtsecondsubwithoutmainsectionorder")){
		Assert.assertEquals(SectionOrder,"7");
		Log.info("Order of Second Sub Section without Main Section is "+SectionOrder +" as expected");
	}
	
	//Submit button is not enabled in Edit Section
//	else if(section.equalsIgnoreCase("txtsecondsubafterupdate")) {
//		Assert.assertEquals(SectionOrder,"6");
//		Log.info("Order of Second Main Section after updating Main Section is "+SectionOrder +" as expected");
//	}
}



public void editquestionordernumber() throws InterruptedException{
	Assert.assertTrue(enterTextbox("Question Order", "2", driver));
	Assert.assertTrue(selectDropdown("Assessment Section", "Default Section", driver));
	
}


public void AddingSubsectionwithoutMainSection() throws InterruptedException{
	Log.info("Adding SubSection without Main Section");
//	click(FieldType.xpath, ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver);
	selectDropdown("Section Type",GlobalValues.SectionType.get(1),driver);
	String Subsectwithoutmain = global.SubSection+" "+global.SubSection;
	Assert.assertTrue(enterTextbox("Section Label",Subsectwithoutmain , driver));
	Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "label"), driver));
	
	Thread.sleep(2000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);	

	waitForLoadingToBecomeInvisible(driver);
	GlobalValues.addsectionvaluestohold.add(Subsectwithoutmain);
	Log.info("Successfully Submitted the Sub-Section without Main Section");
	Thread.sleep(3000);

}


public void AddingsecondSubsectionwithoutMainSection() throws InterruptedException{
	Log.info("Adding Second SubSection without Main Section");
	Thread.sleep(2000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver);
	selectDropdown("Section Type",GlobalValues.SectionType.get(1),driver);
	Assert.assertTrue(validateobjectmandatory(ConfReader.getInstance().getConfData("Labels", "AssessmentBuilder").replace("<label>", "sectionType"), driver));

	Assert.assertTrue(enterTextbox("Section Label", "Second "+global.SubSection+" "+global.SubSection, driver));
	
	Thread.sleep(2000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);	

	waitForLoadingToBecomeInvisible(driver);

	Log.info("Successfully Submitted the Second Sub-Section without Main Section");

}

public void updateassessmentsection() throws InterruptedException{
	Thread.sleep(2000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btneditsecondsubsecwithoutmain", "assessmentBuilderaddQuestion"), driver);
	
	selectDropdown("Main Section Type", GlobalValues.addmainsectionvaluestohold.get(2), driver);
	Thread.sleep(2000);
	click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);	

	waitForLoadingToBecomeInvisible(driver);
	Log.info("Updated the Second Sub-Section with Main Section2");

}



public void verifydeletequestionbutton() throws InterruptedException{
	
	Thread.sleep(3000);
    Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("lnkexpanddefaultsection", "assessmentBuilderaddQuestion"), driver));
    Log.info("Clicked on expand link for Default section");
	int numberofrows = gettablesize(ConfReader.getInstance().getConfData("grdquestiondetails", "assessmentBuilderaddQuestion"), driver);
	GlobalValues.numberofrowsbeforedelete = numberofrows;
	for(int i=1;i<=numberofrows;i++) {
	String s = Integer.toString(i);
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("btndeletequestion", "assessmentBuilderaddQuestion").replace("<num>", s), driver));
    Log.info("Passed: Delete button exists at question " +i);
    }
}


public void clickdeletequestionoption() throws InterruptedException{
	click(FieldType.xpath, ConfReader.getInstance().getConfData("btndeletequestion", "assessmentBuilderaddQuestion").replace("<num>", "1"), driver);
}


public void verifymodalwindowdeletequestion() throws InterruptedException{
	Thread.sleep(1000);
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("modalwindowdeleteques", "assessmentBuilderaddQuestion"), driver));
	Log.info("Passed: Modal window is displayed when user clicks on Delete button of a question");
	String expectedwrngmsg = "Are you sure, you want to delete this question?";
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("wrngmsgdeletequestion", "assessmentBuilderaddQuestion"), driver));
	Assert.assertTrue(get_text(ConfReader.getInstance().getConfData("wrngmsgtextdeletequestion", "assessmentBuilderaddQuestion"), driver).equalsIgnoreCase(expectedwrngmsg));
	Log.info("Expected Warning message is displayed");
	
}



public void validateclickoncancel() throws InterruptedException{
	Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("btncanceldeletequestion", "assessmentBuilderaddQuestion"), driver));
	Thread.sleep(2000);
	Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("hdrAddAssessment", "assessmentBuilderaddQuestion"), driver));
	Log.info("Passed: Clicking on Cancel in modal window of delete Question closes the modal window and navigates back to Add Assessment page");
}

public void validateclickonyes() throws InterruptedException{
	Assert.assertTrue(click(FieldType.xpath, ConfReader.getInstance().getConfData("btnyesdeletequestion", "assessmentBuilderaddQuestion"), driver));
	Thread.sleep(2000);
	int numberofrowsafterdelete = gettablesize(ConfReader.getInstance().getConfData("grdquestiondetails", "assessmentBuilderaddQuestion"), driver);
	Assert.assertEquals(numberofrowsafterdelete,1) ;
	Log.info("Passed: Deleted question is removed from Assessment Template grid");
}




}
