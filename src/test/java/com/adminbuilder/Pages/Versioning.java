package com.adminbuilder.Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.baseutility.WebAction.ElementType;
import com.adminbuilder.configutility.ConfReader;

public class Versioning extends WebAction{
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("Versioning.class");
	GlobalValues global = new GlobalValues();
	MenuNavigation leftnavigation;
	String AssessmentName = global.Assessment;
	
	public Versioning(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	
	public void ClickExpandRow() throws Exception {
		waitForLoadingToBecomeInvisible(driver);
		Assert.assertTrue(validateobjectexists(ConfReader.getInstance().getConfData("TempalteGridExpandRow", "Versioning"), driver));
		Thread.sleep(4000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("TempalteGridExpandRow", "Versioning").replace("<AssName>", AssessmentName), driver);
		
		Log.info("Verified and Clicked on Asssessment template grid secondary row");
		
	}
	
	public void VersioningGrid() throws Exception {
	
		waitForLoadingToBecomeInvisible(driver);
		
		String header = get_text(ConfReader.getInstance().getConfData("VersioningHeader", "Versioning"), driver);
		assertEquals(header, "Previously Published Version");
		Log.info("Verified the versioning grid header - " +header);
		
		for(int i=0;i<GlobalValues.VersioningGrid.size();i++) {
			driver.findElement(By.xpath("//nm-table[@id='publishList']/..//span//nm-th[text()='"+GlobalValues.VersioningGrid.get(i)+"']"));
			Log.info("Verifying the "+ GlobalValues.VersioningGrid.get(i) + "- column in Assessment Builder Page grid");
		}
	}
	
	public void ValidateVersioningButtonGroup() {
		boolean RePublish = validateelementclickable((ConfReader.getInstance().getConfData("ButtonGroup", "AssessmentBuilder").replace("<AssName>", AssessmentName).replace("<button>", "Re-Publish")), driver);
		if(RePublish=true){
			Log.info("Successfully verified the Re-Publish button/image in Versioning row");
		}
		else {
			Log.info("!!!!! Failed to verify the Re-Publish button in Versioning grid !!!!");
		}
		
		boolean Edit = validateelementclickable((ConfReader.getInstance().getConfData("ButtonGroup", "AssessmentBuilder").replace("<AssName>", AssessmentName).replace("<button>", "Edit")), driver);
		if(Edit=true){
			Log.info("Successfully verified the Edit button/image in Versioning row");
		}
		else {
			Log.info("!!!!! Failed to verify the Edit button in Versioning grid !!!!");
		}
	}
	
	public void EditVersioningClick() throws Exception {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(3000);
		click(FieldType.xpath, (ConfReader.getInstance().getConfData("VersioningButtongroup", "Versioning").replace("<AssName>", AssessmentName).replace("<button>", "Edit")), driver);
		Log.info("Clicked on Edit Versioning button of the Assessment - " +AssessmentName);
	}
	
	public void VersioningEditModalWindow() {
		waitForLoadingToBecomeInvisible(driver);
		String Message = "Attempting to edit previously published version of "+AssessmentName+" will replace the current version. Are you sure want to proceed?";
		
		String header = get_text(ConfReader.getInstance().getConfData("VersioningWindowHeader", "Versioning"), driver).trim();
		assertEquals(header, "Edit Assessment Version");
		Log.info("Verified the Edit Assessment versioning grid header - " +header);
		
		String EditMsg = get_text(ConfReader.getInstance().getConfData("VersioningMessage", "Versioning"), driver).trim();
		assertEquals(EditMsg, Message);
		Log.info("Verified the Edit Assessment Versioning message");
		
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("VersoningButtons", "Versioning").replace("<button>", "Submit"), driver));
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("VersoningButtons", "Versioning").replace("<button>", "Cancel"), driver));
		Log.info("Verified the Submut and Cancel buttons in Edit Assessment versioning Modal window");		
	}
	
	public void RePublishClick() throws Exception {
		waitForLoadingToBecomeInvisible(driver);
		Thread.sleep(3000);
		click(FieldType.xpath, (ConfReader.getInstance().getConfData("VersioningButtongroup", "Versioning").replace("<AssName>", AssessmentName).replace("<button>", "Re-Publish")), driver);
		Log.info("Clicked on Re-Publish Versioning button of the Assessment - " +AssessmentName);
	}
	
	public void VersioningRePublishModalWindow() {
		waitForLoadingToBecomeInvisible(driver);
		String Message = "Attempting to Re-publish an earlier published version of "+AssessmentName+" will replace the current version. Are you sure want to proceed?";
		
		String header = get_text(ConfReader.getInstance().getConfData("VersioningWindowHeader", "Versioning"), driver).trim();
		assertEquals(header, "Re-publish Assessment");
		Log.info("Verified the Re-publish Assessment versioning grid header - " +header);
		
		String RepublishMsg = get_text(ConfReader.getInstance().getConfData("VersioningMessage", "Versioning"), driver).trim();
		assertEquals(RepublishMsg, Message);
		Log.info("Verified the Re-Publish Assessment Versioning message");
		
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("VersoningButtons", "Versioning").replace("<button>", "Submit"), driver));
		Assert.assertTrue(validateelementclickable(ConfReader.getInstance().getConfData("VersoningButtons", "Versioning").replace("<button>", "Cancel"), driver));
		Log.info("Verified the Submut and Cancel buttons in Edit Assessment versioning Modal window");		
	}

	public void ClickSubmit() {
		waitForLoadingToBecomeInvisible(driver);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Submit", "AssessmentBuilder").replace("<link>", "Submit"), driver);
		Log.info("Clicked on Submit button");
	}

	//Below method to verify the pagination(global_method)
	public void numberOfColumnsInGridForpagination(String gridName, int requiredRowCount) throws Exception {
		
		try {
			WebElement gridTitleElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("VersioningHeader","Versioning")));
			String gridTitle = gridTitleElement.getText();
			Log.info(gridTitle);
			Assert.assertEquals(gridTitle, "Previously Published Version", "Grid Header/Title is not matching");
			List<WebElement> gridRowsCount = driver.findElements(By.xpath(ConfReader.getInstance().getConfData("VersioningPagination","Versioning")));
			int rowCount = gridRowsCount.size();
	
			if (rowCount > requiredRowCount) {
				Log.info("Number of rows for pagination is more than required");
			} else {
				Log.info("Number of rows for pagination is as required");
				Log.info("**********verified pagination for Versioning Grid**********");		
			}
		} catch (Exception e) {	
			Log.info(e + " Grid Title is not matching");
			throw e;
		}
	}

	public void ValidateAssessment_EditVersioning() throws Exception{
		waitForLoadingToBecomeInvisible(driver);
		
		String AssName = get_text(ConfReader.getInstance().getConfData("VersionAssName", "Versioning").replace("<GridName>", GlobalValues.VersioningGrid.get(0)).replace("<AssName>", AssessmentName), driver);
System.out.println(AssName);		
		EditVersioningClick();
		ClickSubmit();
		
		String Assessment = get_text(ElementType.Textbox,"Assessment Name",driver);
System.out.println(Assessment);
		assertEquals(AssName, Assessment);
	}
	
	public void ValidateAssessment_RePublishVersioning() throws Exception{
		waitForLoadingToBecomeInvisible(driver);
		
		String AssName = get_text(ConfReader.getInstance().getConfData("VersionAssName", "Versioning").replace("<GridName>", GlobalValues.VersioningGrid.get(0)).replace("<AssName>", AssessmentName), driver);
System.out.println(AssName);		
		RePublishClick();
		ClickSubmit();
		
		String Assessment = get_text(ElementType.Textbox_P,"Assessment Name",driver);
System.out.println(Assessment);
		assertEquals(AssName, Assessment);
	}

	
}




