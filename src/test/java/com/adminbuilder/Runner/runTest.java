
package  com.adminbuilder.Runner;


import java.io.IOException;


import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.adminbuilder.baseutility.Lighthousefunctions;
import com.adminbuilder.baseutility.Report;
import com.adminbuilder.configutility.ConfReader;
import com.adminbuilder.cucumber.TestContext;
import com.adminbuilder.mailUtility.MailGenerator;
import com.adminbuilder.mailUtility.MailParser;
import com.adminbuilder.stepDefinition.Servicehooks;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		 features = "Feature/CMDM30416.feature", 

 glue= {"com.adminbuilder.stepDefinition"} ,//stepdefinition package name

plugin = { "com.cucumber.listener.ExtentCucumberFormatter:Reports/AdminBuilder.html"},
monochrome = true

 )

public class runTest {

	TestContext testContext;
	public runTest(TestContext context) {
		 testContext = context;
	}

	@BeforeClass
	public static void setupDriver() throws IOException
	{
		PropertyConfigurator.configure("./log4j.properties");
		ConfReader.getInstance().loadConfData();
		Lighthousefunctions.getInstance().loadCSV();
	}



	@AfterClass
	public static void writeExtentReport() throws IOException, InterruptedException
	{
		Servicehooks.lEndDateTime = Lighthousefunctions.getInstance().getcurrentdatetime();

		Servicehooks.lElapsedTime = Lighthousefunctions.getInstance().getelapsedtime(Servicehooks.lStartDateTime, Servicehooks.lEndDateTime);
		if(Servicehooks.Testcasestatus.contains("Fail")) {
			Lighthousefunctions.getInstance().updateCSV("1", Servicehooks.lTestcaseName, "FailCount");
			Lighthousefunctions.getInstance().updateCSV("0", Servicehooks.lTestcaseName, "PassCount");
		}
		else {
			Lighthousefunctions.getInstance().updateCSV("0", Servicehooks.lTestcaseName, "FailCount");
			Lighthousefunctions.getInstance().updateCSV("1", Servicehooks.lTestcaseName, "PassCount");
		}
		Lighthousefunctions.getInstance().updateCSV(System.getProperty("user.name"), Servicehooks.lTestcaseName, "UserId");
		Lighthousefunctions.getInstance().updateCSV(Servicehooks.lStartDateTime.replace(" ", "T "), Servicehooks.lTestcaseName, "StartTime");
		Lighthousefunctions.getInstance().updateCSV(Servicehooks.lEndDateTime.replace(" ", "T "), Servicehooks.lTestcaseName, "EndTime");
		Lighthousefunctions.getInstance().updateCSV(Servicehooks.lElapsedTime, Servicehooks.lTestcaseName, "ElapsedTime");
		Lighthousefunctions.getInstance().updateCSV(Servicehooks.lExecutionDate, Servicehooks.lTestcaseName, "DateOfExecution");

		Lighthousefunctions.getInstance().writecsvData();
		Report.createInstance();
		MailGenerator.getInstance().setMailGenerator(new MailParser());

	}
}

