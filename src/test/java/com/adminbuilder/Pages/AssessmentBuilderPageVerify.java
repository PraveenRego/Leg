package com.adminbuilder.Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.configutility.ConfReader;

public class AssessmentBuilderPageVerify extends WebAction{
	
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("AssessmentBuilderPageVerify.class");
	
	public AssessmentBuilderPageVerify(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 30);
	}	
	
	public void AssessmentBuilderPageverify() throws Exception {
		
		waitForLoadingToBecomeInvisible(driver);
		
		//page header
		waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("AssessmentBuilderHeader","AssessmentBuilderPage"), driver);
		Log.info("Successfully verified the header of the Assessment Builder page header"); 
			
		//grid header
		waitForObjectToBecomeVisible(ConfReader.getInstance().getConfData("AssessmentBuilderGridHeader","AssessmentBuilderPage"), driver);
		Log.info("Successfully verified the header of the Assessment Builder page grid header");
		
		for(int i=0; i<GlobalValues.AssessmentBuilderPageGrid.size();i++)
		{
				driver.findElement(By.xpath("//span/nm-th[text()='"+GlobalValues.AssessmentBuilderPageGrid.get(i)+"']"));
				Log.info("Verifying the "+ GlobalValues.AssessmentBuilderPageGrid.get(i) + "- column in Assessment Builder Page grid");
		}
	
		Sorting(driver, 1, 1, 1);
		
	}
	
	public void numberOfColumnsInGridForpagination(String gridName, int requiredRowCount) throws Exception {
		
		try {
			WebElement gridTitleElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("AssessmentBuilderGridHeader","AssessmentBuilderPage")));
			String gridTitle = gridTitleElement.getText();
			Log.info(gridTitle);
			Assert.assertEquals(gridTitle, "Assessments/Forms", "Grid Header/Title is not matching");
			List<WebElement> gridRowsCount = driver.findElements(By.xpath(ConfReader.getInstance().getConfData("ABRowsInGrid","AssessmentBuilderPage")));
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
	
	public void filterAssessmentBuilderGrid() throws Exception {
		WebElement FilterGrid;
		
			try{
				WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilderPage")));
				if(noRecordFoundElement.isDisplayed()){
					String noRecordFoundText = noRecordFoundElement.getText();
					Log.info(noRecordFoundText + "- to perform Filtering on the grid");
					
				} 
			}catch(Exception e){
				Log.info("Records are present for Filtering");
				driver.findElement(By.xpath(ConfReader.getInstance().getConfData("FilterIcon","AssessmentBuilderPage"))).click();
			
			try {
				 FilterGrid = driver.findElement(By.xpath("//th[1]//div[@class='filterHolder']//input"));
				 FilterGrid.click();
				 FilterGrid.sendKeys("Assessment");
				 try{
						WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilderPage")));
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
						WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilderPage")));
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
						WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilderPage")));
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
						WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilderPage")));
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
						WebElement noRecordFoundElement = driver.findElement(By.xpath(ConfReader.getInstance().getConfData("NoRecordsFound","AssessmentBuilderPage")));
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
	driver.findElement(By.xpath(ConfReader.getInstance().getConfData("FilterIcon","AssessmentBuilderPage"))).click();
			}
	}

	public void Verify_ButtonGroups() {
		List<WebElement> gridRowsCount = driver.findElements(By.xpath(ConfReader.getInstance().getConfData("ABRowsInGrid","AssessmentBuilderPage")));
		int rowCount = gridRowsCount.size();

		for(int i=1; i<=rowCount; i++){
			try {
				WebElement Link = driver.findElement(By.xpath("//div[@class='scrollGrid']//tbody//tr["+ i +"]//td[6]//button[@title='Link']"));
				if(Link.isDisplayed()){
					Log.info("Successfully verified the Link button/image in "+i +" row");
					
				WebElement Publish = driver.findElement(By.xpath("//div[@class='scrollGrid']//tbody//tr["+ i +"]//td[7]//button[@title='Publish']"));
				if(Publish.isDisplayed()){
					Log.info("Successfully verified the Publish button/image in "+i +" row");
				}
				WebElement Edit = driver.findElement(By.xpath("//div[@class='scrollGrid']//tbody//tr["+ i +"]//td[8]//button[@title='Edit']"));
				if(Edit.isDisplayed()){
					Log.info("Successfully verified the Edit button/image in "+i +" row");
				}
				}
			}
			catch(Exception e) {
				Log.info("!!!! Link button/image not verifed in the row - " +i );
				Log.info("!!!! Publish button/image not verifed in the row - " +i );
				Log.info("!!!! Edit button/image not verifed in the row - " +i );
			}
		}
		
	}

	public void Sorting(WebDriver ldriver,int columnSortToStartIndex, int columnIndexVariable, int columnHeaderIndex) throws Exception {
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
}
