package com.adminbuilder.stepDefinition;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.adminbuilder.Pages.GlobalValues;
import com.adminbuilder.baseutility.Lighthousefunctions;
import com.adminbuilder.cucumber.TestContext;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Servicehooks {

	Logger Log = Logger.getLogger("Servicehooks.class");
	Lighthousefunctions lf;
	GlobalValues global;
	public static String lTestcaseName = "1";
	public static String lStartDateTime = "0";
	public static String lEndDateTime= "0";
	public static String lElapsedTime= "0";
	public static String lExecutionDate = "0";
	public static ArrayList<String> Testcasestatus = new ArrayList<>();
	
	TestContext testContext;
	public Servicehooks(TestContext context) {
		 testContext = context;
	}
	
	@Before
	public void beforeScenario(Scenario scenario) throws IOException {
		lExecutionDate = Lighthousefunctions.getInstance().getcurrentdate();
		String test = scenario.getId().substring(0, scenario.getId().indexOf(":"));
		if(!(lTestcaseName.equals(test))) {
			if(lTestcaseName.equals("1")){
				lTestcaseName = test.toUpperCase();
				
			}
		else {
				lEndDateTime = Lighthousefunctions.getInstance().getcurrentdatetime();

				lElapsedTime = Lighthousefunctions.getInstance().getelapsedtime(lStartDateTime, lEndDateTime);
				if(Testcasestatus.contains("Fail")) {
					Lighthousefunctions.getInstance().updateCSV("1", lTestcaseName, "FailCount");
					Lighthousefunctions.getInstance().updateCSV("0", lTestcaseName, "PassCount");
				}
				else {
					Lighthousefunctions.getInstance().updateCSV("0", lTestcaseName, "FailCount");
					Lighthousefunctions.getInstance().updateCSV("1", lTestcaseName, "PassCount");
				}
				
				Lighthousefunctions.getInstance().updateCSV(System.getProperty("user.name"), lTestcaseName, "UserId");
				Lighthousefunctions.getInstance().updateCSV(lStartDateTime.replace(" ", "T "), lTestcaseName, "StartTime");
				Lighthousefunctions.getInstance().updateCSV(lEndDateTime.replace(" ", "T "), lTestcaseName, "EndTime");
				Lighthousefunctions.getInstance().updateCSV(lElapsedTime, lTestcaseName, "ElapsedTime");
				Lighthousefunctions.getInstance().updateCSV(lExecutionDate, lTestcaseName, "DateOfExecution");
				lTestcaseName = test.toUpperCase();
			}
			lStartDateTime = Lighthousefunctions.getInstance().getcurrentdatetime();
		}
		
		Log.info("-------Scenario Started -------->  " +scenario.getName());
	}
	
	@After
	public void afterScenario(Scenario scenario) throws InterruptedException {
		
		if (scenario.isFailed()) {
			Log.info("!!!!Failed!!!! - " +scenario.getName());
			Testcasestatus.add("Fail");
		} 
		else  {
			Log.info("****Passed**** -  " + scenario.getName() );
			Testcasestatus.add("Pass");
		} 
		testContext.getWebDriverManager().closeDriver();
		Log.info("-------Scenario Ended -------->  " +scenario.getName());
		
		
	}
	
	


}
