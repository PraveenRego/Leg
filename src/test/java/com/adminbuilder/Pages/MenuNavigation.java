package com.adminbuilder.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adminbuilder.baseutility.WebAction;
import com.adminbuilder.baseutility.WebAction.FieldType;
import com.adminbuilder.configutility.ConfReader;

public class MenuNavigation extends WebAction{
	
	
	WebDriver driver;
	WebDriverWait wait = null;
	Logger Log = Logger.getLogger("LeftNavigation.class");
	
	public MenuNavigation(WebDriver ldriver) {
		this.driver = ldriver;
		wait = new WebDriverWait(driver, 90);
	}
	
	public void selectAssessmentbuilder() throws InterruptedException {
		
		waitForLoadingToBecomeInvisible(driver);
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("lnkAssessmentFormBuilder", "MenuNavigation"), driver);
		Log.info("Click on AssessmentFormBuilder button");
		if(waitForObjectToBecomeVisible( ConfReader.getInstance().getConfData("lnkAssessmentBuilder", "MenuNavigation"), driver)) {
			Log.info("AssessmentBuilder is displayed");
			click(FieldType.xpath, ConfReader.getInstance().getConfData("lnkAssessmentBuilder", "MenuNavigation"), driver);
			Log.info("Click on AssessmentBuilder button");
		}else {
			Log.info("AssessmentBuilder is not displayed");
		}
		waitForLoadingToBecomeInvisible(driver);
		
	 }
	
	public void ClickMarketSetup() {
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("MarketSetup","MenuNavigation"), driver);
					
		Log.info("Clicked on Market Setup in Client Admin Main Menu");
		
		for(int i=0; i<GlobalValues.MarketsSetup.size();i++)
		{
				driver.findElement(By.xpath("//span[text()='"+GlobalValues.MarketsSetup.get(i)+"']"));
				Log.info("Verifying the "+ GlobalValues.MarketsSetup.get(i) + "- value in Market Setup drop down in Client Admin Page");
		}
			
			
	}
	
	public void ClickUser_UserRoleManagement() {
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("UserRoleManagement","MenuNavigation"), driver);
		
		
		Log.info("Clicked on User & User Role Management in Client Admin Main Menu");
		
		for(int i=0; i<GlobalValues.UserUserRoleManagement.size();i++)
		{
				driver.findElement(By.xpath("//span[text()='"+GlobalValues.UserUserRoleManagement.get(i)+"']"));
				Log.info("Verifying the "+ GlobalValues.UserUserRoleManagement.get(i) + "- value in User and User Role Management drop down in Client Admin Page");
		}
	}
	
	public void ClickDashboards() {
		
		click(FieldType.xpath, ConfReader.getInstance().getConfData("Dashboards","MenuNavigation"), driver);
	
		
		Log.info("Clicked on Dashboards in Client Admin Main Menu");
		
		for(int i=0; i<GlobalValues.Dashboards.size();i++)
		{
				driver.findElement(By.xpath("//span[text()='"+GlobalValues.Dashboards.get(i)+"']"));
				Log.info("Verifying the "+ GlobalValues.Dashboards.get(i) + "- value in Dashbaords drop down in Client Admin Page");
		}
		
	}
	
	public void ClickWorkFlows_Tasks() {
		click(FieldType.xpath, ConfReader.getInstance().getConfData("WorkFlowTasks","MenuNavigation"), driver);
				
		Log.info("Clicked on WorkFlows & Tasks in Client Admin Main Menu");
		
		for(int i=0; i<GlobalValues.WorkFlows_Tasks.size();i++)
		{
				driver.findElement(By.xpath("//span[text()='"+GlobalValues.WorkFlows_Tasks.get(i)+"']"));
				Log.info("Verifying the "+ GlobalValues.WorkFlows_Tasks.get(i) + "- value in Workflows and Tasks drop down in Client Admin Page");
		}
	}
	
	public void ClickAssessment_Form_Builder() {
		click(FieldType.xpath, ConfReader.getInstance().getConfData("AssessmentFormBuilder","MenuNavigation"), driver);
	
		
		Log.info("Clicked on Assessment/Form Builder in Client Admin Main Menu");
		
		for(int i=0; i<GlobalValues.Assessment_Form_Builder.size();i++)
		{
				driver.findElement(By.xpath("//span[text()='"+GlobalValues.Assessment_Form_Builder.get(i)+"']"));
				Log.info("Verifying the "+ GlobalValues.Assessment_Form_Builder.get(i) + "- value in Assessment/Forms Builder drop down in Client Admin Page");
		}
	}
	
	public void ClickAssessment_Builder() throws InterruptedException {
		Thread.sleep(4000);
		click(FieldType.xpath, ConfReader.getInstance().getConfData("AssessmentBuilder","MenuNavigation"), driver);

		
		Log.info("Clicked on Assessment Builder in Assessment/Forms Builder menu");
		
	}

}