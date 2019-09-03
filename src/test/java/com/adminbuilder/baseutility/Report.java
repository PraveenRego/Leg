package com.adminbuilder.baseutility;

import java.io.File;


import com.cucumber.listener.Reporter;



public class Report {
	 
	
    public static void createInstance() throws InterruptedException {
    	Reporter.loadXMLConfig(new File("./Reports/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Thread.sleep(3000);
//		Reporter.setTestRunnerOutput("Sample test output message");
    }
	
   
}

