package com.adminbuilder.Pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.configutility.ConfReader;

public class AssessmentBuilderLinktoTask extends WebAction{
	
	WebAction webaction;
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("AssessmentBuilderLinktoTask.class");
	GlobalValues global = new GlobalValues();
	AssessmentBuilder assessmentbuilder;
	
	public AssessmentBuilderLinktoTask(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	
	public void validateLinktoTaskpage() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		
		Log.info("Link to Task Page" );
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("hdrAssessmentLinkingtoTasks", "AssessmentBuilderLinktoTask"), driver));
		
		Log.info("Header AssessmentLinkingtoTasks is displayed" );
		
		Assert.assertEquals(GlobalValues.Assessmentname, get_text(ConfReader.getInstance().getConfData("lblAssessmentnamevalue", "AssessmentBuilderLinktoTask"), driver));
		Log.info("Assessment Name value is auto populated" );
		
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("inpDropdown", "generic").replace("<fieldname>", "Tasks"), driver));
		Log.info("Tasks dropdown is displayed" );
		
		Assert.assertTrue(validatebuttondisabled(ConfReader.getInstance().getConfData("btnAdd", "assessmentBuilderaddQuestion"), driver));
		Log.info("Add button is disabled" );
		
		Assert.assertTrue(!(validatebuttondisabled(ConfReader.getInstance().getConfData("btnSubmit", "assessmentBuilderaddQuestion"), driver)));
		Log.info("Submit button is Enabled" );
		
		Assert.assertTrue(!(validatebuttondisabled(ConfReader.getInstance().getConfData("btnBack", "assessmentBuilderaddQuestion"), driver)));
		Log.info("Back is displayed" );
		
		
	 }
	
	public void validateaddbuttonenabled(String Task) throws InterruptedException {
		
		selectDropdown("Tasks", Task, driver);
		Thread.sleep(1000);
		Assert.assertTrue(!(validatebuttondisabled(ConfReader.getInstance().getConfData("btnAdd", "assessmentBuilderaddQuestion"), driver)));
		Log.info("Add button is enabled" );
	}
	
	public void clickadd() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(1000);		
		click(FieldType.xpath,ConfReader.getInstance().getConfData("btnAdd", "assessmentBuilderaddQuestion"), driver);
		Log.info("Add button is enabled" );
		waitForLoadingToBecomeInvisible(driver);
	}
	
	public void validatetaskstableheaders() throws InterruptedException {
		
		Assert.assertEquals(getLists(ConfReader.getInstance().getConfData("tblhdranswergrid", "assessmentBuilderaddQuestion"), driver), GlobalValues.LinktoTasksgrid);
		Log.info("tasks table headers are displayed and verified" +getLists(ConfReader.getInstance().getConfData("tblhdranswergrid", "assessmentBuilderaddQuestion"), driver));		
	}

	public void validatedeletebutton() throws InterruptedException {
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("btndeleterecentrow", "assessmentBuilderaddQuestion"), driver));
		Log.info("Delete button in the grid is displayed ");
	}
	
	public void enabletogglebutton() throws InterruptedException {
		click(FieldType.xpath, ConfReader.getInstance().getConfData("swthAssessmentForm", "AssessmentBuilderLinktoTask"), driver);
		Thread.sleep(2000);
		Assert.assertTrue(validateswitchchecked(ConfReader.getInstance().getConfData("swthAssessmentFormcheck", "AssessmentBuilderLinktoTask"), driver));
		Log.info("AssessmentForm Switch on and validated ");
	}
	
	public void getrownumberfromgrid() throws InterruptedException {
		GlobalValues.rownumber=getLists(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"), driver).size();
	}
	
	public void validaterownumberfromgrid() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		int i=getLists(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"), driver).size();
		Assert.assertEquals(i, GlobalValues.rownumber);
		Log.info("When the user clicked on back button the task did not get saved to assessment ");
	}

	public void validatetabledata(String Task, String Required) throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		ArrayList<String> tableData =getrecentaddedformfromtable(ConfReader.getInstance().getConfData("tblanswer", "assessmentBuilderaddQuestion"), new ArrayList<>(), driver);
		Thread.sleep(3000);
		Log.info("Values present in the table are " +tableData);
		Assert.assertEquals(Task, tableData.get(0));
		Log.info("Task is populated with the information provided by the user ");
		Assert.assertEquals(Required, tableData.get(1));	
		Log.info("Required field is populated with the information provided by the user ");
		
		Assert.assertEquals(getcurrentdate("MM/dd/YYYY", driver), tableData.get(2));	
		Log.info("Linked Date is populated with the information provided by the user ");
		waitForLoadingToBecomeInvisible(driver);
		tableData.clear();

	}
	
	public void validateduplicateTaskdropdown() throws InterruptedException {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(2000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("drpTasks", "AssessmentBuilderLinktoTask"), driver);
		Thread.sleep(1000);
		ArrayList<String> tableData = getLists(ConfReader.getInstance().getConfData("drpvaluesTasks", "AssessmentBuilderLinktoTask"), driver);
		int size = tableData.size();
		Assert.assertEquals(size, getuniqueLists(ConfReader.getInstance().getConfData("drpvaluesTasks", "AssessmentBuilderLinktoTask"), driver).size());
		Log.info("The values in Tasks dropdown are unique");
		
	}
	

}
